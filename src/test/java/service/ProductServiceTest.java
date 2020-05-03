package service;

import entity.Boots;
import entity.Cloth;
import entity.Product;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ProductServiceTest {
    ProductServiceImpl productService;
    List<Product> products = new ArrayList<>();
    Product firstCloth = new Cloth(1, "firstCloth", 100.0, 10.0, "blue",16,
            "medium", "wool");
    Product secondCloth = new Cloth(2, "secondCloth", 140.0, 1.5, "red", 15,
            "large", "cotton");
    Product firstBoot = new Boots(3, "kubota", 1000.0, 1,"black",2,
            43, true);
    Product secondBoot = new Boots(4, "adidas", 155, 11, "yellow", 0,
            41, false);
    public void initList() {
        products.add(firstCloth);
        products.add(secondCloth);
        products.add(firstBoot);
        products.add(secondBoot);
    }

    @Test
    public void testGetAllProducts() {
        initList();
        productService = new ProductServiceImpl(products);

        Assert.assertEquals(productService.getAllProducts(), products);
    }

    @Test
    public void testGetNumberOfProducts() {
        initList();
        productService = new ProductServiceImpl(products);

        int numberOfProducts = productService.getNumberOfProducts();

        Assert.assertNotEquals(4, numberOfProducts);
        Assert.assertEquals(33, numberOfProducts);
    }

    @Test
    public void testGetProductById() {
        initList();
        productService = new ProductServiceImpl(products);

        Product product = productService.getProductById(1);
        Product noProduct = productService.getProductById(6);

        Assert.assertEquals(product, firstCloth);
        Assert.assertNull(noProduct);
    }

    @Test
    public void testIsMoreThanZero() {
        initList();
        productService = new ProductServiceImpl(products);

        boolean product = productService.isMoreThanZero("kubota");
        boolean noProduct = productService.isMoreThanZero("adidas");

        Assert.assertTrue(product);
        Assert.assertFalse(noProduct);
    }

    @Test
    public void testIsNameOnList() {
        initList();
        productService = new ProductServiceImpl(products);

        boolean onList = productService.isNameOnList("adidas");
        boolean notOnList = productService.isNameOnList("adas");

        Assert.assertTrue(onList);
        Assert.assertFalse(notOnList);
    }

    @Test
    public void testIsIdOnList() {
        initList();
        productService = new ProductServiceImpl(products);

        boolean onList = productService.isIdOnList(1);
        boolean notOnList = productService.isIdOnList(7);

        Assert.assertTrue(onList);
        Assert.assertFalse(notOnList);
    }
}