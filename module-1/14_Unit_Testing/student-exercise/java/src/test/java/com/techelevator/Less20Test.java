package com.techelevator;
import org.junit.Test;
import org.junit.Assert;
public class Less20Test {
	
	@Test
	public void isLessThanMultipleOf20_lessThan2() {
		Less20 testLess20 = new Less20();
		
		boolean isLess = testLess20.isLessThanMultipleOf20(18);
		
		Assert.assertTrue(isLess);
	}
	
	@Test
	public void isLessThanMulitpleOf20_lessThan1() {
		Less20 testLess20 = new Less20();
		
		boolean isLess = testLess20.isLessThanMultipleOf20(19);
		
		Assert.assertTrue(isLess);
	}
	@Test
	public void isLessThanMulitpleOf20_is20() {
		Less20 testLess20 = new Less20();
		
		boolean isLess = testLess20.isLessThanMultipleOf20(20);
		
		Assert.assertFalse(isLess);
	}

}
