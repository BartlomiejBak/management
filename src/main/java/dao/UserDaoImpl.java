package dao;

import api.UserDao;
import entity.User;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {
    String fileName;
    File file;

    public UserDaoImpl(String fileName) {
        this.fileName = fileName;
        this.file = new File(fileName);
    }

    public UserDaoImpl() {
    }

    @Override
    public void saveUser(User user) throws IOException {
        List<User> productList = getAllUsers();
        productList.add(user);
        saveUsers(productList);
    }

    @Override
    public void saveUsers(List<User> users) throws FileNotFoundException {
        PrintWriter printWriter = new PrintWriter(file);
        for (User user : users) {
            printWriter.println(user.toString());
        }
        printWriter.close();
    }

    @Override
    public void removeUserById(int userId) throws IOException {
        List<User> userList = getAllUsers();
        for (User user : userList) {
            if (user.getId() == userId) {
                userList.remove(user);
            }
        }
        saveUsers(userList);
    }

    @Override
    public void removeUserByLogin(String login) throws IOException {
        List<User> userList = getAllUsers();
        for (User user : userList) {
            if (user.getLogin().equals(login)) {
                userList.remove(user);
            }
        }
        saveUsers(userList);
    }

    @Override
    public List<User> getAllUsers() throws IOException {
        List<User> users = new ArrayList<>();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));

        String readLine = bufferedReader.readLine();
        while(readLine != null) {
            User user = convertToUser(readLine);
            users.add(user);
            readLine = bufferedReader.readLine();
        }
        bufferedReader.close();

        return users;
    }

    private static User convertToUser(String userStr) {
        String[] userInformation = userStr.split(User.DELIMITER);

        int id = Integer.parseInt(userInformation[0]);
        String login = userInformation[1];
        String password = userInformation[2];

        return new User(id, login, password);
    }

    @Override
    public User getUserById(int userId) throws IOException {
        List<User> userList = getAllUsers();
        for (User user : userList) {
            if (user.getId() == userId) {
                return user;
            }
        }
        return null;
    }

    @Override
    public User getUserByLogin(String login) throws IOException {
        List<User> userList = getAllUsers();
        for (User user : userList) {
            if (user.getLogin().equals(login)) {
                return user;
            }
        }
        return null;
    }
}
