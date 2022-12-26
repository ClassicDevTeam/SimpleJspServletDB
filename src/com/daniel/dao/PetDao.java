package com.daniel.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.daniel.model.Food;
import com.daniel.model.Owner;
import com.daniel.model.Pet;
import com.daniel.util.DbUtil;

public class PetDao {

	private Connection connection;

	public PetDao() {
		connection = DbUtil.getConnection();
	}

	public void addPet(Pet pet) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("insert into pets(name,age,owner) values (?, ?, ? )");
			// Parameters start with 1
			preparedStatement.setString(1, pet.getPetName());
			preparedStatement.setInt(2, pet.getAge());
			preparedStatement.setString(3, pet.getOwner());
			preparedStatement.executeUpdate();
			
			List<String> favoritFoodList = pet.getFavoriteFoodList();
			String petName = pet.getPetName();
			for(String foodName:favoritFoodList)
			{
				preparedStatement = connection
						.prepareStatement("insert into pet_foods(pet,food) values (?, ? )");
				// Parameters start with 1			
				preparedStatement.setString(1, petName);
				preparedStatement.setString(2, foodName);
				preparedStatement.executeUpdate();	
			}
			

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void deletePet(String petName) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("delete from pets where name=?");
			// Parameters start with 1
			preparedStatement.setString(1, petName);
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
//	public void updateUser(Owner user) {
//		try {
//			PreparedStatement preparedStatement = connection
//					.prepareStatement("update users set firstname=?, lastname=?, dob=?, email=?" +
//							"where userid=?");
//			// Parameters start with 1
//			preparedStatement.setString(1, user.getFirstName());
//			preparedStatement.setString(2, user.getLastName());
//			preparedStatement.setDate(3, new java.sql.Date(user.getDob().getTime()));
//			preparedStatement.setString(4, user.getEmail());
//			preparedStatement.setInt(5, user.getUserid());
//			preparedStatement.executeUpdate();
//
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//	}

	public List<Pet> getAllPets() {
		List<Pet> pets = new ArrayList<Pet>();
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("select * from pets");
			
			while (rs.next()) {
				Pet pet = new Pet();
				pet.setPetName(rs.getString("name"));
				pet.setAge(rs.getInt("age"));
				pet.setOwner(rs.getString("owner"));
				String petName = pet.getPetName();
				try {
					PreparedStatement preparedStatement = connection.
							prepareStatement("select * from pet_foods where pet=?");
					preparedStatement.setString(1, petName);
					ResultSet rs1 = preparedStatement.executeQuery();					
					while (rs1.next()) {
						pet.addFavoriteFood(rs1.getString("food"));
					}
					
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
				pets.add(pet);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return pets;
	}
	
//	public Owner getUserById(int userId) {
//		Owner user = new Owner();
//		try {
//			PreparedStatement preparedStatement = connection.
//					prepareStatement("select * from users where userid=?");
//			preparedStatement.setInt(1, userId);
//			ResultSet rs = preparedStatement.executeQuery();
//			
//			if (rs.next()) {
//				user.setUserid(rs.getInt("userid"));
//				user.setFirstName(rs.getString("firstname"));
//				user.setLastName(rs.getString("lastname"));
//				user.setDob(rs.getDate("dob"));
//				user.setEmail(rs.getString("email"));
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//
//		return user;
//	}
}
