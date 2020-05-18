package api;

import entity.Product;

import java.io.IOException;
import java.util.List;

public interface ProductService {

    List<Product> getAllProducts() throws IOException;
    int getCountProducts() throws IOException;
    Product getProductById(int id) throws IOException;
    Product getProductByProductName(String name) throws IOException;

    boolean isProductOnWarehouse(String productName) throws IOException;
    boolean isProductExist(String productName) throws IOException;
    boolean isProductExist(int id) throws IOException;

    boolean saveProduct(Product product, String productType);

    boolean deleteProduct(String productName);
}
