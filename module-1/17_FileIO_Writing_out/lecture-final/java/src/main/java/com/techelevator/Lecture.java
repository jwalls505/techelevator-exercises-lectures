package com.techelevator;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Lecture {

	public static void main(String[] args) throws IOException {

		Scanner myScanner = new Scanner(System.in);
		
		/*
		System.out.print("Enter the path of a file or directory >>> ");
		
		String path = myScanner.nextLine();
		
		File myFile = new File(path);
				
		if(myFile.exists()) {
			System.out.println("The file " + myFile.getAbsolutePath() + " does exist.");
			System.out.println("File Name: " + myFile.getName());
			
			if(myFile.isDirectory()) {
				System.out.println("This is a directory.");

			} else {
				System.out.println("This is a file.");
			}
			
			System.out.println("The size is: " + myFile.length());
			
		} else {
			System.out.println("The file " + myFile.getAbsolutePath() + " does not exist.");
		}*/
		
		/********
		 * 
		 */
		
		/*System.out.print("Enter a directory to create >>> ");
		String directory = myScanner.nextLine();
		
		File newDirectory = new File(directory);
		
		if(newDirectory.exists()) {
			System.out.println("This directory exists.");
			System.exit(1);
		} else {
			
			boolean wasCreated = newDirectory.mkdirs();
			if(wasCreated) {
				System.out.println("The directory was created.");
			} else {
				System.out.println("The directory was not created.");
				System.exit(1);
			}
		}*/
		
		/*******
		 * 
		 */
		
		
		System.out.print("Enter a name for a new file >>> ");
		String fileName = myScanner.nextLine();
		
		File newFile = new File(fileName);
		
		try {
			newFile.createNewFile();
		} catch (IOException e) {
			System.out.println("Something went wrong.");
		}
		
		System.out.println("name: " + newFile.getName());
		System.out.println("size: " + newFile.length());
		System.out.println("path: " + newFile.getAbsolutePath());
		
		/*****
		 * 
		 */
		
		
		System.out.print("Enter a message to store in our file >>> ");
		String message = myScanner.nextLine();
		
		
		 
		// open for appending
		try(FileWriter myFileWriter = new FileWriter(newFile.getAbsolutePath(), false);
			PrintWriter myPrintWriter = new PrintWriter(myFileWriter)) {
			
			myPrintWriter.println(message);
			myPrintWriter.flush();
			myPrintWriter.println(message);
			myPrintWriter.println(message);
			
		}
		
		System.out.println("size: " + newFile.length());
		

	}

}
