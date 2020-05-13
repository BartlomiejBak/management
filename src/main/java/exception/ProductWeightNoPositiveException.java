package exception;

public class ProductWeightNoPositiveException extends Exception {

    public ProductWeightNoPositiveException() {
    }

    public ProductWeightNoPositiveException(String message) {
        super(message);
    }
}
