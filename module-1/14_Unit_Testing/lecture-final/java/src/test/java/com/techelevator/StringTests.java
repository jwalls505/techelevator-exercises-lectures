package com.techelevator;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class StringTests {

	
	@Before
	public void setup() {
		System.out.println("In setup");
	}
	
	@After
	public void teardown() {
		System.out.println("In teardown");
	}
	

	@Test
	public void startsWith_hello_for_hello_world_returns_true() {
		System.out.println("startsWith_hello_for_hello_world_returns_true");
		
		// Arrange
		String testString = "Hello World!";
		
		// Act
		boolean actual = testString.startsWith("Hello");
		
		// Assert
		Assert.assertTrue("The String did not start with Hello as expected.", actual);
	}
	
	@Test
	public void length_of_three_character_string_returns_three() {
		System.out.println("length_of_three_character_string_returns_three");
		
		// Arrange
		String someString = "s2v";
		
		// Act
		int actualLength = someString.length();
		
		// Assert
		Assert.assertEquals(3, actualLength);
	}
	
}
