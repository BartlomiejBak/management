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

    private String login;
    private String password;
    private static UserValidator instance = null;
    private UserDaoImpl userDaoImpl = new UserDaoImpl("filename");

    private UserValidator() throws IOException {
    }

    public static UserValidator getInstance() throws IOException {
        if (instance == null) {
            instance = new UserValidator();
        }
        return instance;
    }

    public boolean isValidate(User user) throws UserShortLengthPasswordException, UserShortLengthLoginException, UserLoginAlreadyExistException {
        if (!isLoginLongEnough(user.getLogin()))
            throw new UserShortLengthLoginException("Login is too short");

        if (!isPasswordLongEnough(user.getPassword()))
            throw new UserShortLengthPasswordException("Password is too short");

        if (isUserByLoginExist(user.getLogin()))
            throw new UserLoginAlreadyExistException("Login already taken");

        return true;
    }

    private boolean isPasswordLongEnough(String password) {
        return password.length() >= MIN_LENGTH_PASSWORD;
    }

    private boolean isLoginLongEnough(String login) {
        return login.length() >= MIN_LENGTH_LOGIN;
    }

    private boolean isUserByLoginExist(String login) {
        User user = null;
        try {
            user = userDaoImpl.getUserByLogin(login);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (user == null) {
           return false;
        }
        return true;
    }
}
