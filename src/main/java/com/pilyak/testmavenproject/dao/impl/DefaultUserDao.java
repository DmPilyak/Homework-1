package com.pilyak.testmavenproject.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.pilyak.testmavenproject.dao.UserDao;
import com.pilyak.testmavenproject.models.UserData;

public class DefaultUserDao implements UserDao {
	private static final String SELECT_USER_BY_ID = "SELECT * FROM users WHERE id = ?";
	private static final String SELECT_ALL_USERS = "SELECT * FROM users";
	private static final String URL = "jdbc:mysql://localhost:3306/group1_db?useUnicode=true&serverTimezone=GMT%2B8";
	private static final String USER = "root";
	private static final String PASSWORD = "root";
	
	
	@Override
	public UserData getUserByID(int id) {
		UserData user = null;
		try (Connection conn = getConnection();
				PreparedStatement ps = conn.prepareStatement(SELECT_USER_BY_ID)) {
			
			ps.setInt(1, id);
			try (ResultSet rs = ps.executeQuery();) {
				if (rs.next()) {
					user = new UserData();
					user.setFirstName(rs.getString("first_name"));
					user.setLastName(rs.getString("last_name"));
					user.setEmail(rs.getString("e-mail"));
					user.setId(rs.getInt("id"));
					//user.setRole(roleDao.getRoleById(rs.getInt("role_id")));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}
	
	private Connection getConnection() {
		try {
			return DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public List<UserData> getAllUsers() {
		UserData user = null;
		List<UserData> usersList = new ArrayList<>();
		try (Connection conn = getConnection();
				Statement ps = conn.createStatement()) {
			
			try (ResultSet rs = ps.executeQuery(SELECT_ALL_USERS);) {
				while (rs.next()) {
					user = new UserData();
					user.setFirstName(rs.getString("first_name"));
					user.setLastName(rs.getString("last_name"));
					user.setEmail(rs.getString("e-mail"));
					user.setId(rs.getInt("id"));
					usersList.add(user);
					//user.setRole(roleDao.getRoleById(rs.getInt("role_id")));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return usersList;
		
	}

}
