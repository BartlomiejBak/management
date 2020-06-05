package facade;

import api.ProductFacade;
import api.ProductService;
import entity.Product;
import service.ProductServiceImpl;

import java.io.IOException;

public class ProductFacadeImpl implements ProductFacade {
    private final ProductService productService = ProductServiceImpl.getInstance();
    private static ProductFacadeImpl instance = null;

    public static ProductFacadeImpl getInstance() {
        if (instance == null) {
            instance = new ProductFacadeImpl();
        }
        return instance;
    }

    @Override
    public boolean addProduct(Product product, String productType) {
        return productService.saveProduct(product, productType);
    }

    @Override
    public boolean showAllProducts() throws IOException {
        System.out.println(productService.getAllProducts());
        return false;
    }

    @Override
    public boolean deleteProduct(String productName) {
        productService.deleteProduct(productName);
        return false;
    }
}