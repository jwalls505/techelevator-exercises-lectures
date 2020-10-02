package com.techelevator;

import org.junit.Assert;

import org.junit.Test;

public class CigarPartyTests {
	@Test
	public void haveParty_with_fifty_cigars_on_weekday_returns_true() {
		//Arrange
		CigarParty myCigarParty = new CigarParty();
		
		//Act
		boolean haveParty = myCigarParty.haveParty(50, false); 
		
		
		//Assert
		Assert.assertTrue(haveParty);
		
	}
	@Test
	public void haveParty_with_30_cigars_on_weekday_returnsFalse() {
		CigarParty myCigarParty = new CigarParty();
		
		boolean haveParty = myCigarParty.haveParty(30, false);
		
		Assert.assertFalse(haveParty); 
	}
	@Test
	public void haveParty_with_70_cigars_on_weekend_returnsTrue() {
		CigarParty myCigarParty = new CigarParty();
		
		boolean haveParty = myCigarParty.haveParty(70, true);
		
		Assert.assertTrue(haveParty);
	}
	@Test
	public void haveParty_with_70_cigars_onWeekday_returnsFalse() {
		CigarParty myCigarParty = new CigarParty();
		
		boolean haveParty = myCigarParty.haveParty(70, false);
		
		Assert.assertFalse(haveParty);
	}
	

}
