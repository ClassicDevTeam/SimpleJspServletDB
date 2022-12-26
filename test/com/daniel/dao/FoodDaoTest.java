package com.daniel.dao;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.daniel.model.Food;

@RunWith(Parameterized.class)
public class FoodDaoTest {

	Food testFood = new Food();
	FoodDao testFoodDao = new FoodDao();
	private int foodSize;

	public FoodDaoTest(String foodName, Date dop, Date doe) {
		testFood.setFoodName(foodName);
		testFood.setDoP(dop);
		testFood.setDoE(doe);
		foodSize = testFoodDao.getAllFoods().size();
	}
	
	@Parameters
	public static Collection<Object[]> data() throws ParseException {
		return Arrays.
				asList(new Object[][] {
					{"Pizza", new SimpleDateFormat("MM/dd/yyyy").parse("11/04/2022"),
						new SimpleDateFormat("MM/dd/yyyy").parse("12/04/2022"), 
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
		testFoodDao.addFood(testFood);
		assertEquals(foodSize + 1, testFoodDao.getAllFoods().size());
		
		testFoodDao.deleteFood(testFood.getFoodName());
		assertEquals(foodSize, testFoodDao.getAllFoods().size());
	}
	
}
