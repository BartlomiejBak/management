package entity;

import entity.enums.Color;
import entity.enums.ProductSeparators;

public class Product {

    private int id;
    private String productName;
    private double price;
    private double weight;
    private Color color;
    private int productCount;

    public Product(int id, String productName,
                   double price, double weight,
                   Color color, int productCount) {
        this.id = id;
        this.productName = productName;
        this.price = price;
        this.weight = weight;
        this.color = color;
        this.productCount = productCount;
    }

    public int getId() {
        return id;
    }

    public String getProductName() {
        return productName;
    }

    public double getPrice() {
        return price;
    }

    public double getWeight() {
        return weight;
    }

    public Color getColor() {
        return color;
    }

    public int getProductCount() {
        return productCount;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setProductCount(int productCount) {
        this.productCount = productCount;
    }

    public String getBasicProductString() {
        return id + ProductSeparators.PRODUCT_SEPARATOR.toString()
                + productName + ProductSeparators.PRODUCT_SEPARATOR.toString()
                + price + ProductSeparators.PRODUCT_SEPARATOR.toString()
                + weight + ProductSeparators.PRODUCT_SEPARATOR.toString()
                + color + ProductSeparators.PRODUCT_SEPARATOR.toString()
                + productCount;
    }
    @Override
    public String toString() {
        return ProductSeparators.PRODUCT_ID + ProductSeparators.PRODUCT_SEPARATOR.toString()
                + getBasicProductString();
    }
}
