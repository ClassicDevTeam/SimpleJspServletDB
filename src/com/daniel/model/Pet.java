package com.daniel.model;

import java.util.ArrayList;
import java.util.List;

public class Pet {

	private String petName;
	private int age;
	private String ownerName; 
	private List<String> favoriteFoodList;
	
	public Pet()
	{
		this.favoriteFoodList = new ArrayList<String>();		
	}
	
	//PetName get/set
	public String getPetName() {
		return petName;
	}
	public void setPetName(String petName) {
		this.petName = petName;
	}
	
	//Age get/set
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}

	//Owner get/set
	public String getOwner() {
		return ownerName;
	}
	public void setOwner(String ownerName) {
		this.ownerName = ownerName;
	}
	
	//FavoriteFoodList get/add/setClear
	public String getFavoriteFoodListString()
	{
		String strFoodList="";
		int i = 0;
		for(; i< favoriteFoodList.size()-1;i++)
		{
			strFoodList = strFoodList + favoriteFoodList.get(i) + ",";
		}
		strFoodList = strFoodList + favoriteFoodList.get(i);
		return strFoodList;
	}
	public List<String> getFavoriteFoodList(){
		return favoriteFoodList;
	}
	public void addFavoriteFood(String foodName) {		
		this.favoriteFoodList.add(foodName);
	}
	public void setClearFavoriteFoodList() {
		this.favoriteFoodList.clear();
	}
	@Override
	public String toString() {
		return "Pet [PetName=" + petName + ", Age=" + age
				+ ", Owner=" + ownerName + ", FavoriteFood=[" + getFavoriteFoodListString() +"]]";
	}
	
	
}
