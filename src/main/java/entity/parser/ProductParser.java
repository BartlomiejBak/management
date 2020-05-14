package entity.parser;

import entity.Boots;
import entity.Cloth;
import entity.Product;

public class ProductParser {

    public static Product stringToProduct(String productStr) {
        String[] productInformation = productStr.split(Product.DELIMITER);

        switch (productInformation[0]) {
            case "P":
                return convertToProduct(productInformation);
            case "C":
                return convertToCloth(productInformation);
            case "B":
                return convertToBoots(productInformation);
        }

        return null;
    }

    private static Boots convertToBoots(String[] productInformation) {

        int id = Integer.parseInt(productInformation[1]);
        String productName = productInformation[2];
        double price = Double.parseDouble(productInformation[3]);
        double weight = Double.parseDouble(productInformation[4]);
        String color = productInformation[5];
        int productCount = Integer.parseInt(productInformation[6]);
        int size = Integer.parseInt(productInformation[7]);
        boolean isNaturalSkin = Boolean.parseBoolean(productInformation[8]);

        return new Boots(id, productName, price, weight, color, productCount, size, isNaturalSkin);
    }

    private static Cloth convertToCloth(String[] productInformation) {

        int id = Integer.parseInt(productInformation[1]);
        String productName = productInformation[2];
        double price = Double.parseDouble(productInformation[3]);
        double weight = Double.parseDouble(productInformation[4]);
        String color = productInformation[5];
        int productCount = Integer.parseInt(productInformation[6]);
        String size = productInformation[7];
        String material = productInformation[8];

        return new Cloth(id, productName, price, weight, color, productCount, size, material);
    }

    private static Product convertToProduct(String[] productInformation) {

        int id = Integer.parseInt(productInformation[1]);
        String productName = productInformation[2];
        double price = Double.parseDouble(productInformation[3]);
        double weight = Double.parseDouble(productInformation[4]);
        String color = productInformation[5];
        int productCount = Integer.parseInt(productInformation[6]);

        return new Product(id, productName, price, weight, color, productCount);
    }
}
