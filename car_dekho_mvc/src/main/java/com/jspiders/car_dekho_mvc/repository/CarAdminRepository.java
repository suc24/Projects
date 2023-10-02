package com.jspiders.car_dekho_mvc.repository;

import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.jspiders.car_dekho_mvc.pojo.CarAdminPojo;

@Repository
public class CarAdminRepository {
	private static EntityManagerFactory factory;
	private static EntityManager manager;
	private static EntityTransaction transaction;
	private static Query query;
	
	private static void openConnection() {
		factory = Persistence.createEntityManagerFactory("car");
		manager = factory.createEntityManager();
		transaction = manager.getTransaction();
	} 
	
	private static void closeConnection() {
		if (factory!=null) {
			factory.close();
		}
		if (manager!=null) {
			manager.close();
		}
		if (transaction!=null) {
			if (transaction.isActive()) {
				transaction.rollback();
			}
		}
	}

	public CarAdminPojo getAdmin() {
		openConnection();
		transaction.begin();
		
		String jpql = "from CarAdminPojo";
		query = manager.createQuery(jpql);
		List<CarAdminPojo> admins = query.getResultList();
		
		if (admins.isEmpty()==false) {
			for(CarAdminPojo admin : admins) {
			transaction.commit();
			closeConnection();
			return admin;
			}
		}
		
		transaction.commit();
		closeConnection();
		return null;
	}

	public CarAdminPojo createAdmin(String username,String password) {
		openConnection();
		transaction.begin();
		
		CarAdminPojo admin = new CarAdminPojo();
		admin.setUsername(username);
		admin.setPassword(password);
		
		manager.persist(admin);
		
		transaction.commit();
		closeConnection();
		return admin;
	}

	public CarAdminPojo login(String username, String password) {
		openConnection();
		transaction.begin();
		
		String jpql = "from CarAdminPojo"
				+ " where username = '"+username+"'"
				+ " and password = '"+password+"'";
		query = manager.createQuery(jpql);
		List<CarAdminPojo> admins = query.getResultList();
		
		if (admins!=null) {
			for(CarAdminPojo admin:admins) {
				transaction.commit();
				closeConnection();
				return admin;
			}
		}
		transaction.commit();
		closeConnection();
		return null;
	}
}
