package com.jspiders.car_dekho_case_study.entity;


public class Car {
	
	//Data Members
	private int car_id;
	private String name;
	private String model;
	private String brand;
	private String fuel_type;
	private double price;
	
	
	//helper methods (getter $ setter)
	 
	 public Car() {
		// TODO Auto-generated constructor stub
	}
	//car_id
	public int getCar_ID() {
		return car_id; 
	}
	public void setCar_ID(int car_id) {
		this.car_id=car_id;
	}
	
	//name
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name=name;
	}
	
	//model
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model=model;
	}
	
	//brand
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand=brand;
	}
	
	//fuel_type
	public String getFuel_Type() {
		return fuel_type;
	}
	public void setFuel_Type(String fuel_type) {
		this.fuel_type=fuel_type;
	}
	
	//price
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price=price;
	}
	
	public String toString() {
		
		//return "Car Id of car is " +car_id+ "\nName of car is "+name+"\nModel of car is "+model+"\nBrand of car is "+brand+"\nFuel Type of car is "+fuel_type+"\nPrice of car is "+price;
		return "Car Id\t Name\t Model\t Brand\t Fuel Type\t Price\n"
				+"========================================================\n"
				+car_id+"\t"+name+"\t"+model+"\t"+brand+"\t"+fuel_type+"\t\t"+price+"\n";
		
	}
	
	
		
}
	

