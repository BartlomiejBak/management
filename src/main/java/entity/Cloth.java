package entity;

import entity.enums.Color;
import entity.enums.Material;
import entity.enums.ProductSeparators;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("cloth")
public class Cloth extends Product {
    private String size;
    private Material material;
    private String productType = "C";

    public Cloth(int id, String productName, double price, double weight, Color color, int productCount, String size, Material material) {
        super(id, productName, price, weight, color, productCount);
        this.size = size;
        this.material = material;
    }

    public Cloth() {
    }


    public Cloth(String productName, double price, double weight, Color color, int productCount, String size, Material material) {
        super(productName, price, weight, color, productCount);
        this.size = size;
        this.material = material;
    }

    @Override
    public String getProductType() {
        return productType;
    }

    @Override
    public void setProductType(String productType) {
        this.productType = productType;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    @Override
    public String toString() {
        return ProductSeparators.ClOTH_ID + ProductSeparators.PRODUCT_SEPARATOR.toString()
                + getBasicProductString() + ProductSeparators.PRODUCT_SEPARATOR.toString()
                + size + ProductSeparators.PRODUCT_SEPARATOR.toString()
                + material;
    }
}
