package com.sourceit.hw.num6;

public class Candy {
	private String candy_name;
	private String candy_type;
	private double weight;
	private double sugar;
	
	Candy(String candy_name, String candy_type, double weight, double sugar){
		this.candy_name = candy_name;
		this.candy_type = candy_type;
		this.weight = weight;
		this.sugar = sugar;
	}

	public String getCandy_type() {
		return candy_type;
	}

	public String getCandy_name() {
		return candy_name;
	}

	public double getWeight() {
		return weight;
	}

	public double getSugar() {
		return sugar;
	}
	

}
