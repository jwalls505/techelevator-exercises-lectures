package com.techelevator;

import java.util.Scanner;

public class TempConvert {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println(" Spacer's Choice Temperature Conversion Calculater!");
		
		System.out.print("Please enter a temperature: ");						
		String userInput = input.nextLine();
		double tempInput = Double.parseDouble(userInput);
		
		System.out.println();
		System.out.print("Is the temperature in (C)elsius, or (F)ahrenheit?: ");
		String tempType = input.nextLine();
		double conversion = 0;
		if(tempType.contentEquals("F")) {
			conversion = (tempInput - 32) / 1.8;
			System.out.println((int)tempInput + tempType + " is " + (int)conversion + "C.");
		} else {
			tempType.contentEquals("C");
			conversion = (tempInput * 1.8) + 32;
			System.out.println((int)tempInput + tempType + " is " + (int)conversion + "F.");
		}
		 
		
		System.out.println();
		System.out.println("Thank you for choosing Spacer's Choice!");
		System.out.println("You've tried the best, now try the rest. Spacer's choice!");
		
		
		
		
		
	}

}
