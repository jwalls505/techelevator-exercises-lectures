package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class WordSearch {

	public static void main(String[] args) throws FileNotFoundException {
		
		// Scanner userInput = new Scanner(System.in);

		File inputFile = getInputFileFromUser();

		try (Scanner fileScanner = new Scanner(inputFile); Scanner inputWord = new Scanner(System.in)) {
			System.out.println("Please enter word you are searching for >>> ");
			String word = inputWord.nextLine();
			System.out.println();
			System.out.println("Should the search be case sensitive? (Y/N)");
			String reply = inputWord.nextLine();
			int lineNumber = 0;
			while (fileScanner.hasNextLine()) {
				lineNumber++;
				String line = fileScanner.nextLine();
				if (reply.contentEquals("Y") && line.contains(word)) {
					System.out.println(lineNumber + ") " + line);
				} else if (reply.contentEquals("N") && line.toLowerCase().contains(word.toLowerCase())) {
					System.out.println(lineNumber + ") " + line);
				}

			}
		}

	}

	@SuppressWarnings("resource")
	private static File getInputFileFromUser() {
		Scanner userInput = new Scanner(System.in);
		System.out.print("Please enter path to input file >>> ");
		String path = userInput.nextLine();
		System.out.println();

		File inputFile = new File(path);
		if (inputFile.exists() == false) { // checks for the existence of a file
			System.out.println(path + " does not exist");
			System.exit(1); // Ends the program
		} else if (inputFile.isFile() == false) {
			System.out.println(path + " is not a file");
			System.exit(1); // Ends the program
		}
		return inputFile;

	}

}