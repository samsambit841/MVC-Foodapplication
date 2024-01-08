package com.jsp.foodapp.Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.foodapp.dto.Product;
import com.jsp.foodapp.dto.User;

@Repository
public class Productdao {

    @Autowired
    private EntityManagerFactory entityManagerFactory;

    public void save(Product product) {
        EntityManager em = entityManagerFactory.createEntityManager();
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.persist(product);
        et.commit();
    }

    public List<Product> getall() {
        EntityManager em = entityManagerFactory.createEntityManager();
        EntityTransaction et = em.getTransaction();
        et.begin();
        Query q = em.createQuery("select p from Product p");

        return q.getResultList();
    }

    public Product find(int id) {
        EntityManager em = entityManagerFactory.createEntityManager();
        Product p = em.find(Product.class, id);
        return p;
    }

    public void update(Product p) {
        EntityManager em = entityManagerFactory.createEntityManager();
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.merge(p);
        et.commit();
    }

    public void delete(int id) {
        EntityManager em = entityManagerFactory.createEntityManager();
        EntityTransaction et = em.getTransaction();
        et.begin();
        Product p = em.find(Product.class, id);
        if (p != null) {
            em.remove(p);
        }
        et.commit();
    }

	
}
