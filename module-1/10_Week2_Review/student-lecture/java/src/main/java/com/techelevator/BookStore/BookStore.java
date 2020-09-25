package com.techelevator.BookStore;

public class BookStore {
	
	public static void main(String[] arg) {
		
		Book myFirstBook = new Book(100, "my title");
		
		Book mySecondBook = new Book(200);
		
		
		mySecondBook.setTitle("My Second Book");
		
		myFirstBook.setTitle("My First Book");
	}
	
}
