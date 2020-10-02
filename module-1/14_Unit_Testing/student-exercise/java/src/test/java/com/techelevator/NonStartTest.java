package com.techelevator;

import org.junit.Assert;
import org.junit.Test;


public class NonStartTest {
	@Test
	public void getPartialString_returnWithoutFirstChar() {
		NonStart partialString = new NonStart();
		
		String newString = partialString.getPartialString("Hello", "There");
		
		Assert.assertEquals(newString, "ellohere");
	}

	
	@Test
	public void getPartialString_noAinput() {
		NonStart partialString = new NonStart();
		
		String newString = partialString.getPartialString("", "code");
		
		Assert.assertEquals(newString, "ode");
	}
	@Test
	public void getPartialString_noBInput() {
		NonStart partialString = new NonStart();
		
		String newString = partialString.getPartialString("java", "");
		
		Assert.assertEquals(newString, "ava");
	}

}
