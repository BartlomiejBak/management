package entity.enums;

public enum ProductSeparators {
    PRODUCT_SEPARATOR("#"),
    PRODUCT_ID("P"),
    ClOTH_ID("C"),
    BOOTS_ID("B");

    private String word;

    ProductSeparators(String word) {
        this.word = word;
    }

    public String getWord() {
        return word;
    }

    @Override
    public String toString() {
        return word;
    }

    public static ProductSeparators getIdByChar(String word) {
        for(ProductSeparators id: ProductSeparators.values()) {
            if (id.getWord().equals(word)) {
                return id;
            }
        }
        return null;
    }
}
