package com.jspiders.car_dekho_mvc.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.jspiders.car_dekho_mvc.pojo.CarPojo;

@Repository
public class CarRepository {
	
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
		if(transaction!=null) {
			if (transaction.isActive()) {
				transaction.rollback();
			}
		}
	}

	public List<CarPojo> getAllCars() {
		openConnection();
		transaction.begin();
		
		String jpql = "from CarPojo";
		query = manager.createQuery(jpql);
		List<CarPojo> cars = query.getResultList();
		
		transaction.commit();
		closeConnection();
		return cars;
	}

	public CarPojo addCar(String name, String model, String brand, String fuelType, double price) {
		openConnection();
		transaction.begin();
		
		CarPojo car = new CarPojo();
		car.setName(name);
		car.setModel(model);
		car.setBrand(brand);
		car.setFuelType(fuelType);
		car.setPrice(price);
		
		manager.persist(car);
		
		transaction.commit();
		closeConnection();
		return car;
	}

	public CarPojo searchCar(int id) {
		openConnection();
		transaction.begin();
		
		CarPojo car = manager.find(CarPojo.class, id);
		
		
		transaction.commit();
		closeConnection();
		return car;
	}

	public CarPojo removeCar(int id) {
		openConnection();
		transaction.begin();
		
		CarPojo car = manager.find(CarPojo.class, id);
		manager.remove(car);
		
		transaction.commit();
		closeConnection();
		return car;
	}

	public CarPojo updateCar(int id, String name, String model, String brand, String fuelType, double price) {
		openConnection();
		transaction.begin();
		
		CarPojo car = manager.find(CarPojo.class, id);
		car.setName(name);
		car.setModel(model);
		car.setBrand(brand);
		car.setFuelType(fuelType);
		car.setPrice(price);
		
		manager.persist(car);
		
		transaction.commit();
		closeConnection();
		return car;
	}

}
