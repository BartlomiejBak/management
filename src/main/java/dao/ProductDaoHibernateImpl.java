package dao;

import api.ProductDao;
import entity.Product;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import java.util.List;

public class ProductDaoHibernateImpl implements ProductDao {
    static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myDatabase");
    static EntityManager entityManager = entityManagerFactory.createEntityManager();
    private static ProductDaoHibernateImpl instance = null;

    private ProductDaoHibernateImpl() {
    }

    public static ProductDaoHibernateImpl getInstance() {
        if (instance == null) {
            instance = new ProductDaoHibernateImpl();
        }
        return instance;
    }

    public static void closeTransaction(){
        entityManager.close();
        entityManagerFactory.close();
    }

    @Override
    public void saveProduct(Product product, String productType) {

        entityManager.getTransaction().begin();
        entityManager.persist(product);
        entityManager.getTransaction().commit();
        entityManager.refresh(product);

    }

    @Override
    public void saveProducts(List<Product> products) {

        entityManager.getTransaction().begin();
        for (Product product : products) {
            entityManager.persist(product);
            entityManager.getTransaction().commit();
            entityManager.refresh(product);
        }
        entityManager.close();
        entityManagerFactory.close();
    }

    @Override
    public void removeProductById(int productId) {

    }

    @Override
    public void removeProductByName(String productName) {

    }

    @Override
    public List<Product> getAllProducts() {

        return null;
    }
}
