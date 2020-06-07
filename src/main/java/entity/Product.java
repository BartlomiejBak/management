package entity;

import entity.enums.Color;
import entity.enums.ProductSeparators;

import javax.persistence.*;

@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue
    private int id;
    private String productName;
    private double price;
    private double weight;
    private Color color;
    private int productCount;
    private String productType = "P";

    public Product() {
    }

    public Product(String productName, double price, double weight, Color color, int productCount) {
        this.productName = productName;
        this.price = price;
        this.weight = weight;
        this.color = color;
        this.productCount = productCount;
    }

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

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getProductCount() {
        return productCount;
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
