package validator;

import entity.Product;
import exception.ProductCountNegativeException;
import exception.ProductNameEmptyException;
import exception.ProductPriceNoPositiveException;
import exception.ProductWeightNoPositiveException;

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

    public boolean isValid(Product product) throws ProductPriceNoPositiveException, ProductCountNegativeException, ProductWeightNoPositiveException, ProductNameEmptyException {
        if (!isPriceBiggerThanZero(product.getPrice())) {
            throw new ProductPriceNoPositiveException("Price is lower than zero");
        }
        if (!isCountBiggerThanZero(product.getProductCount())) {
            throw new ProductCountNegativeException("Product count is negative");
        }
        if (!isWeightBiggerThanZero(product.getWeight())) {
            throw new ProductWeightNoPositiveException("Product weight is negative");
        }
        if (!isNameNotEmpty(product.getProductName())) {
            throw new ProductNameEmptyException("There is no product name");
        }

        return true;
    }

    private boolean isNameNotEmpty(String name) {
        return name != null;
    }

    private boolean isWeightBiggerThanZero(double weight) {
        return weight > 0;
    }

    private boolean isCountBiggerThanZero(int count) {
        return count >= 0;
    }

    private boolean isPriceBiggerThanZero(double price) {
        return price > 0;
    }
}
