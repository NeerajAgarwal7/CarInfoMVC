package com.mindtree.carinfo.dao.DaoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import com.mindtree.carinfo.dao.CarDao;
import com.mindtree.carinfo.entity.Car;
import com.mindtree.carinfo.exception.DaoException;
import com.mindtree.carinfo.utility.DButil;

public class CarDaoImpl implements CarDao {

	@Override
	public void insertData(Car car) throws DaoException {

		try (Connection con = DButil.getCon()) {
			String sql = "insert into car values(?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, car.getModelNum());
			ps.setString(2, car.getModelName());
			ps.setDouble(3, car.getPrice());
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			throw new DaoException("Cannot add data", e.getCause());
		}
	}

	@Override
	public LinkedList<Car> fetchData() throws DaoException {

		try(Connection con = DButil.getCon()){
			LinkedList<Car> resultList = new LinkedList<>();
			
			String sql = "select * from car";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs =  ps.executeQuery();
			
			while(rs.next()) {
				Car c = new Car();
				c.setModelNum(rs.getInt(1));
				c.setModelName(rs.getString(2));
				c.setPrice(rs.getDouble(3));
				resultList.add(c);
			}
			return resultList;
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DaoException("Cannot fetch data", e.getCause());
		}
		
	}

}
