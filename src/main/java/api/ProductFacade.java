package api;

import entity.Product;

import java.io.IOException;

public interface ProductFacade {
    boolean addProduct(Product product);
    boolean showAllProducts() throws IOException;
    boolean deleteProduct(String productName);

}
