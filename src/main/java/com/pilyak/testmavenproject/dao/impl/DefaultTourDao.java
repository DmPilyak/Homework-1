package com.pilyak.testmavenproject.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.pilyak.testmavenproject.dao.TourDao;
import com.pilyak.testmavenproject.models.TourData;

public class DefaultTourDao implements TourDao {
	private static final String SELECT_TOUR_BY_ID = "SELECT * FROM tours WHERE id_tour = ?";
	private static final String SELECT_ALL_TOURS = "SELECT * FROM tours";
	private static final String URL = "jdbc:mysql://localhost:3306/group1_db?useUnicode=true&serverTimezone=GMT%2B8";
	private static final String USER = "root";
	private static final String PASSWORD = "root";
	
	@Override
	public TourData getTourByID(int id_tour) {
		TourData tour = null;
		try (Connection conn = getConnection();
				PreparedStatement ps = conn.prepareStatement(SELECT_TOUR_BY_ID)) {
			
			ps.setInt(1, id_tour);
			try (ResultSet rs = ps.executeQuery();) {
				if (rs.next()) {
					tour = new TourData();
					tour.setTourID(rs.getInt("id_tour"));
					tour.setNameTour(rs.getString("name_tour"));
					tour.setDescription(rs.getString("description"));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return tour;
	}

	private Connection getConnection() {
		try {
			return DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<TourData> getAllTours() {
		TourData tour = null;
		List<TourData> usersList = new ArrayList<>();
		try (Connection conn = getConnection();
				Statement ps = conn.createStatement()) {
			
			try (ResultSet rs = ps.executeQuery(SELECT_ALL_TOURS);) {
				while (rs.next()) {
					tour = new TourData();
					tour.setTourID(rs.getInt("id_tour"));
					tour.setNameTour(rs.getString("name_tour"));
					tour.setDescription(rs.getString("description"));
					usersList.add(tour);
					//user.setRole(roleDao.getRoleById(rs.getInt("role_id")));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return usersList;
	}
	
}
