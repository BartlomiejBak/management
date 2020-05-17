package entity;

import entity.enums.Color;
import entity.enums.Material;
import entity.enums.ProductSeparators;

public class Cloth extends Product {
    private String size;
    private Material material;
    
    public Cloth(int id, String productName, double price, double weight, Color color, int productCount, String size, Material material) {
        super(id, productName, price, weight, color, productCount);
        this.size = size;
        this.material = material;
    }

    public String getSize() {
        return size;
    }

    public Material getMaterial() {
        return material;
    }

    @Override
    public String toString() {
        return ProductSeparators.ClOTH_ID + ProductSeparators.PRODUCT_SEPARATOR.toString()
                + getBasicProductString() + ProductSeparators.PRODUCT_SEPARATOR.toString()
                + size + ProductSeparators.PRODUCT_SEPARATOR.toString()
                + material;
    }
}
