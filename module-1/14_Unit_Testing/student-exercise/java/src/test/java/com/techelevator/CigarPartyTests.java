package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class CigarPartyTests {

	@Test
	public void haveParty_with_fifty_cigars_on_weekday_returns_true() {
		// Arrange
		CigarParty myCigarParty = new CigarParty();
		
		// Act
		boolean havePartyCaseOne = myCigarParty.haveParty(50, false);
		boolean havePartyCaseTwo = myCigarParty.haveParty(30, false);
		
		// Assert
		Assert.assertTrue(havePartyCaseOne);
		Assert.assertFalse(havePartyCaseTwo);
	}
	
}
