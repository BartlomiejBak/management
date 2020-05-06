package dao;

import api.UserDao;
import entity.User;
import entity.parser.UserParser;
import utils.FileUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {
    String fileName;

    public UserDaoImpl(String fileName) throws IOException {
        this.fileName = fileName;
        FileUtils.createNewFile(fileName);
    }

    @Override
    public void saveUser(User user) throws IOException {
        List<User> productList = getAllUsers();
        productList.add(user);
        saveUsers(productList);
    }

    @Override
    public void saveUsers(List<User> users) throws FileNotFoundException {
        FileUtils.clearFile(fileName);
        PrintWriter printWriter = new PrintWriter(new FileOutputStream(fileName, true));
        for (User user : users) {
            printWriter.write(user.toString() + "\n");
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
            User user = UserParser.stringToUser(readLine);
            if (user != null) {
                users.add(user);
            }
            readLine = bufferedReader.readLine();
        }
        bufferedReader.close();

        return users;
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
