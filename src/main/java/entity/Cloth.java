package entity;

public class Cloth extends Product {
    private final String size;
    private final String material;
    
    public Cloth(int id, String productName, double price, double weight, String color, int productCount, String size, String material) {
        super(id, productName, price, weight, color, productCount);
        this.size = size;
        this.material = material;
    }

    public String getSize() {
        return size;
    }

    public String getMaterial() {
        return material;
    }

    @Override
    public String toString() {
        return super.toString() + DELIMITER
                + size + DELIMITER
                + material;
    }
}
