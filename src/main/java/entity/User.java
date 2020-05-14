package entity;

public class User {
    public static final String DELIMITER = "#";

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
        return id + DELIMITER +
                login + DELIMITER +
                password + DELIMITER;
    }
}
