package com.techelevator;
import org.junit.Assert;

import org.junit.Test;


public class FrontTimesTest {
	
	@Test
	public void generateString_withGivenInt_duplicateFront3chars() {
		FrontTimes testTimes = new FrontTimes();
		
		String dupTimes = testTimes.generateString("Chocolate", 2);
		
		Assert.assertEquals("ChoCho", dupTimes);
	}
	
	@Test
	public void generateString_withNullCheck_returnNull() {
		FrontTimes testTimes = new FrontTimes();
		
		String dupTimes = testTimes.generateString("", 0);
		
		Assert.assertEquals("", dupTimes);
	}
	@Test
	public void generateString_withLessThen3Chars() {
		FrontTimes testTimes = new FrontTimes();
		
		String dupTimes = testTimes.generateString("Ch", 5);
		
		Assert.assertEquals("ChChChChCh", dupTimes);
	}

}
