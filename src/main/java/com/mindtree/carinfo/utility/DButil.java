package com.mindtree.carinfo.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mindtree.carinfo.exception.DaoException;

public class DButil {

	public static Connection getCon() throws DaoException {

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/carinfo", "root", "Welcome123");
			return con;
		} catch (SQLException e) {
			throw new DaoException("Cannot find database", e.getCause());
		} catch (ClassNotFoundException e) {
			throw new DaoException("Cannot make a connection", e.getCause());
		}
	}
}