package api;

import entity.Product;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public interface ProductDao {

    void saveProduct(Product product, String productType) throws IOException;
    void saveProducts(List<Product> products) throws FileNotFoundException;

    void removeProductById(int productId) throws IOException;
    void removeProductByName(String productName) throws IOException;

    List<Product> getAllProducts() throws IOException;
}
