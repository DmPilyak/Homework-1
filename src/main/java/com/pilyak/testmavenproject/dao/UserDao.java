package com.pilyak.testmavenproject.dao;

import java.util.List;

import com.pilyak.testmavenproject.models.UserData;

public interface UserDao {
	UserData getUserByID(int i);
	List<UserData> getAllUsers();
}
