package dao;

import api.ProductDao;
import entity.Boots;
import entity.Cloth;
import entity.Product;
import entity.User;

import java.io.IOException;
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
            String query = "insert into " + tableName + " (ID, productName, price," +
                    "weight, color, quantity, shoeSize, leatherType, clothSize, material) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            statement = connection.prepareStatement(query);

            statement.setInt(1, product.getId());
            statement.setString(2, product.getProductName());
            statement.setDouble(3, product.getPrice());
            statement.setDouble(4, product.getWeight());
            statement.setString(5, product.getColor().toString());
            statement.setInt(6, product.getProductCount());

            switch (productType) {
                case "B":
                    Boots boots = (Boots) product;
                    statement.setDouble(7, boots.getSize());
                    statement.setString(8, boots.getSkinType().toString());
                    statement.setString(9, null);
                    statement.setString(10,null);
                    break;
                case "C":
                    Cloth cloth = (Cloth) product;
                    statement.setDouble(7, Double.NaN);
                    statement.setString(8, null);
                    statement.setString(9, cloth.getSize());
                    statement.setString(10,cloth.getMaterial().toString());
                default:
                    statement.setDouble(7, Double.NaN);
                    statement.setString(8, null);
                    statement.setString(9, null);
                    statement.setString(10,null);
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
            Boots boots = (Boots) product;
            Cloth cloth = (Cloth) product;
            if (boots.getSize() > 0){
                saveProduct(product, "B");
            } else if (cloth.getSize() != null) {
                saveProduct(product, "C");
            } else {
                saveProduct(product, "P");
            }

        }
    }

    @Override
    public void removeProductById(int productId) throws IOException {
//todo

    }

    @Override
    public void removeProductByName(String productName) throws IOException {
//todo
    }

    @Override
    public List<Product> getAllProducts() throws IOException {
        List<Product> products = new ArrayList<>();
        Statement statement = null;
        try {
            statement = connection.createStatement();
            String query = "select * from " + tableName;
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                //todo

                int ID = resultSet.getInt("ID");
                String login = resultSet.getString("login");
                String password = resultSet.getString("password");

                Product product = new Product(ID, login, password);
                products.add(product);
            }
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return products;
    }
}
