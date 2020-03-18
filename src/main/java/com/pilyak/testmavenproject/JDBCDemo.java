package com.pilyak.testmavenproject;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;


//import com.mysql.cj.jdbc.Driver;

public class JDBCDemo {

	private static final String URL = "jdbc:mysql://localhost:3306/group1_db?useUnicode=true&serverTimezone=GMT%2B8";
	private static final String USER = "root";
	private static final String PASSWORD = "root";
	private static final String SELECT_TOURS_NAME_FOR_USER = "SELECT \r\n" + 
			"	users.id,\r\n" + 
			"    users.first_name,\r\n" + 
			"    users.last_name,\r\n" + 
			"    tours.name_tour\r\n" + 
			"FROM users\r\n" + 
			"JOIN users_tours ON users.id = users_tours.id_user\r\n" + 
			"JOIN tours ON tours.id_tour = users_tours.id_tour\r\n" + 
			"WHERE users.id = 1;";

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		try (var connection = DriverManager
				.getConnection(URL, USER, PASSWORD);
				var st = connection.createStatement();
				var rs = st.executeQuery(SELECT_TOURS_NAME_FOR_USER);     //выполнить запрос
				){
			System.out.println("We have connection");
			while(rs.next()) {
				String tour_name = rs.getString("name_tour");
				System.out.println(tour_name);   
			}
			      
			
		}
	}

}
