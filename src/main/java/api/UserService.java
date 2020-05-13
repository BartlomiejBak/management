package api;

import entity.User;
import exception.UserLoginAlreadyExistException;
import exception.UserShortLengthLoginException;
import exception.UserShortLengthPasswordException;

import java.io.IOException;
import java.util.List;

public interface UserService {
    boolean addUser(User user) throws UserLoginAlreadyExistException, UserShortLengthPasswordException, UserShortLengthLoginException, IOException;

    void removeUserById(int userId) throws IOException;

    List<User> getAllUsers() throws IOException;
    User getUserById(int userId) throws IOException;
    User getUserByLogin(String login) throws IOException;

    boolean isCorrectLoginAndPassword(String login, String password) throws IOException;
}
