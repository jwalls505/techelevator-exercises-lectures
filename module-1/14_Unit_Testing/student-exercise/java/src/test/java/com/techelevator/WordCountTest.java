package com.techelevator;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;


public class WordCountTest {
	@Test
	public void getCount_returnCountOfDuplicateStringApperances() {
		WordCount testStrings = new WordCount();
		String[] words = new String[] {"ba", "ba", "black","sheep"};
		
		Map<String, Integer> strCount = testStrings.getCount(words);
		Map<String, Integer> results = new HashMap<>();
		results.put("ba", 2);
		results.put("black", 1);
		results.put("sheep", 1);
		Assert.assertEquals(strCount, results);
	}
	@Test //bug??
	public void getCount_nullTest() {
		WordCount testStrings = new WordCount();
		String[] nullArray = new String[] {null};
		
		
		Map<String, Integer> words = testStrings.getCount(null);
	;
		
		Assert.assertEquals(nullArray, words);
		
		
	}

}
