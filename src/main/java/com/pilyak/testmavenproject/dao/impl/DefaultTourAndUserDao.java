package com.pilyak.testmavenproject.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.pilyak.testmavenproject.dao.TourAndUserDao;
import com.pilyak.testmavenproject.models.TourAndUserData;

public class DefaultTourAndUserDao implements TourAndUserDao{
	private static final String SELECT_ALL_USER_TOURS = "SELECT * FROM users_tours WHERE id_user = ?";
	/*private static final String SELECT_ALL_USER_TOURS = "SELECT \r\n" + 
			"	users.id,\r\n" + 
			"    users.first_name,\r\n" + 
			"    users.last_name,\r\n" + 
			"    tours.name_tour\r\n" + 
			"FROM users\r\n" + 
			"JOIN users_tours ON users.id = users_tours.id_user\r\n" + 
			"JOIN tours ON tours.id_tour = users_tours.id_tour\r\n" + 
			"WHERE users.id = ?";*/
	private static final String URL = "jdbc:mysql://localhost:3306/group1_db?useUnicode=true&serverTimezone=GMT%2B8";
	private static final String USER = "root";
	private static final String PASSWORD = "root";
	
	@Override
	public List<TourAndUserData> getUsersTourByUsersID(int id_user) {
		TourAndUserData tour = null;
		List<TourAndUserData> usersList = new ArrayList<>();
		try (Connection conn = getConnection();
				PreparedStatement ps = conn.prepareStatement(SELECT_ALL_USER_TOURS)) {
			ps.setInt(1, id_user);
			
			try (ResultSet rs = ps.executeQuery();) {
				while (rs.next()) {
					tour = new TourAndUserData();
					tour.setTourID(rs.getInt("id_tour"));
					tour.setUserID(rs.getInt("id_user"));
					usersList.add(tour);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return usersList;
	}
	private Connection getConnection() {
		try {
			return DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
