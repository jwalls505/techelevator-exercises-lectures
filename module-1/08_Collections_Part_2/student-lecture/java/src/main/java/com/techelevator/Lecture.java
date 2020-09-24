package com.techelevator;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Lecture {

	public static void main(String[] args) {

		System.out.println("####################");
		System.out.println("        MAPS");
		System.out.println("####################");
		System.out.println();
		Map<String, Integer> breakOutGroup = new HashMap<>();
		breakOutGroup.put("Jesse", 1);
		breakOutGroup.put("David", 2);
		breakOutGroup.put("Firdav", 3);
		System.out.println(breakOutGroup);
		Set<String> names = new HashSet<String>();
		names.add("Dave");
		names.add("Dan");
		names.add("Elizabeth");
		for(String name : names) {
			System.out.println(name);
		}
		
		
		int sizeOfSet = names.size();
		
		boolean isEMptySet=names.isEmpty();
		
		names.remove("David");
		
		boolean hasDan = names.contains("Dan");
	}

}
