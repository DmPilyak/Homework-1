package com.pilyak.testmavenproject.dao;

import java.util.List;

import com.pilyak.testmavenproject.models.TourAndUserData;

public interface TourAndUserDao {
	List<TourAndUserData> getUsersTourByUsersID(int i);
}
