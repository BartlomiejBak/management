package dao;

import api.ProductDao;
import entity.Product;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
    public void saveProduct(Product product) {
        PreparedStatement statement;
        try {
            String query = "insert into " + tableName + " (ID, productName, price," +
                    "weight, color, quantity,  ) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            statement.setInt(1, product.getId());

        }
    }

    @Override
    public void saveProducts(List<Product> products) {
        for (Product product : products) {
            saveProduct(product);
        }
    }

    @Override
    public void removeProductById(int productId) throws IOException {

    }

    @Override
    public void removeProductByName(String productName) throws IOException {

    }

    @Override
    public List<Product> getAllProducts() throws IOException {
        return null;
    }
}
