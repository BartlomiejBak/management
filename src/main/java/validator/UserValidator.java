package validator;

import dao.UserDaoImpl;
import entity.User;
import exception.UserLoginAlreadyExistException;
import exception.UserShortLengthLoginException;
import exception.UserShortLengthPasswordException;

import java.io.IOException;

public class UserValidator {
    private final int MIN_LENGTH_PASSWORD = 6;
    private final int MIN_LENGTH_LOGIN = 4;

    private static UserValidator instance = null;
    private UserDaoImpl userDaoImpl = UserDaoImpl.getInstance();

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
        return password.length() >= MIN_LENGTH_PASSWORD;
    }

    private boolean isLoginLongEnough(String login) {
        return login.length() >= MIN_LENGTH_LOGIN;
    }
}
