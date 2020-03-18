package com.pilyak.testmavenproject.dao;

import java.util.List;

import com.pilyak.testmavenproject.models.TourData;

public interface TourDao {
	TourData getTourByID(int i);
	List<TourData> getAllTours();
}
