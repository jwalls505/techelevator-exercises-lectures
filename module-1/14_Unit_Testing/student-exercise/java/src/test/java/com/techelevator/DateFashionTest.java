package com.techelevator;
import org.junit.Test;
import org.junit.Assert;

public class DateFashionTest {
	
	@Test
	public void getTable_youOrDateHave8to10_return2() {
		DateFashion testFashion = new DateFashion();
		
		int getTable = testFashion.getATable(5, 10);
		
		Assert.assertEquals(2, getTable);
	}
	@Test
	public void getTable_youOrDateHave3To7_return1() {
		DateFashion testFashion = new DateFashion();
		
		int getTable = testFashion.getATable(5, 5);
		
		Assert.assertEquals(1, getTable);
	}
	
	@Test
	public void getTable_youOrDateHave2to0_return1() {
		DateFashion testFashion = new DateFashion();
		
		int getTable = testFashion.getATable(2, 6);
		
		Assert.assertEquals(0, getTable);
	}

}
