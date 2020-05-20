package dao;

import api.UserDao;
import entity.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoSQLImpl implements UserDao {
    private static UserDaoSQLImpl instance;
    private final String databaseName = "management";
    private final String tableName = "users";
    private final String user = "admin";
    private final String password = "admin";
    private Connection connection;

    private UserDaoSQLImpl() {
        init();
    }

    public static UserDaoSQLImpl getInstance() {
        if (instance == null) {
            instance = new UserDaoSQLImpl();
        }
        return instance;
    }

    private void init() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost/"+databaseName+
                    "?useSSL=false&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=Europe/Moscow",
                    user, password);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void saveUser(User user) {
        PreparedStatement statement;
        try {
            String query = "insert into " + tableName + " (ID, login, password) values (?, ?, ?)";
            statement = connection.prepareStatement(query);

            statement.setInt(1, user.getId());
            statement.setString(2, user.getLogin());
            statement.setString(3, user.getPassword());

            statement.execute();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void saveUsers(List<User> users) {
        for (User user1 : users) {
            saveUser(user1);
        }
    }

    @Override
    public void removeUserById(int userId) {
        PreparedStatement statement;
        try {
            String query = "DELETE FROM " + tableName + " where ID = " + userId;
            statement = connection.prepareStatement(query);
            statement.execute();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void removeUserByLogin(String login) {
        PreparedStatement statement;
        try {
            String query = "delete from " + tableName + " where login = " + login;
            statement = connection.prepareStatement(query);
            statement.execute();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        Statement statement = null;
        try {
            statement = connection.createStatement();
            String query = "select * from " + tableName;
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                int ID = resultSet.getInt("ID");
                String login = resultSet.getString("login");
                String password = resultSet.getString("password");

                User user = new User(ID, login, password);
                users.add(user);
            }
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return users;
    }

    @Override
    //todo - implementation
    public void updateUser(User user) {
        PreparedStatement statement;
        try {
            String query = "update " + tableName + " set login = ?, password = ? where ID = ?";
            statement = connection.prepareStatement(query);

            statement.setString(1, user.getLogin());
            statement.setString(2, user.getPassword());
            statement.setInt(3, user.getId());

            statement.execute();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
