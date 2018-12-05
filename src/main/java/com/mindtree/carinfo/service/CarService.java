package com.mindtree.carinfo.service;

import java.util.List;

import com.mindtree.carinfo.entity.Car;
import com.mindtree.carinfo.exception.ServiceException;

public interface CarService {

	public String addCar(Car car) throws ServiceException;

	public List<Car> getAllCars() throws ServiceException;

}
