package com.daniel.model;

import java.util.Date;

public class Food {

	private String foodName;
	private Date dop;
	private Date doe;
	
	//FoodName get/set
	public String getFoodName() {
		return foodName;
	}
	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}
	
	//Date of Produce get/set
	public Date getDoP() {
		return dop;
	}
	public void setDoP(Date dop) {
		this.dop = dop;
	}

	//Date of Expired get/set
	public Date getDoE() {
		return doe;
	}
	public void setDoE(Date doe) {
		this.doe = doe;
	}
	@Override
	public String toString() {
		return "Food [foodName=" + foodName + ", dop=" + dop
				+ ", doe=" + doe + "]";
	}
	
	
}
