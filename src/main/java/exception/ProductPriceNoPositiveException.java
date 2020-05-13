package exception;

public class ProductPriceNoPositiveException extends Exception {
    public ProductPriceNoPositiveException() {
    }

    public ProductPriceNoPositiveException(String message) {
        super(message);
    }
}
