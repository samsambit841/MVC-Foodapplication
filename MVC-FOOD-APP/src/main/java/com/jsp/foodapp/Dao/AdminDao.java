package com.jsp.foodapp.Dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.foodapp.dto.Admin;

@Repository
public class AdminDao {
	
	@Autowired
	EntityManagerFactory entityManagerFactory;
	
	public void saveAdmin(Admin admin) {
		EntityManager em=entityManagerFactory.createEntityManager();
		EntityTransaction et=em.getTransaction();
		et.begin();
		em.persist(admin);
		et.commit();
	}
	
	public Admin findByUsernameAndPassword(String username, String password) {
        try {
        	EntityManager em=entityManagerFactory.createEntityManager();
            Query query = em.createQuery("SELECT a FROM Admin a WHERE a.email = :username AND a.password = :password");
            query.setParameter("username", username);
            query.setParameter("password", password);
            return (Admin) query.getSingleResult();
        } catch (NoResultException e) {
            return null; 
        }
    }

}
