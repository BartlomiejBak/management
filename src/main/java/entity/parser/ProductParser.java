package entity.parser;

import entity.Boots;
import entity.Cloth;
import entity.Product;
import entity.enums.Color;
import entity.enums.Material;
import entity.enums.ProductSeparators;
import entity.enums.SkinType;

public class ProductParser {

    public static Product stringToProduct(String productStr) {
        final ProductSeparators productType = ProductSeparators.getIdByChar(productStr.substring(0,1));
        String[] productString = productStr.split(ProductSeparators.PRODUCT_SEPARATOR.toString());
        switch (productType) {
            case PRODUCT_ID:
                return convertToProduct(productString);
            case ClOTH_ID:
                return convertToCloth(productString);
            case BOOTS_ID:
                return convertToBoots(productString);
        }

        return null;
    }

    private static Boots convertToBoots(String[] productInformation) {

        int id = Integer.parseInt(productInformation[1]);
        String productName = productInformation[2];
        double price = Double.parseDouble(productInformation[3]);
        double weight = Double.parseDouble(productInformation[4]);
        Color color = ColorParser.parseColor(productInformation[5]);
        int productCount = Integer.parseInt(productInformation[6]);
        int size = Integer.parseInt(productInformation[7]);
        SkinType skinType = SkinParser.parseSkinType(productInformation[8]);

        return new Boots(id, productName, price, weight, color, productCount, size, skinType);
    }

    private static Cloth convertToCloth(String[] productInformation) {

        int id = Integer.parseInt(productInformation[1]);
        String productName = productInformation[2];
        double price = Double.parseDouble(productInformation[3]);
        double weight = Double.parseDouble(productInformation[4]);
        Color color = ColorParser.parseColor(productInformation[5]);
        int productCount = Integer.parseInt(productInformation[6]);
        String size = productInformation[7];
        Material material = MaterialParser.parseMaterial(productInformation[8]);

        return new Cloth(id, productName, price, weight, color, productCount, size, material);
    }

    private static Product convertToProduct(String[] productInformation) {

        int id = Integer.parseInt(productInformation[1]);
        String productName = productInformation[2];
        double price = Double.parseDouble(productInformation[3]);
        double weight = Double.parseDouble(productInformation[4]);
        Color color = ColorParser.parseColor(productInformation[5]);
        int productCount = Integer.parseInt(productInformation[6]);

        return new Product(id, productName, price, weight, color, productCount);
    }
}
