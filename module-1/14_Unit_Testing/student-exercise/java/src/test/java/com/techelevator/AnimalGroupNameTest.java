package com.techelevator;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

public class AnimalGroupNameTest {
	 
	@Test
	public void getHerd_animalGiraffe_lowerCase_returnsTower() {
		//Arrange
		AnimalGroupName testAnimals = new AnimalGroupName();
		
		//Act
		String getHerd = testAnimals.getHerd("giraffe");
	
		
		//Assert
		Assert.assertEquals("Tower", getHerd);
		
	}
	
	@Test
	public void getHer_animalRHINO_allCaps_returnsCrash() {
		AnimalGroupName testAnimals = new AnimalGroupName();
		
		String getHerd = testAnimals.getHerd("RHINO");
		
		Assert.assertEquals("Crash", getHerd);
	}
	@Test
	public void getHerd_emptyTest_returnUnknown() {
		AnimalGroupName testAnimals = new AnimalGroupName();
		
		String getHerd = testAnimals.getHerd("");
		
		Assert.assertEquals("unknown", getHerd);
	}
	
	@Test
	public void getHer_nullTest_returnUnknown() {
		AnimalGroupName testAnimals = new AnimalGroupName();
		
		String getHerd = testAnimals.getHerd(null);
		
		Assert.assertEquals("unknown", getHerd);
	}
	

}
