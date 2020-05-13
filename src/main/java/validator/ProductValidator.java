package validator;

import entity.Product;

public class ProductValidator {
    private static ProductValidator instance = null;

    private ProductValidator() {
    }

    public static ProductValidator getInstance() {
        if (instance == null) {
            instance = new ProductValidator();
        }
        return instance;
    }

    public boolean isValid(Product product) {
        boolean correctPrice = isPriceBiggerThanZero(product);
        boolean correctNumber = isCountBiggerThanZero(product);
        boolean correctWeight = isWeightBiggerThanZero(product);
        boolean correctName = isNameNotEmpty(product);

        return correctPrice && correctNumber && correctWeight && correctName;
    }

    private boolean isNameNotEmpty(Product product) {
        return !product.getProductName().isEmpty();
    }

    private boolean isWeightBiggerThanZero(Product product) {
        return product.getWeight() > 0;
    }

    private boolean isCountBiggerThanZero(Product product) {
        return product.getProductCount() >= 0;
    }

    private boolean isPriceBiggerThanZero(Product product) {
        return product.getPrice() > 0;
    }
}
