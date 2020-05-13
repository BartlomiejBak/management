package api;

import entity.User;
import exception.UserLoginAlreadyExistException;
import exception.UserShortLengthLoginException;
import exception.UserShortLengthPasswordException;

import java.io.IOException;

public interface UserRegisterLoginFacade {
    boolean registerUser(User user) throws IOException, UserLoginAlreadyExistException, UserShortLengthPasswordException, UserShortLengthLoginException;
    boolean loginUser(String login, String password) throws IOException;
}
