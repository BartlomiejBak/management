package dao;

import api.ProductDao;
import entity.Product;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

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
        for (Product product : products) {
            saveProduct(product,"list");
        }
    }

    @Override
    public void removeProductById(int productId) {
        entityManager.getTransaction().begin();
        Product product = entityManager.find(Product.class, productId);
        entityManager.remove(product);
        entityManager.getTransaction().commit();
    }

    @Override
    public void removeProductByName(String removedProductName) {
        entityManager.getTransaction().begin();
        TypedQuery<Product> query = entityManager.createQuery("SELECT a FROM Product a WHERE a.productName = :name ", Product.class);
        query.setParameter("name", removedProductName);

        for (Product product : query.getResultList()) {
            entityManager.remove(product);
        }
        entityManager.getTransaction().commit();
    }

    @Override
    public List<Product> getAllProducts() {
        return entityManager.createQuery("SELECT a FROM Product a", Product.class).getResultList();
    }
}
