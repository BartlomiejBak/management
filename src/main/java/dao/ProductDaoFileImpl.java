package dao;

import api.ProductDao;
import entity.Product;
import entity.parser.ProductParser;
import utils.FileUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDaoFileImpl implements ProductDao {
    private static final String fileName = "products.data";
    private static ProductDaoFileImpl instance = null;

    private ProductDaoFileImpl() {
        try {
            FileUtils.createNewFile(fileName);
        } catch (IOException e) {
            System.out.println("Error with file path");
            System.exit(-1);
        }
    }

    public static ProductDaoFileImpl getInstance() {
        if (instance == null) {
            instance = new ProductDaoFileImpl();
        }
        return instance;
    }

    @Override
    public void saveProduct(Product product, String productType) throws IOException {
        List<Product> productList = getAllProducts();
        productList.add(product);
        saveProducts(productList);
    }

    @Override
    public void saveProducts(List<Product> products) throws FileNotFoundException {
        FileUtils.clearFile(fileName);
        PrintWriter printWriter = new PrintWriter(new FileOutputStream(fileName, true));
        for (Product product : products) {
            printWriter.write(product.toString() + "\n");
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
            Product product = ProductParser.stringToProduct(readLine);
            if (product != null) {
                products.add(product);
            }
            readLine = bufferedReader.readLine();
        }
        bufferedReader.close();

        return products;
    }

}
