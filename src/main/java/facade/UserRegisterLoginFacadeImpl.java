package facade;

import api.UserRegisterLoginFacade;
import api.UserService;
import entity.User;
import exception.UserLoginAlreadyExistException;
import exception.UserShortLengthLoginException;
import exception.UserShortLengthPasswordException;
import service.UserServiceImpl;

import java.io.IOException;

public class UserRegisterLoginFacadeImpl implements UserRegisterLoginFacade {
    private UserService userService = UserServiceImpl.getInstance();
    private static UserRegisterLoginFacadeImpl instance = null;

    private UserRegisterLoginFacadeImpl() throws IOException {
    }

    public static UserRegisterLoginFacadeImpl getInstance() throws IOException {
        if (instance == null) {
            instance = new UserRegisterLoginFacadeImpl();
        }
        return instance;
    }

    @Override
    public boolean registerUser(User user) throws UserLoginAlreadyExistException, UserShortLengthPasswordException, UserShortLengthLoginException, IOException {
        return userService.addUser(user);
    }

    @Override
    public boolean loginUser(String login, String password) throws IOException {
        return userService.isCorrectLoginAndPassword(login,password);
    }
}
