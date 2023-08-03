package com.jspiders.car_dekho_case_study.main;
//import com.jspiders.car_dekho_case_study.entity.Car;
import java.util.Scanner;

import com.jspiders.car_dekho_case_study.operation.CarOperation;

public class CarDhekhoMenu{
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		CarOperation cr = new CarOperation();
		
		boolean loop=true;
		while(loop) {
			System.out.println("**********Menu**********");
			System.out.println("1.Add Car Details \n2.Search Car Details \n3.Update Car Details \n4.Show All Cars \n5.Delete Car Details \n6.Exit");
			System.out.println("Enter Your Choice: ");
			int choice = s.nextInt();
			switch(choice) {
			case 1:{
					cr.addCar();
				}
			break;
			case 2:{
				System.out.println("***********Search Car By**********");
				System.out.println("1.Car_Id\n2.Brand\n3.Fual Type\n4.Go Back");
				System.out.println("Enter Your Choice: ");
				int sChoice=s.nextInt();
				switch(sChoice) {
				case 1:{
					//cr.showAllCars();
					cr.searchCarByCarId();
				}
				break;
				case 2:{
					
					cr.searchCarByBrand();
				}
				break;
				case 3:{
					
					cr.searchCarByFuel_Type();
				}
				break;
				case 4:{
					break;
				}
				default:{
					System.out.println("Invalid Input...!!!");
				}
				}
			}
			break;
			case 3:{
				cr.updateCar();
			}
			break;
			case 4:{
				cr.showAllCars();
			}
			break;
			case 5:{
				cr.deleteCar();
			}
			break;
			case 6:{
				System.out.println("Thank YOU...!!!!");
				loop=false;
			}
			break;
			default:{
				System.out.println("Invalid Input...!!!");
			}

		}
	}
s.close();
	}
}

