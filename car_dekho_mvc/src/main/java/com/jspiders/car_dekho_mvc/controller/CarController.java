package com.jspiders.car_dekho_mvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.jspiders.car_dekho_mvc.pojo.CarAdminPojo;
import com.jspiders.car_dekho_mvc.pojo.CarPojo;
import com.jspiders.car_dekho_mvc.service.CarService;

@Controller
public class CarController {

	@Autowired
	private CarService service;

	// Home Page Controller
	@GetMapping("/home")
	public String homePage(ModelMap map, @SessionAttribute(name = "login", required = false) CarAdminPojo admin) {
		if (admin != null) {
			return "Home";
		}
		map.addAttribute("msg", "Session Inactive...! Login To Procced...!");
		return "Login";

	}

	// Add Page Controller
	@GetMapping("/add")
	public String addPage(ModelMap map, @SessionAttribute(name = "login", required = false) CarAdminPojo admin) {
		if (admin != null) {

			List<CarPojo> cars = service.getAllCars();

			// success
			if (cars.isEmpty() == false) {
				map.addAttribute("cars", cars);
				return "Add";
			}
			// failure
			map.addAttribute("msg", "Data not found...!");
			return "Add";
		}
		map.addAttribute("msg", "Session Inactive...! Login To Procced...!");
		return "Login";
	}

	// Add Car Controller
	@PostMapping("/add")
	public String addCar(@RequestParam String name, @RequestParam String model, @RequestParam String brand,
			@RequestParam String fuelType, @RequestParam double price, ModelMap map,@SessionAttribute(name = "login", required = false)CarAdminPojo admin) {
		if (admin!=null) {
			CarPojo car = service.addCar(name, model, brand, fuelType, price);
			List<CarPojo> cars = service.getAllCars();

			// success
			if (car != null) {
				map.addAttribute("msg", "Data inserted successfully...!");
				map.addAttribute("cars", cars);
				return "Add";
			}
			// failure
			map.addAttribute("msg", "Data not inserted");
			return "Add";
		}
		map.addAttribute("msg","Session Inactive...! Login To Procced...!" );
		return "Login";
	}

	// Search Page Controller
	@GetMapping("/search")
	public String searchPage(ModelMap map,@SessionAttribute(name="login",required = false)CarAdminPojo admin) {
		if (admin!=null) {
			return "Search";
		}
		map.addAttribute("msg", "Session Inactive...! Login To Procced...!");
		return "Login";
		
	}

	// Search Car Controller
	@PostMapping("/search")
	public String searchCar(@RequestParam int id, ModelMap map,@SessionAttribute(name = "login" , required = false)CarAdminPojo admin) {
		if (admin!=null) {
			CarPojo car = service.searchCar(id);

			// success
			if (car != null) {
				map.addAttribute("msg", "Car record found...!");
				map.addAttribute("car", car);
				return "Search";
			}
			// failure
			map.addAttribute("msg", "Car record not found...!");
			return "Search";
		}
		map.addAttribute("msg", "Session Inactive...! Login To Procced...!");
		return "Login";
		
	}

	// Remove Page Controller
	@GetMapping("/remove")
	public String removePage(ModelMap map,@SessionAttribute(name = "login", required = false)CarAdminPojo admin) {
		if (admin!=null) {
			List<CarPojo> cars = service.getAllCars();

			// success
			if (cars.isEmpty() == false) {
				map.addAttribute("cars", cars);
				return "Remove";
			}
			// failure
			map.addAttribute("msg", "Data not present...!");
			return "Remove";
		}
		map.addAttribute("msg", "Session Inactive...! Login To Procced...!");
		return "Login";
	}

	// Remove Car Controller
	@PostMapping("/remove")
	public String removeCar(@RequestParam int id, ModelMap map,@SessionAttribute(name = "login",required = false)CarAdminPojo admin) {
		if (admin!=null) {
			CarPojo car = service.removeCar(id);
			List<CarPojo> cars = service.getAllCars();

			// success
			if (car != null) {
				map.addAttribute("msg", "Record removed successfully...!");
				map.addAttribute("cars", cars);
				return "Remove";
			}
			// failure
			map.addAttribute("msg", "Record not found...!");
			return "Remove";
		}
		map.addAttribute("msg", "Session Inactive...! Login To Procced...!");
		return "Login";
	}

	// Update Page Controller
	@GetMapping("/update")
	public String updatePage(ModelMap map,@SessionAttribute(name = "login",required = false)CarAdminPojo admin) {
		if (admin!=null) {
			List<CarPojo> cars = service.getAllCars();
			// success
			if (cars != null) {
				map.addAttribute("cars", cars);
				return "Update";
			}
			// failure
			map.addAttribute("msg", "Data not found...!");
			return "Update";
		}
		map.addAttribute("msg", "Session Inactive...! Login To Procced...!");
		return "Login";
	}

	@PostMapping("/update")
	public String updateForm(@RequestParam int id, ModelMap map,@SessionAttribute(name = "login",required = false)CarAdminPojo admin) {
		if (admin!=null) {
			CarPojo car = service.searchCar(id);

			// success
			if (car != null) {
				map.addAttribute("car", car);
				return "Update";
			}
			// success
			List<CarPojo> cars = service.getAllCars();
			map.addAttribute("cars", cars);
			map.addAttribute("msg", "Car record not found...!");
			return "Update";
		}
		map.addAttribute("msg", "Session Inactive...! Login To Procced...!");
		return "Login";
	}

	@PostMapping("/updateCar")
	public String updateCar(@RequestParam int id, @RequestParam String name, @RequestParam String model,
			@RequestParam String brand, @RequestParam String fuelType, @RequestParam double price, ModelMap map,@SessionAttribute(name = "login",required = false)CarAdminPojo admin) {
		if (admin!=null) {
			CarPojo car = service.updateCar(id, name, model, brand, fuelType, price);
			if (car != null) {
				List<CarPojo> cars = service.getAllCars();
				if (cars != null) {
					map.addAttribute("msg", "Car record updated successfully...!");
					map.addAttribute("cars", cars);
				}
				return "Update";
			}
			List<CarPojo> cars = service.getAllCars();
			if (cars != null) {
				map.addAttribute("msg", "Car record not found...!");
				map.addAttribute("cars", cars);
			}
			return "Update";
		}
		map.addAttribute("msg", "Session Inactive...! Login To Procced...!");
		return "Login";
	}

	@GetMapping("/login")
	public String login() {
		return "Login";
	}
}
