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
        return null;
    }

    @Override
    public int getNumberOfProducts() {
        return 0;
    }

    @Override
    public Product getProductById(int id) {
        return null;
    }

    @Override
    public boolean isMoreThanZero(String productName) {
        return false;
    }

    @Override
    public boolean isNameOnList(String productName) {
        return false;
    }

    @Override
    public boolean isIdOnList(int id) {
        return false;
    }
}
