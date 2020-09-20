package com.techelevator;

import java.util.Scanner;

public class Fibonacci {

	public static void main(String[] args) {
		Scanner myScanner = new Scanner(System.in);
		System.out.println("Fibonacci Sequence!");
		System.out.println();

		int fibNumber = 0; // initialize count number
		int num1 = 0; // fib always starts with a 0 and 1;
		int num2 = 1;
		System.out.println("Please enter a Fibonacci number: ");
		fibNumber = myScanner.nextInt(); // since we know it will just be integers
		System.out.println("Your sequence is: " + fibNumber);

		while (num1 <= fibNumber) {
			System.out.print(num1 + " "); // starting point
			int sumOfTwo = num1 + num2; // adding previous two numbers
			num1 = num2; // assign new number
			num2 = sumOfTwo;// assign addition to this variable to add back through loop

		}
	}

}
