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
import com.daniel.util.DbUtil;

public class FoodDao {

	private Connection connection;

	public FoodDao() {
		connection = DbUtil.getConnection();
	}

	public void addFood(Food food) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("insert into foods(name,dop,doe) values (?, ?, ?)");
			// Parameters start with 1
			preparedStatement.setString(1, food.getFoodName());
			preparedStatement.setDate(2, new java.sql.Date(food.getDoP().getTime()));
			preparedStatement.setDate(3, new java.sql.Date(food.getDoE().getTime()));
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void deleteFood(String foodName) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("delete from foods where name=?");
			// Parameters start with 1
			preparedStatement.setString(1, foodName);
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
//	public void updateFood(Food food) {
//		try {
//			PreparedStatement preparedStatement = connection
//					.prepareStatement("update foods set name=?, lastname=?, dob=?, email=?" +
//							"where userid=?");
//			// Parameters start with 1
//			preparedStatement.setString(1, food.getFoodName());
//			preparedStatement.setDate(2, new java.sql.Date(food.getDoP().getTime()));
//			preparedStatement.setDate(3, new java.sql.Date(food.getDoE().getTime()));
//			
//			preparedStatement.setInt(4, food.getUserid());
//			preparedStatement.executeUpdate();
//
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//	}

	public List<Food> getAllFoods() {
		List<Food> foods = new ArrayList<Food>();
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("select * from foods");
			while (rs.next()) {
				Food food = new Food();		
//				food.setFoodId(rs.getString("foodid"));
				food.setFoodName(rs.getString("name"));
				food.setDoP(rs.getDate("dop"));
				food.setDoE(rs.getDate("doe"));
				foods.add(food);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return foods;
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
