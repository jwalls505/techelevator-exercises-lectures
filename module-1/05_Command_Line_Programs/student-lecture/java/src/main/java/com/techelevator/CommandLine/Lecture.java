package com.techelevator.CommandLine;

import java.util.Scanner;

public class Lecture {

	public static void main(String[] args) {
		
		Scanner myScanner = new Scanner(System.in);
		
		System.out.println("Welcome to our calculator!!");
		
		System.out.print("Please enter a discount price (without the percentage symbol): ");
		
		String userInput = myScanner.nextLine();
		
		
		double discount = Double.parseDouble(userInput);
		
		
		System.out.println();
		System.out.print("Please provide a series of prices (space separated): ");
		
		userInput = myScanner.nextLine();
		String[] splitValues = userInput.split(" ");
		
		for(int i = 0; i < splitValues.length; i++) {
			String currentPrice = splitValues[i];
			double price = Double.parseDouble(currentPrice);
			
			double totalDiscount = price * discount;
			
			System.out.println("Original price: " + currentPrice);
			
			System.out.println("Total Disount: " + totalDiscount);
		}
		
		
		System.out.println();
		System.out.println("Thanks for stopping by.");
		
		myScanner.close();
	}

}
