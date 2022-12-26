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
public class OwnerTest {

	Owner testOwner = new Owner();

	private String name;
	private int age;
	private List<String> petList;
	private List<String> shoppingCart;
	private String expectedString;
	public OwnerTest(String name, int age, List<String> petList, List<String> shoppingCart, String expectedString) {
		this.name = name;
		this.age = age;
		this.petList = petList;
		this.shoppingCart = shoppingCart;
		this.expectedString = expectedString;
	}
	
	@Parameters
	public static Collection<Object[]> data() {
		return Arrays.
				asList(new Object[][] {
					{"John", 35,
					Arrays.asList("Porky","Joker","Kittie"),
					Arrays.asList("Cookie","Salad","Chocolate","Candy"),
					"Owner [Name=John, Age=35, PetList=[Porky,Joker,Kittie], ShoppingCart=[Cookie,Salad,Chocolate,Candy]]"
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
		testOwner.setName(name);
		testOwner.setAge(age);
		for(String pet : petList) {
			testOwner.addPet(pet);
		}
		for(String food: shoppingCart) {
			testOwner.addShoppingCart(food);
		}
		
		assertEquals(this.name, testOwner.getName());
		assertEquals(this.age, testOwner.getAge());
		assertEquals(this.petList.size(), testOwner.getPetList().size());
		assertEquals(this.shoppingCart.size(), testOwner.getShoppingCart().size());
        assertEquals(this.expectedString, testOwner.toString());
        testOwner.setClearPetList();
        testOwner.setShoppingCartClear();
		assertEquals(0, testOwner.getPetList().size());
		assertEquals(0, testOwner.getShoppingCart().size());
	}
	
}
