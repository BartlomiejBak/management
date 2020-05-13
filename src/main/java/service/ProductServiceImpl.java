package service;

import api.ProductDao;
import api.ProductService;
import dao.ProductDaoImpl;
import entity.Product;
import validator.ProductValidator;

import java.io.IOException;
import java.util.List;

public class ProductServiceImpl implements ProductService {
    private static ProductServiceImpl instance = null;
    private ProductDao productDao = ProductDaoImpl.getInstance();
    private ProductValidator productValidator = ProductValidator.getInstance();

    private ProductServiceImpl() throws IOException {
    }

    public static ProductServiceImpl getInstance() throws IOException {
        if (instance == null) {
            instance = new ProductServiceImpl();
        }
        return instance;
    }

    @Override
    public List<Product> getAllProducts() throws IOException {
        return productDao.getAllProducts();
    }

    @Override
    public int getCountProducts() throws IOException {
        return getAllProducts().size();
    }

    @Override
    public Product getProductById(int id) throws IOException {
        List<Product> products = productDao.getAllProducts();
        for (Product product : products) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }

    @Override
    public Product getProductByProductName(String name) throws IOException {
        List<Product> products = productDao.getAllProducts();
        for (Product product : products) {
            if (product.getProductName().equals(name)) {
                return product;
            }
        }
        return null;
    }

    @Override
    public boolean isProductOnWarehouse(String productName) throws IOException {
        return isProductExist(productName) && getProductByProductName(productName).getProductCount() > 0;
    }

    @Override
    public boolean isProductExist(String productName) throws IOException {
        Product product = getProductByProductName(productName);
        return product != null;
    }

    @Override
    public boolean isProductExist(int id) throws IOException {
        Product product = getProductById(id);
        return product != null;
    }

    @Override
    public boolean saveProduct(Product product) {
        return false;
    }
}
