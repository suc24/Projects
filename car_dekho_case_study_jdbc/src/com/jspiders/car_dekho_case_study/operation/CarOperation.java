package com.jspiders.car_dekho_case_study.operation;

import com.jspiders.car_dekho_case_study.entity.Car;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Scanner;



public class CarOperation {

	private static Connection connection;
	private static PreparedStatement preparedStatement;
	private static ResultSet resultSet;
	private static int result;
	private static FileInputStream file;
	private static String filePath = "D:\\WEJE2\\car_dekho_case_study_jdbc\\resources\\db_info.properties";
	private static Properties properties = new Properties();
	private static String query;
	Scanner scanner = new Scanner(System.in);

	private static void openConnection() {
		try {
			file = new FileInputStream(filePath);
			properties.load(file);
			
			//1. load the Driver class
			Class.forName(properties.getProperty("driverPath"));

			// 2. open connection
			connection = DriverManager.getConnection(properties.getProperty("dburl"), properties);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void closeConnection() {
		try {
			if (connection != null) {
				connection.close();
			}
			if (preparedStatement != null) {
				preparedStatement.close();
			}
			if (resultSet != null) {
				resultSet.close();
			}
			if (file != null) {
				file.close();
			}
			if(result!=0) {
				result=0;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Add Car
	public void addCar() {
	try{
		openConnection();
		
		ArrayList<Integer> takenID = new ArrayList<>();
		query = "select * from car ";
		preparedStatement = connection.prepareStatement(query);
		resultSet=preparedStatement.executeQuery();
		while(resultSet.next()) {
			takenID.add(resultSet.getInt(1));
		}
		System.out.println(takenID+" ID already added enter unique id ");
		
		query = "insert into car "
				+ "values(?,?,?,?,?,?)" ;
		preparedStatement = connection.prepareStatement(query);
		
		System.out.println("Enter how many cars do you want to add: ");
		int noOfCars = scanner.nextInt();
		int no = 1;
		while (no <= noOfCars) {
				Car car = new Car();
				
				System.out.println("Enter Car ID: ");
				car.setCar_ID(scanner.nextInt()); 

				System.out.println("Enter Car Name: ");
				car.setName(scanner.next());

				System.out.println("Enter Car Model ");
				car.setModel(scanner.next());

				System.out.println("Enter Car Brand: ");
				car.setBrand(scanner.next());

				System.out.println("Enter Car Fuel Type: ");
				car.setFuel_Type(scanner.next());

				System.out.println("Enter Car price: ");
				car.setPrice(scanner.nextDouble());
				
				no++;
				
				preparedStatement.setInt(1, car.getCar_ID());
				preparedStatement.setString(2, car.getName());
				preparedStatement.setString(3, car.getModel());
				preparedStatement.setString(4, car.getBrand());
				preparedStatement.setString(5, car.getFuel_Type());
				preparedStatement.setDouble(6, car.getPrice());
				
				result += preparedStatement.executeUpdate(); //here we don't need to pass query because it is an dynamic query
			
				
				if (result!=0) {
					System.out.println(result+" car(s) added");
				}
			};
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			closeConnection();
		}
	}

//	//Show All Cars
	public void showAllCars() {
		try {
			openConnection();
			query = "select * from car";
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				System.out.println(resultSet.getString(1)+" || "
								  +resultSet.getString(2)+" || "
								  +resultSet.getString(3)+" || "
								  +resultSet.getString(4)+" || "
								  +resultSet.getString(5)+" || "
								  +resultSet.getString(6));
			}	
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			closeConnection();
		}
	}
	
	//Search Car	
	public void searchCarByCarId() {
		try {
			openConnection();
			query="select * from car "
					+ "where car_id = ?";
			preparedStatement = connection.prepareStatement(query);
			System.out.println("Enter car id");
			int car_id = scanner.nextInt();
			preparedStatement.setInt(1, car_id);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				System.out.println(resultSet.getString(1)+" || "
								  +resultSet.getString(2)+" || "
								  +resultSet.getString(3)+" || "
								  +resultSet.getString(4)+" || "
								  +resultSet.getString(5)+" || "
								  +resultSet.getString(6));
				}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			closeConnection();
		}
	}

	public void searchCarByBrand() {
		try {
			System.out.println("Enter Car Brand: ");
			String car_Brand = scanner.next();
			openConnection();
			query = "select * from car "
					+ "where brand = ? ";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, car_Brand);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				System.out.println(resultSet.getString(1)+" || "
								  +resultSet.getString(2)+" || "
								  +resultSet.getString(3)+" || "
								  +resultSet.getString(4)+" || "
								  +resultSet.getString(5)+" || "
								  +resultSet.getString(6));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			closeConnection();
		}
	}
	
	public void searchCarByFuel_Type() {
		try {
			openConnection();
			System.out.println("Enter Car Fual Type: ");
			String fuel_Type = scanner.next();
			query = "select * from car "
					+ "where fuel_type = ?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, fuel_Type);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				System.out.println(resultSet.getString(1)+" || "
								  +resultSet.getString(2)+" || "
								  +resultSet.getString(3)+" || "
								  +resultSet.getString(4)+" || "
								  +resultSet.getString(5)+" || "
								  +resultSet.getString(6));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			closeConnection();
		}
		
	}
	
	//Update Car
	public void updateCar() {
		try {
			showAllCars();
			openConnection();
			System.out.println("What you want to update \n1.Name\n2.Price\n3.Brand");
			int choice = scanner.nextInt();
			switch (choice) {
			case 1:{
				System.out.println("Enter Car Id: ");
				int car_Id = scanner.nextInt();
				System.out.println("Enter new name: ");
				String name = scanner.next();
				query = "update car "
						+ "set name = ? "
						+ "where car_id = ? ";
				preparedStatement = connection.prepareStatement(query);
				preparedStatement.setString(1, name);
				preparedStatement.setInt(2, car_Id);
				result = preparedStatement.executeUpdate();
				System.out.println("Car name updated successfully!!!");
			}
			break;
			case 2:{
				System.out.println("Enter Car Id: ");
				int car_Id = scanner.nextInt();
				System.out.println("Enter new price: ");
				double price = scanner.nextDouble();
				query = "update car "
						+ "set price = ?"
						+ "where car_id = ?";
				preparedStatement = connection.prepareStatement(query);
				preparedStatement.setDouble(1, price);
				preparedStatement.setInt(2, car_Id);
				result = preparedStatement.executeUpdate();
				System.out.println("Car price updated successfully!!!");
			}
			break;
			case 3:{
				System.out.println("Enter Car Id: ");
				int car_Id = scanner.nextInt();
				System.out.println("Enter new brand: ");
				String brand = scanner.next();
				query = "update car "
						+ "set brand = ? "
						+ "where car_id = ?";
				preparedStatement = connection.prepareStatement(query);
				preparedStatement.setString(1, brand);
				preparedStatement.setInt(2, car_Id);
				result = preparedStatement.executeUpdate();
				System.out.println("Car brand updated successfully!!!");
			}
			break;
			default:
				System.out.println("Invalid choice...!!!");
				break;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			closeConnection();
		}
	}
	
	//Delete Car
	public void deleteCar() {
		try {
			showAllCars();
			openConnection();
			System.out.println("Enter Car Id to delete car: ");
			int car_Id = scanner.nextInt();
			query = "delete from car "
					+ "where car_id = ? ";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, car_Id);
			result = preparedStatement.executeUpdate();
			System.out.println("Car Deleted Successfully...!!!");
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			closeConnection();
		}
	}
}
