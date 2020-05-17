package entity.parser;

import entity.User;
import entity.enums.ProductSeparators;

public class UserParser {
    public static User stringToUser(java.lang.String readLine) {
        java.lang.String[] userInformations = readLine.split(ProductSeparators.PRODUCT_SEPARATOR.toString());

        int userId = Integer.parseInt(userInformations[0]);
        java.lang.String login = userInformations[1];
        java.lang.String password = userInformations[2];

        return new User(userId, login, password);
    }
}