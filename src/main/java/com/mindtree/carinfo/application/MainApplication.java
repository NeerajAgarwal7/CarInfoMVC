package com.mindtree.carinfo.application;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import com.mindtree.carinfo.entity.Car;
import com.mindtree.carinfo.exception.AppException;
import com.mindtree.carinfo.exception.ServiceException;
import com.mindtree.carinfo.service.CarService;
import com.mindtree.carinfo.service.ServiceImpl.CarServiceImpl;
import com.mindtree.carinfo.utility.DataRWutil;

public class MainApplication {

	static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	static CarService CS = new CarServiceImpl();

	public static void main(String[] args) throws AppException {

		System.out.println("Welcome");
		/*LinkedList<Car> list = DataRWutil.readDataFile(args[0]);
		list.forEach(i -> {
			try {
				CS.addCar(i);
			} catch (ServiceException e) {
				System.out.println(e.getMessage() + " : " + e.getCause());
			}
		});*/

		while (true) {

			System.out.println("1 - Add car data\n2 - Get all data\n3 - exit");
			System.out.print("Enter your choice : ");
			try {
				int choice = Integer.parseInt(bf.readLine());
				switch (choice) {
				case 1:
					try {
						Car car = DataRWutil.readCarData();
						System.out.println(CS.addCar(car));
					} catch (AppException e) {
						System.out.println(e.getMessage() + " : " + e.getCause());
					}
					break;

				case 2:
					try {
						LinkedList<Car> resultList = (LinkedList<Car>) CS.getAllCars();
						Collections.sort(resultList);
						Map<Integer,Car> resultMap = new HashMap<>();
						resultList.forEach(i ->{
							resultMap.put(i.getModelNum(), i);
						});
						System.out.println("LIST : \n"+resultList);
						System.out.println("MAP : \n"+resultMap);
					} catch (ServiceException e) {
						System.out.println(e.getMessage() + " : " + e.getCause());
					}
					break;

				case 3:
					System.out.println("Bye...");
					System.exit(0);

				default:
					System.out.println("Enter valid choice!!");
				}
			} catch (IOException e) {
				throw new AppException(e.getMessage(), e.getCause());
			}
		}
	}

}
