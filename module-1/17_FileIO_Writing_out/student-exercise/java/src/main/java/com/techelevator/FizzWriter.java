package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;

public class FizzWriter {

	public static void main(String[] args) throws IOException {
		String filePath = "FizzBuzz.txt";
		File fizzFile = new File(filePath);
		try {
			fizzFile.createNewFile();
		} catch(FileNotFoundException e) {
			System.out.println("Something's not working.");
		}
		try (FileWriter fizzWriter = new FileWriter(fizzFile.getAbsoluteFile(), false);
			PrintWriter file = new PrintWriter(fizzFile)) {
			int counter = 0;
			for (int i = 1; i <= 300; i++) {
				if (i % 5 == 0 && i % 3 == 0) {
					file.println("FizzBuzz");
				} else if (i % 5 == 0) {
					file.println("Buzz");
				} else if (i % 3 == 0) {
					file.println("Fizz");
				} else {
					counter++;
					file.println(counter);
				}
			}
		}
		
		System.out.println("The program has created FizzBuzz.txt. Thank you, come again.");
	}
}
