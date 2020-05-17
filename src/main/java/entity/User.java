package entity;


import entity.enums.ProductSeparators;

public class User {

    private final int id;
    private final String login;
    private final String password;

    public User(int id, String login, String password) {
        this.id = id;
        this.login = login;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return id + ProductSeparators.PRODUCT_SEPARATOR.toString() +
                login + ProductSeparators.PRODUCT_SEPARATOR.toString() +
                password + ProductSeparators.PRODUCT_SEPARATOR.toString();
    }
}
