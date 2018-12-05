package com.mindtree.carinfo.dao;

import java.util.List;

import com.mindtree.carinfo.entity.Car;
import com.mindtree.carinfo.exception.DaoException;


public interface CarDao {
	
	public void insertData(Car car) throws DaoException;
	public List<Car> fetchData()  throws DaoException;

}
