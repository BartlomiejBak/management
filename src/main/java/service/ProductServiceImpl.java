package service;

import api.ProductService;
import entity.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductServiceImpl implements ProductService {
    List<Product> products = new ArrayList<>();

    public ProductServiceImpl() {
    }

    public ProductServiceImpl(List<Product> products) {
        this.products = products;
    }


    @Override
    public List<Product> getAllProducts() {
        return products;
    }

    @Override
    public int getNumberOfProducts() {
        int numberOfProducts = 0;
        for (Product product : products) {
            numberOfProducts += product.getProductCount();
        }
        return numberOfProducts;
    }

    @Override
    public Product getProductById(int id) {
        Product product = null;
        for (Product product1 : products) {
            if (product1.getId() == id) {
                product = product1;
                break;
            }
        }
        return product;
    }

    @Override
    public Product getProductByName(String name) {
        Product product = null;
        for (Product product1 : products) {
            if (product1.getProductName().equals(name)) {
                product = product1;
                break;
            }
        }
        return product;
    }

    @Override
    public boolean isProductOnStock(String productName) {
        boolean result = false;
        for (Product product : products) {
            if (product.getProductName().equals(productName)) {
                result = product.getProductCount() > 0;
                break;
            }
        }
        return result;
    }

    @Override
    public boolean isNameOnList(String productName) {
        boolean result = false;
        for (Product product : products) {
            if (product.getProductName().equals(productName)) {
                result = true;
                break;
            }
        }
        return result;
    }

    @Override
    public boolean isIdOnList(int id) {
        boolean result = false;
        for (Product product : products) {
            if (product.getId() == id) {
                result = true;
                break;
            }
        }
        return result;
    }
}
