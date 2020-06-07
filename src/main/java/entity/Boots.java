package entity;

import entity.enums.Color;
import entity.enums.ProductSeparators;
import entity.enums.SkinType;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Boot")
public class Boots extends Product {
    private double shoeSize;
    private SkinType skinType;
    private String productType = "B";

    public Boots(int id, String productName, double price, double weight, Color color, int productCount, double shoeSize, SkinType skinType) {
        super(id, productName, price, weight, color, productCount);
        this.shoeSize = shoeSize;
        this.skinType = skinType;
    }

    public Boots() {
    }

    public Boots(String productName, double price, double weight, Color color, int productCount, double shoeSize, SkinType skinType) {
        super(productName, price, weight, color, productCount);
        this.shoeSize = shoeSize;
        this.skinType = skinType;
    }

    @Override
    public String getProductType() {
        return productType;
    }

    @Override
    public void setProductType(String productType) {
        this.productType = productType;
    }

    public double getShoeSize() {
        return shoeSize;
    }

    public void setShoeSize(double size) {
        this.shoeSize = size;
    }

    public SkinType getSkinType() {
        return skinType;
    }

    public void setSkinType(SkinType skinType) {
        this.skinType = skinType;
    }

    @Override
    public String toString() {
        return ProductSeparators.BOOTS_ID + ProductSeparators.PRODUCT_SEPARATOR.toString()
                + getBasicProductString() + ProductSeparators.PRODUCT_SEPARATOR.toString()
                + shoeSize + ProductSeparators.PRODUCT_SEPARATOR.toString()
                + skinType;
    }
}
