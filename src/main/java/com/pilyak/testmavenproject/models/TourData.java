package com.pilyak.testmavenproject.models;

public class TourData {
	private int tourID;
	private String nameTour;
	private String description;
	public int getTourID() {
		return tourID;
	}
	public void setTourID(int id_tour) {
		this.tourID = id_tour;
	}
	public String getNameTour() {
		return nameTour;
	}
	public void setNameTour(String name_tour) {
		this.nameTour = name_tour;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "TourData [Tour ID = " + tourID + ", Tour name = " + nameTour + ", Description: " + description + "]\n";
	}
	
}
