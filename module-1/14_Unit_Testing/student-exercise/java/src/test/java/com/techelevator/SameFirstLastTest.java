package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class SameFirstLastTest {
	
	@Test
	public void isItTheSame_firstAndLastElementEqual_returnTrue() {
		SameFirstLast testTheSame = new SameFirstLast();
		
		boolean isItEqual = testTheSame.isItTheSame(new int[] {1,3,4,1});
		
		Assert.assertTrue(isItEqual);
		
	}
	@Test
	public void isItTheSame_firstAndLastElementEqual_returnFalse() {
		SameFirstLast testTheSame = new SameFirstLast();
		
		boolean isItEqual = testTheSame.isItTheSame(new int[] {4,3,4,1});
		
		Assert.assertFalse(isItEqual);
	}
	@Test
	public void isItTheSame_nullCheck() {
		SameFirstLast testTheSame = new SameFirstLast();
		
		boolean isItEqual = testTheSame.isItTheSame(null);
		
		Assert.assertFalse(isItEqual);
	}

}
