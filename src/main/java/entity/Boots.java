package entity;

import entity.enums.Color;
import entity.enums.ProductSeparators;
import entity.enums.SkinType;

public class Boots extends Product {
    private double size;
    private SkinType skinType;

    public Boots(int id, String productName, double price, double weight, Color color, int productCount, double size, SkinType skinType) {
        super(id, productName, price, weight, color, productCount);
        this.size = size;
        this.skinType = skinType;
    }

    public double getSize() {
        return size;
    }

    public SkinType getSkinType() {
        return skinType;
    }

    @Override
    public String toString() {
        return ProductSeparators.BOOTS_ID + ProductSeparators.PRODUCT_SEPARATOR.toString()
                + getBasicProductString() + ProductSeparators.PRODUCT_SEPARATOR.toString()
                + size + ProductSeparators.PRODUCT_SEPARATOR.toString()
                + skinType;
    }
}
