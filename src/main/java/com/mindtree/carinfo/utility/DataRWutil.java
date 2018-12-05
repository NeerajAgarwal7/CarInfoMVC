package com.mindtree.carinfo.utility;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

import com.mindtree.carinfo.entity.Car;
import com.mindtree.carinfo.exception.AppException;

public class DataRWutil {

	static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

	public static Car readCarData() throws AppException {

		try {
			Car c = new Car();
			System.out.print("Enter car model num : ");
			c.setModelNum(Integer.parseInt(bf.readLine()));
			System.out.print("Enter car model name : ");
			c.setModelName(bf.readLine());
			System.out.println("Enter car price : ");
			c.setPrice(Double.parseDouble(bf.readLine()));
			return c;
		} catch (NumberFormatException e) {
			throw new AppException("Invalid input type!! check your input", e.getCause());
		} catch (IOException e) {
			throw new AppException("Sorry cannot read data", e.getCause());
		}
	}

	public static LinkedList<Car> readDataFile(String filename) throws AppException {

		LinkedList<Car> carList = new LinkedList<>();
		String line = null;
		try(BufferedReader fileread = new BufferedReader(new FileReader(filename))){
			
			while((line=fileread.readLine())!=null) {
				String[] str = line.split(",");
				Car c = new Car(Integer.parseInt(str[0]),str[1],Double.parseDouble(str[2]));
				carList.add(c);
			}
		return carList;
		} catch (FileNotFoundException e) {
			throw new AppException("Cannot fetch file!! please check file path",e.getCause());
		} catch (IOException e) {
			throw new AppException("Cannot read data from file",e.getCause());
		}
	}

}
