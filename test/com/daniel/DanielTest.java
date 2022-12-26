package com.daniel;

import org.junit.runner.RunWith;

import com.daniel.dao.FoodDaoTest;
import com.daniel.dao.PetDaoTest;
import com.daniel.dao.UserDaoTest;
import com.daniel.model.FoodTest;
import com.daniel.model.OwnerTest;
import com.daniel.model.PetTest;
import com.daniel.util.DbUtilTest;

import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
	DbUtilTest.class,
	FoodTest.class,
	OwnerTest.class,
	PetTest.class,
	FoodDaoTest.class,
	PetDaoTest.class,
	UserDaoTest.class
})
public class DanielTest {

}
