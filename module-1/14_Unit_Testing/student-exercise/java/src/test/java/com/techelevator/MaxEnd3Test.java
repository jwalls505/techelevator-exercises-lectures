package com.techelevator;
import org.junit.Assert;
import org.junit.Test;
public class MaxEnd3Test {
	@Test
	public void makeArray_isFirstOrLastBigger_returnBigger() {
		MaxEnd3 testArray = new MaxEnd3();
		
		int[] maxTest = testArray.makeArray(new int[] {77,77,77,77});
		
		Assert.assertArrayEquals(maxTest, maxTest);
	}
	@Test
	public void makeArray_isFirstOrLastBigger_returnBigger2() {
		MaxEnd3 testArray = new MaxEnd3();
		
		int[] maxTest = testArray.makeArray(new int[] {50, 2,4,23});
		
		Assert.assertArrayEquals(new int[] {50,50,50,50}, maxTest);
	}
	

}
