package com.jspiders.car_dekho_mvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jspiders.car_dekho_mvc.pojo.CarAdminPojo;
import com.jspiders.car_dekho_mvc.repository.CarAdminRepository;

@Service
public class CarAdminService {

	@Autowired
	private CarAdminRepository repository;

	public CarAdminPojo getAdmin() {
		CarAdminPojo admin = repository.getAdmin();
		return admin;
	}

	public CarAdminPojo createAdmin(String username, String password) {
		CarAdminPojo admin = repository.createAdmin(username,password);
		return admin;
	}

	public CarAdminPojo login(String username, String password) {
		CarAdminPojo admin = repository.login(username,password);
		return admin;
	}
}
