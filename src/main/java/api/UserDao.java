package api;

import entity.User;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public interface UserDao {
    void saveUser(User user) throws IOException;
    void saveUsers(List<User> users) throws FileNotFoundException;
    void removeUserById(int userId) throws IOException;
    void removeUserByLogin(String login) throws IOException;
    List<User> getAllUsers() throws IOException;
    void updateUser(User user);
}
