package com.daniel.model;

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

@RunWith(Parameterized.class)
public class PetTest {

	Pet testPet = new Pet();

	private String petName;
	private int age;
	private String ownerName;
	private List<String> favoriteFoodList;
	private String expectedString;
	
	public PetTest(String petName, int age, String ownerName, List<String> favoriteFoodList, String expectedString) {
		this.petName = petName;
		this.age = age;
		this.ownerName = ownerName;
		this.favoriteFoodList = favoriteFoodList;
		this.expectedString = expectedString;
	}
	
	@Parameters
	public static Collection<Object[]> data() {
		return Arrays.
				asList(new Object[][] {
					{"Porky", 10, "John", Arrays.asList("Apple","Pork"),
						"Pet [PetName=Porky, Age=10, Owner=John, FavoriteFood=[Apple,Pork]]"}
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
		testPet.setPetName(petName);
		testPet.setAge(age);
		testPet.setOwner(ownerName);

		for(String food : favoriteFoodList) {
			testPet.addFavoriteFood(food);
		}
		
		assertEquals(this.petName, testPet.getPetName());
		assertEquals(this.age, testPet.getAge());
		assertEquals(this.ownerName, testPet.getOwner());
        assertEquals(this.expectedString, testPet.toString());
        
        assertEquals(2, testPet.getFavoriteFoodList().size());
        testPet.setClearFavoriteFoodList();
        assertEquals(0, testPet.getFavoriteFoodList().size());
	}
	
}
