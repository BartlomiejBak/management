package dao;

import api.ProductDao;
import entity.Product;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDaoImpl implements ProductDao {
    String fileName;
    File file;

    public ProductDaoImpl(String fileName) {
        this.fileName = fileName;
        this.file = new File(fileName);
    }

    public ProductDaoImpl() {
    }

    @Override
    public void saveProduct(Product product) throws IOException {
        List<Product> productList = getAllProducts();
        productList.add(product);
        saveProducts(productList);
    }

    @Override
    public void saveProducts(List<Product> products) throws FileNotFoundException {
        PrintWriter printWriter = new PrintWriter(file);
        for (Product product : products) {
            printWriter.println(product.toString());
        }
        printWriter.close();
    }

    @Override
    public void removeProductById(int productId) throws IOException {
        List<Product> productList = getAllProducts();
        for (Product product : productList) {
            if (product.getId() == productId) {
                productList.remove(product);
            }
        }
        saveProducts(productList);
    }

    @Override
    public void removeProductByName(String productName) throws IOException {
        List<Product> productList = getAllProducts();
        for (Product product : productList) {
            if (product.getProductName().equals(productName)) {
                productList.remove(product);
            }
        }
        saveProducts(productList);
    }

    @Override
    public List<Product> getAllProducts() throws IOException {
        List<Product> products = new ArrayList<>();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));

        String readLine = bufferedReader.readLine();
        while(readLine != null) {
            Product product = convertToProduct(readLine);
            products.add(product);
            readLine = bufferedReader.readLine();
        }
        bufferedReader.close();

        return products;
    }

    private static Product convertToProduct(String productStr) {
        String[] productInformation = productStr.split(Product.DELIMITER);

        int id = Integer.parseInt(productInformation[0]);
        String productName = productInformation[1];
        double price = Double.parseDouble(productInformation[2]);
        double weight = Double.parseDouble(productInformation[3]);
        String color = productInformation[4];
        int productCount = Integer.parseInt(productInformation[5]);

        return new Product(id, productName, price, weight, color, productCount);
    }

    @Override
    public Product getProductById(int productId) throws IOException {
        List<Product> productList = getAllProducts();
        for (Product product : productList) {
            if (product.getId() == productId) {
                return product;
            }
        }
        return null;
    }

    @Override
    public Product getProductByProductName(String productName) throws IOException {
        List<Product> productList = getAllProducts();
        for (Product product : productList) {
            if (product.getProductName().equals(productName)) {
                return product;
            }
        }
        return null;
    }
}
