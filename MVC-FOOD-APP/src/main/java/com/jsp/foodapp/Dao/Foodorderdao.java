package com.jsp.foodapp.Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.foodapp.dto.FoodOrder;
import com.jsp.foodapp.dto.User;

@Repository
public class Foodorderdao {
	@Autowired
	EntityManagerFactory emf;

	public List<FoodOrder> viewall() {
		EntityManager em = emf.createEntityManager();

		Query q = em.createQuery("select f from FoodOrder f");
		return q.getResultList();

	}
	 public List<FoodOrder> findFoodOrdersByUser(User user) {
	        EntityManager em = emf.createEntityManager();	        
	        Query q = em.createQuery("SELECT f FROM FoodOrder f WHERE f.user = :user");
	        q.setParameter("user", user);

	        return q.getResultList();
	    }
	 

}
