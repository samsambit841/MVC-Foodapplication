package com.jsp.foodapp.Dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.foodapp.dto.Product;
import com.jsp.foodapp.dto.User;

@Repository
public class UserDao {

	@Autowired
	private EntityManagerFactory entityManagerFactory;

	public void save(User user) {
		EntityManager em = entityManagerFactory.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.persist(user);
		et.commit();

	}

	public User findusernameandpassword(String email, String password) {
		try {
			EntityManager em = entityManagerFactory.createEntityManager();
			EntityTransaction et = em.getTransaction();
			Query q = em.createQuery("select u from User u where u.email=:email and u.password=:password");
			q.setParameter("email",email);
			q.setParameter("password", password);
			return (User)q.getSingleResult();

		} catch (NoResultException e) {
			return null;
		}
	}

	public User findUserById(int userId) {
		EntityManager em = entityManagerFactory.createEntityManager();
        User u = em.find(User.class, userId);
        return u;
	}

	public void updateuser(User user) {
		EntityManager em = entityManagerFactory.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(user);
		et.commit();
		
	}

}
