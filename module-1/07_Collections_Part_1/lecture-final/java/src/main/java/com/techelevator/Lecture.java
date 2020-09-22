package com.techelevator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class Lecture {

	public static void main(String[] args) {
		
		System.out.println("####################");
		System.out.println("       LISTS");
		System.out.println("####################");
		
		List<String> nameList = new ArrayList<String>();
		nameList.add("Walt");
		nameList.add("Beth");
		nameList.add("Tom A");
		nameList.add("Tom M");
		
		System.out.println("####################");
		System.out.println("Lists are ordered");
		System.out.println("####################");
		
		for(int i = 0; i < nameList.size(); i++) {
			System.out.println(nameList.get(i));
		}
		
		System.out.println();
		
		System.out.println(nameList);
		

		System.out.println("####################");
		System.out.println("Lists allow duplicates");
		System.out.println("####################");
		
		nameList.add("Walt");
		
		for(int i = 0; i < nameList.size(); i++) {
			System.out.println(nameList.get(i));
		}
		
		System.out.println();

		System.out.println("####################");
		System.out.println("Lists allow elements to be inserted in the middle");
		System.out.println("####################");
		
		
		nameList.add(1, "Yet another name");
		

		System.out.println("####################");
		System.out.println("Lists allow elements to be removed by index");
		System.out.println("####################");
		nameList.remove(1);
		

		System.out.println("####################");
		System.out.println("Find out if something is already in the List");
		System.out.println("####################");
		
		boolean hasBeth = nameList.contains("Beth");
		boolean hasDan = nameList.contains("Dan");
		boolean hasLowercaseBeth = nameList.contains("beth");	
		
		System.out.println("####################");
		System.out.println("Lists can be turned into an array");
		System.out.println("####################");
		
		String[] namesArray = new String[nameList.size()];
		nameList.toArray(namesArray);
		
		String[] namesArray2 = nameList.toArray(new String[nameList.size()]);
		
		for(int i = 0; i < nameList.size(); i++) {
			namesArray[i] = nameList.get(i);
		}
		
		List<String> newList = Arrays.asList(namesArray);
		
		Collections.sort(nameList);
		
		Collections.reverse(nameList);
		

		System.out.println("####################");
		System.out.println(" PRIMITIVE WRAPPERS");
		System.out.println("####################");

		/* Every primitive data type has an equivalent "primitive wrapper class" that is an object representation
		 * of a primitive value */
		
		List<Integer> fib = new ArrayList<Integer>();
		fib.add(1);
		fib.add(2);
		fib.add(3);
		fib.add(5);
		
		int num25 = 25;
		Integer number25 = new Integer(25);
		Integer number24 = new Integer("24");
				
		if(number25 > number24) {
			System.out.println("25 is larger than 24.");
		}
		
		Double accountBalance = null;
		
		if(accountBalance != null) {
		
			double newAccountBalance = accountBalance + 100;
		
			System.out.println(newAccountBalance);
		} else {
			System.out.println("Sorry you don't have an account.");
		}
		

		System.out.println("####################");
		System.out.println("       FOREACH");
		System.out.println("####################");
		System.out.println();
		
		
		for(int i = 0; i < nameList.size(); i++) {
			String name = nameList.get(i);
			System.out.println(name);
		}
		
		System.out.println();
		
		int index = 0;
		for(String name : nameList) {
			System.out.println(name);
			index++;
		}
		

		System.out.println("####################");
		System.out.println("       QUEUES");
		System.out.println("####################");
		System.out.println();

		/////////////////////
		// PROCESSING ITEMS IN A QUEUE
		/////////////////////
		
		Queue<String> priorities = new LinkedList<String>();
		
		priorities.offer("Clean the dishes");
		priorities.offer("Wash the counters");
		priorities.offer("Sweep the floor");
		
		while(priorities.size() > 0) {
			String myNextPriority = priorities.poll();
			System.out.println("Next priority: " + myNextPriority);
		}
		

		System.out.println("####################");
		System.out.println("       STACKS");
		System.out.println("####################");
		System.out.println();

		////////////////////
		// PUSHING ITEMS TO THE STACK
		////////////////////
		Stack<String> browserStack = new Stack<String>();
		
		browserStack.push("http://google.com/");
		browserStack.push("http://www.cnn.com/");
		browserStack.push("techelevator.com");

		
		////////////////////
		// POPPING THE STACK
		////////////////////
		
		while(browserStack.size() > 0) {
			String previousPage = browserStack.pop();
			System.out.println("PREVIOUS PAGE: " + previousPage);
		}
		
//		for(String previousPage : browserStack) {
//			System.out.println("PREVIOUS PAGE: " + previousPage);
//		}

	}
}
