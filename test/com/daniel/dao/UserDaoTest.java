package com.daniel.dao;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.daniel.model.Owner;

@RunWith(Parameterized.class)
public class UserDaoTest {

	Owner testOwner = new Owner();
	UserDao testOwnerDao = new UserDao();
	private int userCount;
	public UserDaoTest(String name, int age, List<String> petList, List<String> shoppingCart) {
		testOwner.setName(name);
		testOwner.setAge(age);
		for(String pet : petList) {
			testOwner.addPet(pet);
		}
		for(String food: shoppingCart) {
			testOwner.addShoppingCart(food);
		}
		userCount = testOwnerDao.getAllUsers().size();
	}
	
	@Parameters
	public static Collection<Object[]> data() {
		return Arrays.
				asList(new Object[][] {
					{"John", 35,
					Arrays.asList("Porky","Joker","Kittie"),
					Arrays.asList("Cookie","Salad","Chocolate","Candy"),
					}
				});
	}
	
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		testOwnerDao.addUser(testOwner);
		assertEquals(userCount + 1, testOwnerDao.getAllUsers().size());
		
		testOwnerDao.deleteUser(testOwner.getName());
		assertEquals(userCount, testOwnerDao.getAllUsers().size());
		
	}
	
}
