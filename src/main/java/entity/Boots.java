package entity;

public class Boots extends Product {
    public static String productType = "B";
    private double size;
    private boolean isNaturalSkin;

    public Boots(int id, String productName, double price, double weight, String color, int productCount, double size, boolean isNaturalSkin) {
        super(id, productName, price, weight, color, productCount);
        this.size = size;
        this.isNaturalSkin = isNaturalSkin;
    }

    public double getSize() {
        return size;
    }

    public boolean isNaturalSkin() {
        return isNaturalSkin;
    }

    @Override
    public String toString() {
        return super.toString() + DELIMITER
                + size + DELIMITER
                + isNaturalSkin;
    }
}
