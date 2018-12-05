package com.mindtree.carinfo.service.ServiceImpl;

import java.util.LinkedList;
import java.util.List;

import com.mindtree.carinfo.dao.CarDao;
import com.mindtree.carinfo.dao.DaoImpl.CarDaoImpl;
import com.mindtree.carinfo.entity.Car;
import com.mindtree.carinfo.exception.DaoException;
import com.mindtree.carinfo.exception.ServiceException;
import com.mindtree.carinfo.service.CarService;

public class CarServiceImpl implements CarService {

	CarDao CD = new CarDaoImpl();
	
	@Override
	public String addCar(Car car) throws ServiceException {

		try {
			CD.insertData(car);
			return "Success";
		} catch (DaoException e) {
			throw new ServiceException(e.getMessage(),e.getCause());
		}
	}

	@Override
	public List<Car> getAllCars() throws ServiceException {

		try {
			LinkedList<Car> result = (LinkedList<Car>) CD.fetchData();
			return result;
		} catch (DaoException e) {
			throw new ServiceException(e.getMessage(),e.getCause());
		}
	}
}
