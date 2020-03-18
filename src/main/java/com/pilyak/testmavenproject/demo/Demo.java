package com.pilyak.testmavenproject.demo;

import java.util.List;

import com.pilyak.testmavenproject.dao.TourDao;
import com.pilyak.testmavenproject.dao.UserDao;
import com.pilyak.testmavenproject.dao.TourAndUserDao;
import com.pilyak.testmavenproject.dao.impl.DefaultTourDao;
import com.pilyak.testmavenproject.dao.impl.DefaultUserDao;
import com.pilyak.testmavenproject.dao.impl.DefaultTourAndUserDao;
import com.pilyak.testmavenproject.models.UserData;
import com.pilyak.testmavenproject.models.TourData;
import com.pilyak.testmavenproject.models.TourAndUserData;

public class Demo {

	public static void main(String[] args) {
		System.out.println("//Users");
		UserDao userDao = new DefaultUserDao();
		UserData user = userDao.getUserByID(1);
		System.out.println(user);
		List<UserData> listUsers = userDao.getAllUsers();
		System.out.println(listUsers);
		
		System.out.println("//Tours");
		TourDao tourDao = new DefaultTourDao();
		TourData tour = tourDao.getTourByID(2);
		System.out.println(tour);
		List<TourData> listTours = tourDao.getAllTours();
		System.out.println(listTours);
		
		System.out.println("//User tours");
		TourAndUserDao tourAndUserDao = new DefaultTourAndUserDao();
		List<TourAndUserData> userToursLisr = tourAndUserDao.getUsersTourByUsersID(2);
		System.out.println(userToursLisr);
	}

}
