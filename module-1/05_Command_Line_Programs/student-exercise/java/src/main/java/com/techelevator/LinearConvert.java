package com.techelevator;

import java.util.Scanner;


public class LinearConvert {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Linear conversion tool.");
		System.out.println();
		
		System.out.println("Please enter a measurement: ");
		String userInput = input.nextLine();
		double measureInput = Double.parseDouble(userInput);
		
		System.out.println();
		System.out.println("Is that in (m)eter, or (f)eet? ");
		String measureType = input.nextLine();
		double conversion = 0;
				if(measureType.contentEquals("f")) {
					conversion = (measureInput * 0.3048);
					System.out.println((int)measureInput + "f is " + (int)conversion + "m");
				} else {
					measureType.contentEquals("m");
					conversion = (measureInput * 3.2808399);
					System.out.println((int)measureInput + "m is " + (int)conversion + "f");
				}
		
		
		
		
 
	}

}
