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

import com.daniel.model.Pet;

@RunWith(Parameterized.class)
public class PetDaoTest {

	Pet testPet = new Pet();
	PetDao testPetDao = new PetDao();
	
	private int petCount;
	public PetDaoTest(String petName, int age, String ownerName, List<String> favoriteFoodList) {
		testPet.setPetName(petName);
		testPet.setAge(age);
		testPet.setOwner(ownerName);

		for(String food : favoriteFoodList) {
			testPet.addFavoriteFood(food);
		}
		petCount = testPetDao.getAllPets().size();
	}
	
	@Parameters
	public static Collection<Object[]> data() {
		return Arrays.
				asList(new Object[][] {
					{"Porky", 10, "John", Arrays.asList("Apple","Pork"),
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
		testPetDao.addPet(testPet);
		assertEquals(petCount + 1, testPetDao.getAllPets().size());
		
		testPetDao.deletePet(testPet.getPetName());
		assertEquals(petCount, testPetDao.getAllPets().size());
	}
	
}
