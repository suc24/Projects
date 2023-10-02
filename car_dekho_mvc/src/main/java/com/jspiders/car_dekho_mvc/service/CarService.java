package com.jspiders.car_dekho_mvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jspiders.car_dekho_mvc.pojo.CarPojo;
import com.jspiders.car_dekho_mvc.repository.CarRepository;

@Service
public class CarService {
	
	@Autowired
	private CarRepository repository;

	public List<CarPojo> getAllCars() {
		List<CarPojo> cars = repository.getAllCars();
		return cars;
	}

	public CarPojo addCar(String name, String model, String brand, String fuelType, double price) {
		CarPojo car = repository.addCar(name,model,brand,fuelType,price);
		return car;
	}

	public CarPojo searchCar(int id) {
		CarPojo car = repository.searchCar(id);
		return car;
	}

	public CarPojo removeCar(int id) {
		CarPojo car = repository.removeCar(id);
		return car;
	}

	public CarPojo updateCar(int id, String name, String model, String brand, String fuelType, double price) {
		CarPojo car = repository.updateCar(id,name,model,brand,fuelType,price);
		return car;
	}

}
