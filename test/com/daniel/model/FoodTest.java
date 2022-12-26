package com.daniel.model;

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

@RunWith(Parameterized.class)
public class FoodTest {

	Food testFood = new Food();

	private String foodName;
	private Date dop;
	private Date doe;
	private String expectedString;
	public FoodTest(String foodName, Date dop, Date doe, String toStr) {
		this.foodName = foodName;
		this.dop = dop;
		this.doe = doe;
		this.expectedString = toStr;
	}
	
	@Parameters
	public static Collection<Object[]> data() throws ParseException {
		return Arrays.
				asList(new Object[][] {
					{"Pizza", new SimpleDateFormat("MM/dd/yyyy").parse("11/04/2022"),new SimpleDateFormat("MM/dd/yyyy").parse("12/04/2022"), 
						"Food [foodName=Pizza, dop=2022-Nov-04, doe=2022-Nov-04]"}
				});
	}
	
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() throws ParseException {
		testFood.setFoodName(foodName);
		testFood.setDoP(dop);
		testFood.setDoE(doe);
		
		assertEquals(this.foodName, testFood.getFoodName());
		assertEquals(this.dop, testFood.getDoP());
		assertEquals(this.doe, testFood.getDoE());
		
        //assertEquals(this.expectedString, testFood.toString());
	}
	
}
