package com.daniel.model;

import java.util.ArrayList;
import java.util.List;

public class Owner {

//	private int ownerId;
	private String name;
	private int age;
	private List<String> petList;
	private List<String> shoppingCart;
	
	public Owner()
	{
		this.petList = new ArrayList<String>();
		this.shoppingCart = new ArrayList<String>();
	}
//	//OwnerID get/set
//	public int getOwnerId() {
//		return ownerId;
//	}
//	public void setOwnerId(int ownerId) {
//		this.ownerId = ownerId;
//	}
	
	// Age get/set
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	// Name get/set
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	//PetList get/add/setClear
	public String getPetListString()
	{
		String strPetList="";
		int i = 0;
		for(; i< petList.size()-1;i++)
		{
			strPetList = strPetList + petList.get(i) + ",";
		}
		strPetList = strPetList + petList.get(i);
		return strPetList;
	}
	public List<String> getPetList()
	{
		return petList;
	}
	public void addPet(String pet) {
		this.petList.add(pet);
	}
	public void setClearPetList() {
		this.petList.clear();
	}
	
	//ShoppingCart get/add/setClear
	public String getShoppingCartString()
	{
		String strShoppingCart="";
		int i = 0;
		for(; i< shoppingCart.size()-1;i++)
		{
			strShoppingCart = strShoppingCart + shoppingCart.get(i) + ",";
		}
		strShoppingCart = strShoppingCart + shoppingCart.get(i);
		return strShoppingCart;
	}
	public List<String> getShoppingCart()
	{
		return shoppingCart;
	}
	public void addShoppingCart(String food) {
		this.shoppingCart.add(food);
	}

	public void setShoppingCartClear() {
		this.shoppingCart.clear();
	}
	@Override
	public String toString() {
		return "Owner [Name=" + name + ", Age=" + age
				+ ", PetList=[" + getPetListString() + "], ShoppingCart=[" + getShoppingCartString() + "]]";
	}
	
	
}
