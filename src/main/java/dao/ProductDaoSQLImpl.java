package dao;

import api.ProductDao;
import entity.Boots;
import entity.Cloth;
import entity.Product;
import entity.enums.Color;
import entity.enums.Material;
import entity.enums.SkinType;
import entity.parser.ColorParser;
import entity.parser.MaterialParser;
import entity.parser.SkinParser;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDaoSQLImpl implements ProductDao {
    private static ProductDaoSQLImpl instance;
    private final String databaseName = "management";
    private final String tableName = "products";
    private final String user = "admin";
    private final String password = "admin";
    private Connection connection;

    public ProductDaoSQLImpl() {
        init();
    }

    public static ProductDaoSQLImpl getInstance() {
        if (instance == null) {
            instance = new ProductDaoSQLImpl();
        }
        return instance;
    }

    private void init() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost/"+databaseName+
                            "?useSSL=false&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=Europe/Moscow",
                    user, password);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void saveProduct(Product product, String productType) {
        PreparedStatement statement;
        try {
            String query = "insert into " + tableName + " (ID, productType, productName, price," +
                    "weight, color, quantity, shoeSize, skinType, clothSize, material) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            statement = connection.prepareStatement(query);

            statement.setInt(1, product.getId());
            statement.setString(2, productType);
            statement.setString(3, product.getProductName());
            statement.setDouble(4, product.getPrice());
            statement.setDouble(5, product.getWeight());
            statement.setString(6, product.getColor().toString());
            statement.setInt(7, product.getProductCount());

            switch (productType) {
                case "B":
                    Boots boots = (Boots) product;
                    statement.setDouble(8, boots.getShoeSize());
                    statement.setString(9, boots.getSkinType().toString());
                    statement.setString(10, null);
                    statement.setString(11,null);
                    break;
                case "C":
                    Cloth cloth = (Cloth) product;
                    statement.setNull(8, java.sql.Types.NULL);
                    statement.setString(9, null);
                    statement.setString(10, cloth.getSize());
                    statement.setString(11, cloth.getMaterial().toString());
                    break;
                default:
                    statement.setNull(8, java.sql.Types.NULL);
                    statement.setString(9, null);
                    statement.setString(10, null);
                    statement.setString(11,null);
                    break;
            }
            statement.execute();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void saveProducts(List<Product> products) {
        for (Product product : products) {
            if (product.getProductType().equals("B")){
                saveProduct(product, "B");
            } else if (product.getProductType().equals("C")) {
                saveProduct(product, "C");
            } else {
                saveProduct(product, "P");
            }
        }
    }

    @Override
    public void removeProductById(int productId) {
        PreparedStatement statement;
        try {
            String query = "delete from " + tableName + " where ID = " + productId;
            statement = connection.prepareStatement(query);
            statement.execute();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void removeProductByName(String productName) {
        PreparedStatement statement;
        try {
            String query = "delete from " + tableName + " where productName = \"" + productName + "\"";
            statement = connection.prepareStatement(query);
            statement.execute();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Product> getAllProducts() {
        List<Product> products = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            String query = "select * from " + tableName;
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {

                int id = resultSet.getInt("ID");
                String productType = resultSet.getString("productType");
                String productName = resultSet.getString("productName");
                double price = resultSet.getDouble("price");
                double weight = resultSet.getDouble("weight");
                Color color = ColorParser.parseColor(resultSet.getString("color"));
                int productCount = resultSet.getInt("quantity");
                double shoeSize = resultSet.getDouble("shoeSize");
                SkinType skinType = null;
                if (resultSet.getString("skinType") != null) {
                    skinType = SkinParser.parseSkinType(resultSet.getString("skinType"));
                }
                String clothSize = resultSet.getString("clothSize");
                Material material = null;
                if (resultSet.getString("material") != null) {
                    material = MaterialParser.parseMaterial(resultSet.getString("material"));
                }

                Product product = null;

                switch (productType) {
                    case "P":
                        product = new Product(id, productName, price, weight, color, productCount);
                        break;
                    case "B":
                        product = new Boots(id, productName, price, weight, color, productCount, shoeSize, skinType);
                        break;
                    case "C":
                        product = new Cloth(id, productName, price, weight, color, productCount, clothSize, material);
                        break;
                }
                products.add(product);
            }
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }
}
