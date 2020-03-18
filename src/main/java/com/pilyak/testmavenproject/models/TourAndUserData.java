package com.pilyak.testmavenproject.models;

public class TourAndUserData {
	private int tourID;
	private int userID;
	public int getTourID() {
		return tourID;
	}
	public void setTourID(int tourID) {
		this.tourID = tourID;
	}
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public String toString() {
		return "TourAndUserData [ User ID = " + userID + " ordered Tour ID = " + tourID + "]\n";
	}
	
}
