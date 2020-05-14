package entity;

public class Product {
    public static final String DELIMITER = "#";
    public static final String PRODUCT_TYPE = "P";
    private final int id;
    private final String productName;
    private double price;
    private final double weight;
    private final String color;
    private int productCount;

    public Product(int id, String productName,
                   double price, double weight,
                   String color, int productCount) {
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

    public String getColor() {
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
        return id + DELIMITER
                + productName + DELIMITER
                + price + DELIMITER
                + weight + DELIMITER
                + color + DELIMITER
                + productCount;
    }
    @Override
    public String toString() {
        return PRODUCT_TYPE + DELIMITER
                + getBasicProductString();
    }
}
