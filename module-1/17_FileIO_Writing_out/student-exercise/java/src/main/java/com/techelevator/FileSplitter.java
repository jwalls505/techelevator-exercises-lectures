package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class FileSplitter {
	static Scanner userInput = new Scanner(System.in);

	public static void main(String[] args) throws FileNotFoundException {

		File fileInput = getInputFromUser();
		try (Scanner fileScanner = new Scanner(fileInput); Scanner in = new Scanner(System.in)) {
			System.out.print("How many lines of text(max) should there be in the split files? >>> ");
			int lineMax = in.nextInt();
			long lineCounter = 0;
			while (fileScanner.hasNextLine()) {
				String line = fileScanner.nextLine();
				lineCounter++;
			}
			System.out.println("The file has " + lineCounter + " lines.");
			double temp = lineCounter/lineMax;
			int fileCount;
			
		}

	}

	private static File getInputFromUser() {
		System.out.print("What is the input file(please include the path-to-file? > ");
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
