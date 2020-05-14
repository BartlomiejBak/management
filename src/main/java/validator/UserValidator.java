package validator;

import entity.User;
import exception.UserShortLengthLoginException;
import exception.UserShortLengthPasswordException;

public class UserValidator {

    private static UserValidator instance = null;

    private UserValidator() {
    }

    public static UserValidator getInstance() {
        if (instance == null) {
            instance = new UserValidator();
        }
        return instance;
    }

    public boolean isValid(User user) throws UserShortLengthPasswordException, UserShortLengthLoginException {
        if (!isLoginLongEnough(user.getLogin()))
            throw new UserShortLengthLoginException("Login is too short");

        if (!isPasswordLongEnough(user.getPassword()))
            throw new UserShortLengthPasswordException("Password is too short");

        return true;
    }

    private boolean isPasswordLongEnough(String password) {
        int MIN_LENGTH_PASSWORD = 6;
        return password.length() >= MIN_LENGTH_PASSWORD;
    }

    private boolean isLoginLongEnough(String login) {
        int MIN_LENGTH_LOGIN = 4;
        return login.length() >= MIN_LENGTH_LOGIN;
    }
}
