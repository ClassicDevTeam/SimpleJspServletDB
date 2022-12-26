package com.daniel.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.daniel.model.Owner;
import com.daniel.util.DbUtil;

public class UserDao {

	private Connection connection;

	public UserDao() {
		connection = DbUtil.getConnection();
	}

	public void addUser(Owner user) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("insert into users(name,age) values (?, ? )");
			// Parameters start with 1
			preparedStatement.setString(1, user.getName());
			preparedStatement.setInt(2, user.getAge());			
			preparedStatement.executeUpdate();
			
			List<String> petList = user.getPetList();
			String ownerName = user.getName();
			for(String petName:petList)
			{
				preparedStatement = connection
						.prepareStatement("insert into owner_pets(owner,pet) values (?, ? )");
				// Parameters start with 1			
				preparedStatement.setString(1, ownerName);
				preparedStatement.setString(2, petName);
				preparedStatement.executeUpdate();	
			}
			
			List<String> shoppingCart = user.getShoppingCart();
//			String ownerName = user.getName();			
			for(String foodName:shoppingCart)
			{
				preparedStatement = connection
						.prepareStatement("insert into owner_foods(owner,food) values (?, ? )");
				// Parameters start with 1			
				preparedStatement.setString(1, ownerName);
				preparedStatement.setString(2, foodName);
				preparedStatement.executeUpdate();	
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void deleteUser(String userName) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("delete from users where name=?");
			// Parameters start with 1
			preparedStatement.setString(1, userName);
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

	public List<Owner> getAllUsers() {
		List<Owner> users = new ArrayList<Owner>();
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("select * from users");
			while (rs.next()) {
				Owner user = new Owner();				
				user.setName(rs.getString("name"));
				user.setAge(rs.getInt("age"));
				
				String ownerName = user.getName();
				try {
					PreparedStatement preparedStatement = connection.
							prepareStatement("select * from owner_pets where owner=?");
					preparedStatement.setString(1, ownerName);
					ResultSet rs1 = preparedStatement.executeQuery();					
					while (rs1.next()) {
						user.addPet(rs1.getString("pet"));
					}
					
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
				try {
					PreparedStatement preparedStatement = connection.
							prepareStatement("select * from owner_foods where owner=?");
					preparedStatement.setString(1, ownerName);
					ResultSet rs1 = preparedStatement.executeQuery();					
					while (rs1.next()) {
						user.addShoppingCart(rs1.getString("food"));
					}
					
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
				users.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return users;
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
