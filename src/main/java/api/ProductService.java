package api;

import entity.Product;

import java.util.List;

public interface ProductService {

    List<Product> getAllProducts();
    int getNumberOfProducts();
    Product getProductById(int id);
    Product getProductByName(String name);
    boolean isProductOnStock(String productName);
    boolean isNameOnList(String productName);
    boolean isIdOnList(int id);
}
