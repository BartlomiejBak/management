package service;

import entity.User;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class UserServiceTest {

    @Test
    public void testGetAllUsers() {
        List<User> users = new ArrayList<>();
        users.add(new User(1, "login", "pass"));
        users.add(new User(2, "user2", "pass2"));
        users.add(new User(3, "user3", "pass3"));

        UserServiceImpl usersImplement = new UserServiceImpl(users);
        List<User> usersFromTest = usersImplement.getAllUsers();

        Assert.assertEquals(users, usersFromTest);
    }

    @Test
    public void testAddUser() {
        List<User> users = new ArrayList<>();
        User user = new User(1, "admin", "admin");
        users.add(user);

        UserServiceImpl userImplement = new UserServiceImpl();
        userImplement.addUser(user);

        Assert.assertEquals(users, userImplement.getAllUsers());
    }

    @Test
    public void testRemoveUser() {
        List<User> users = new ArrayList<>();
        User admin = new User(1, "admin", "admin");
        User first = new User(2, "regular", "regular");
        users.add(admin);
        users.add(first);

        UserServiceImpl userImplement = new UserServiceImpl(users);
        users.remove(admin);
        userImplement.removeUserById(1);

        Assert.assertEquals(users, userImplement.getAllUsers());
    }
}
