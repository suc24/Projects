package com.jspiders.car_dekho_mvc.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jspiders.car_dekho_mvc.pojo.CarAdminPojo;
import com.jspiders.car_dekho_mvc.service.CarAdminService;

@Controller
public class CarAdminController {

	@Autowired
	private CarAdminService service;
	
	@GetMapping("/createAdmin")
	public String adminLoginPage(ModelMap map) {
		CarAdminPojo admin = service.getAdmin();
		
		//success
		if(admin!=null) {
			map.addAttribute("msg", "Account already exist");
			return "Login";
		}
		//failure
		return "CreateAccount";
	}
	
	@PostMapping("/createAdmin")
	public String createAdmin(@RequestParam String username, @RequestParam String password, ModelMap map) {
		CarAdminPojo admin = service.createAdmin(username,password);
		
		//success
		if (admin!=null) {
			map.addAttribute("msg", "Account created successfully...!");
			return "Login";
		}
		//failure
		map.addAttribute("msg", "Account not created");
		return "Login";
	}
	
	@PostMapping("/login")
	public String login(@RequestParam String username, @RequestParam String password, ModelMap map,HttpSession session) {
		CarAdminPojo admin = service.login(username,password);
		
		//success
		if (admin!=null) {
			session.setAttribute("login", admin);
			return "Home";
		}
		//failure
		map.addAttribute("msg", "Plz enter correct username or password");
		return "Login";
	}
	
	@GetMapping("/logout")
	public String logout(ModelMap map,HttpSession session) {
		session.invalidate();
		map.addAttribute("msg", "Logout successfully...!");
		return "Login";
	}
}
