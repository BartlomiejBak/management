package dao;

import api.UserDao;
import entity.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class UserDaoHibernateImpl implements UserDao {
    private static UserDaoHibernateImpl instance = null;
    static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myDatabase");
    static EntityManager entityManager = entityManagerFactory.createEntityManager();

    private UserDaoHibernateImpl() {
    }

    public static UserDaoHibernateImpl getInstance() {
        if (instance == null) {
            instance = new UserDaoHibernateImpl();
        }
        return instance;
    }
    
    @Override
    public void saveUser(User user) {
        entityManager.getTransaction().begin();
        entityManager.persist(user);
        entityManager.getTransaction().commit();
        entityManager.refresh(user);
    }

    @Override
    public void saveUsers(List<User> users) {
        for (User user : users) {
            saveUser(user);
        }
    }

    @Override
    public void removeUserById(int userId) {
        entityManager.getTransaction().begin();
        User user = entityManager.find(User.class, userId);
        entityManager.remove(user);
        entityManager.getTransaction().commit();
    }

    @Override
    public void removeUserByLogin(String login) {
        entityManager.getTransaction().begin();
        TypedQuery<User> query = entityManager.createQuery("SELECT a from User a WHERE a.login = :param", User.class);
        query.setParameter("param", login);
        for (User user : query.getResultList()) {
            entityManager.remove(user);
        }
        entityManager.getTransaction().commit();
    }

    @Override
    public List<User> getAllUsers() {
        return entityManager.createQuery("SELECT a FROM User a", User.class).getResultList();
    }

    @Override
    public void updateUser(User user) {

    }

    public static void closeTransaction(){
        entityManager.close();
        entityManagerFactory.close();
    }
}
