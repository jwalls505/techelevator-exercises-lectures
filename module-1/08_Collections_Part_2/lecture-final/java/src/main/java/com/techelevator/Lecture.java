package com.techelevator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Lecture {

	public static void main(String[] args) {

		System.out.println("####################");
		System.out.println("        MAPS");
		System.out.println("####################");
		System.out.println();

		Map<String, String> namesToZip = new HashMap<String, String>();
		
		namesToZip.put("David", "44120");
		namesToZip.put("Dan", "44124");
		namesToZip.put("Elizabeth", "44012");
		
		System.out.println("David lives in " + namesToZip.get("David"));
		System.out.println("Dan lives in " + namesToZip.get("Dan"));
		System.out.println("Elizabeth lives in " + namesToZip.get("Elizabeth"));
		System.out.println();
		
		List<String> namesList = new ArrayList<String>();
		for(String name : namesList) {
			
		}
				
		for(Map.Entry<String, String> nz : namesToZip.entrySet()) {
			System.out.println(nz.getKey() + " lives in " + nz.getValue());
		}
		
		for(String name : namesToZip.keySet()) {
			System.out.println(name + " lives in " + namesToZip.get(name));
		}
		
		namesToZip.remove("David");
		
		
		System.out.println("####################");
		System.out.println("        MAPS");
		System.out.println("####################");
		System.out.println();

		
		Set<String> names = new HashSet<String>();
		
		names.add("David");
		names.add("Dan");
		names.add("Elizabeth");
		names.add("David");
		
		for(String name : names) {
			System.out.println(name);
		}
		
		int sizeOfSet = names.size();
		
		boolean isEmptySet = names.isEmpty();
		
		names.remove("David");
		
		boolean hasDavid = names.contains("David");
		
		System.out.println("####################");
		System.out.println("        ALGORITHMIC COMPLEXITY");
		System.out.println("####################");
		System.out.println();

		doesContainDuplicate(new int[] {0, 1, 6, 3, 4, 1, 5});
		
	}
	
	// [0, 1, 5, 10]
	// [0, 1, 10, 5, 100, 50, 60]
	
	public boolean isLastElementEven(int[] nums) {
		int lastElement = nums[nums.length - 1];
		boolean isEven = lastElement % 2 == 0;
		return isEven;
	}
	
	public boolean containsTen(int[] nums) {
		
		for(int num : nums) {
			if(num == 10) {
				return true;
			}
		}
		
		return false;
	}
	
	
	
	// [0, 1, 6, 3, 4, 1, 5]
	//     ^           ^                            	
	public static boolean doesContainDuplicate(int[] nums) {
		
		for(int i = 0; i < nums.length; i++) {
			for(int j = i; j < nums.length; j++) {
 				if(i == j) {
					continue;
				}
				
				if(nums[i] == nums[j]) {
					return true;
				}
						
			}
		}
		
		return false;
		
	}
	
	

}
