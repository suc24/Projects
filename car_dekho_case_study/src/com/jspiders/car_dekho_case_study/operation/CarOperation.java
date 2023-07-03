package com.jspiders.car_dekho_case_study.operation;
import com.jspiders.car_dekho_case_study.entity.Car;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
public class CarOperation {
	
	Scanner s = new Scanner(System.in);
	ArrayList<Car> al = new ArrayList<Car>();
	Car c=new Car();
	
	
	//Add Car
	public void addCar() {
		
		System.out.println("Enter how many cars do you want to add: ");
		int noOfCars = s.nextInt();
		int no=1;
		while(no<=noOfCars) {
			
			Car c1=new Car();
			System.out.println("Enter Car ID: ");
			c1.setCar_ID(s.nextInt());
			
			System.out.println("Enter Car Name: ");
			c1.setName( s.next());
		
			System.out.println("Enter Car Model ");
			c1.setModel(s.next());
		
			System.out.println("Enter Car Brand: ");
			c1.setBrand(s.next());
		
			System.out.println("Enter Car Fuel Type: ");
			c1.setFuel_Type(s.next());
		
			System.out.println("Enter Car price: ");
			c1.setPrice(s.nextDouble());
			no++;
			if (noOfCars>1) {
				System.out.println("\nAdd Another Car");
			
			}
			al.add(c1);
			
		}
		if(noOfCars>1) {
			System.out.println(noOfCars+" Cars Added Succefully...!!!");
		}
		else {
			System.out.println(noOfCars+" Car Added Succefully...!!!");
		}
		
		
	}
	
	//Show All Cars
	public void showAllCars() {
		if(al.isEmpty()){
			System.out.println("No Cars Found...!!!!!");
		}
		else {
			for(Car i : al) {
				System.out.println(i);
			}
		}
		
		
	}
	
	//Search Car	
	public void searchCarByCarId() {
		System.out.println("Enter Car_ID: ");
		int car_Id=s.nextInt();
		
			for (Car i:al) {
				if(i.getCar_ID()==car_Id) {
				
				System.out.println(i);
				}
				else {
					System.out.println("No Such Car ID Found....!!!");
				}
			}
			
		
	}
	
	public void searchCarByBrand() {
		System.out.println("Enter Car Brand: ");
		String car_Brand = s.next();
			for(Car i:al) {
				if (i.getBrand().equalsIgnoreCase(car_Brand)) {
					System.out.println(i);
				}
				else{
					System.out.println("No Such Car Brand Found....!!!");
				}
			}
	}
	public void searchCarByFuel_Type() {
		System.out.println("Enter Car Fual Type: ");
		String fuel_Type = s.next();
			for(Car i:al) {
				if(i.getFuel_Type().equalsIgnoreCase(fuel_Type)) {
					System.out.println(i);
				}
				else {
					System.out.println("No Such Fuel Type Car Found....!!!");
				}
			}
	}
	
	//Update Car
	public void updateCar() {
		System.out.println("Enter Car Id To Update Car Details: ");
		int id = s.nextInt();
		for(Car c : al) {
			if(c.getCar_ID()==id){
				System.out.println("Enter Car Name: ");
				c.setName( s.next());
			
				System.out.println("Enter Car Model ");
				c.setModel(s.next());
			
				System.out.println("Enter Car Brand: ");
				c.setBrand(s.next());
			
				System.out.println("Enter Car Fuel Type: ");
				c.setFuel_Type(s.next());
			
				System.out.println("Enter Car price: ");
				c.setPrice(s.nextDouble());
				break;
			}
			else {
				System.out.println("No Such Car Found....!!!");
			}
		}
	}
	
	//Delete Car
	public void deleteCar() {
		if(al.isEmpty()) {
			System.out.println("No Cars Found...!!!!!");
		}
		else {
			showAllCars();
			System.out.println("Enter Car Id To Remove Car");
			int r = s.nextInt();
			
			Iterator<Car>it = al.iterator();
				while(it.hasNext()) {
					Car i=it.next();
					if (i.getCar_ID()==r) {
						it.remove(); 
						System.out.println(i.getName()+" Removed Succefully...!!!!");
					}
				}
			}
	}
}
