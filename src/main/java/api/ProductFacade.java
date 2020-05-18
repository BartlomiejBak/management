package api;

import entity.Product;

import java.io.IOException;

public interface ProductFacade {
    boolean addProduct(Product product, String productType);
    boolean showAllProducts() throws IOException;
    boolean deleteProduct(String productName);

}
