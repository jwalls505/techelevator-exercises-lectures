package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class Lucky13Test {
	
	@Test
	public void lucky13_nullcheck() {
		Lucky13 testLucky = new Lucky13();

		boolean lucky13 = testLucky.getLucky(null);
		
		Assert.assertEquals(true, lucky13);
	}
	
	@Test
	public void lucky13_if1or3_returnFalse() {
		//int[] nums = new int[] {1,3,5,6};
		Lucky13 testLucky = new Lucky13();
		
		boolean isLucky = testLucky.getLucky(new int[] {1,3,4,5});
		
		Assert.assertFalse(isLucky);
	}
	@Test
	public void lucky13_ifNo1or3_returnTrue() {
		Lucky13 testLucky = new Lucky13();
		
		boolean isLucky = testLucky.getLucky(new int[] {2,4,5,7});
		
		Assert.assertTrue(isLucky);
	}
}
