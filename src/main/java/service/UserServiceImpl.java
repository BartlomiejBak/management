package service;

import api.UserDao;
import api.UserService;
import dao.UserDaoImpl;
import entity.User;
import exception.UserLoginAlreadyExistException;
import exception.UserShortLengthLoginException;
import exception.UserShortLengthPasswordException;
import validator.UserValidator;

import java.io.IOException;
import java.util.List;

public class UserServiceImpl implements UserService {
    private static UserServiceImpl instance = null;
    private UserDao userDao = UserDaoImpl.getInstance();
    private UserValidator userValidator = UserValidator.getInstance();

    private UserServiceImpl() throws IOException {
    }

    public static UserServiceImpl getInstance() throws IOException {
        if (instance == null) {
            instance = new UserServiceImpl();
        }
        return instance;
    }

    @Override
    public List<User> getAllUsers() throws IOException {
        return userDao.getAllUsers();
    }

    @Override
    public User getUserById(int userId) throws IOException {
        List<User> userList = getAllUsers();
        for (User user : userList) {
            if (user.getId() == userId);
                return user;
        }
        return null;
    }

    @Override
    public User getUserByLogin(String login) throws IOException {
        try {
            List<User> userList = getAllUsers();
            for (User user : userList) {
                if (user.getLogin().equals(login));
                return user;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return null;
    }

    @Override
    public boolean isCorrectLoginAndPassword(String login, String password) throws IOException {
        User foundUser = getUserByLogin(login);
        if (foundUser == null) {
            return false;
        }
        return foundUser.getPassword().equals(password);
    }

    @Override
    public boolean addUser(User user) throws UserLoginAlreadyExistException, UserShortLengthPasswordException, UserShortLengthLoginException, IOException {
        try {
            if (isLoginAlreadyExist(user.getLogin())) {
                throw new UserLoginAlreadyExistException();
            }

            if (userValidator.isValid(user)) {
                userDao.saveUser(user);
                return true;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    @Override
    public void removeUserById(int userId) throws IOException {
        userDao.removeUserById(userId);
    }

    private boolean isLoginAlreadyExist(String login) throws IOException {
        User user = getUserByLogin(login);

        return user != null;
    }
}
