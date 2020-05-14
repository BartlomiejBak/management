package entity;

public class Boots extends Product {
    public static final String PRODUCT_TYPE = "B";
    private final double size;
    private final boolean isNaturalLeather;

    public Boots(int id, String productName, double price, double weight, String color, int productCount, double size, boolean isNaturalLeather) {
        super(id, productName, price, weight, color, productCount);
        this.size = size;
        this.isNaturalLeather = isNaturalLeather;
    }

    public double getSize() {
        return size;
    }

    public boolean isNaturalLeather() {
        return isNaturalLeather;
    }

    @Override
    public String toString() {
        return PRODUCT_TYPE + DELIMITER
                + getBasicProductString() + DELIMITER
                + size + DELIMITER
                + isNaturalLeather;
    }
}
