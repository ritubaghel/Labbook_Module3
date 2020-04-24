package org.cap.dao;

import org.cap.entities.Product;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import javax.persistence.*;
import java.util.List;

@Repository
public class ProductDaoImpl implements IProductDao {

    private EntityManager entityManager;

    public EntityManager getEntityManager() {
        return entityManager;
    }

    @PersistenceContext
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Product> fetchAll() {
        String jql = "from Product";
        TypedQuery<Product> query = entityManager.createQuery(jql, Product.class);
        List<Product> list = query.getResultList();
        return list;
    }

    @Override
    public Product add(Product product) {
        getEntityManager().persist(product);
        return product;
    }

  

}
