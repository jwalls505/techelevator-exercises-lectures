package com.techelevator;
import org.junit.Assert;
import org.junit.Test;
public class StringBitsTest {
	@Test
	public void getBits_newString_returnEveryOtherChar() {
		StringBits bitsTest = new StringBits();
		
		String newString = bitsTest.getBits("Hello");
		
		Assert.assertEquals("Hlo", newString);
	}
	
	@Test
	public void getBits_newString_nullCheck() {
		StringBits bitsTest = new StringBits();
		
		String newString = bitsTest.getBits(null);
		
		Assert.assertEquals(newString, null);
	}
	

}
