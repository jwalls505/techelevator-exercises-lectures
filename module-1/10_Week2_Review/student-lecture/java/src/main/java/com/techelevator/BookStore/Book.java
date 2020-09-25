package com.techelevator.BookStore;

/*
 * pages
 * subject matter
 * cover
 * title
 * author
 * chapters
 * index
 * price
 * 
 */
public class Book {
	private int pageCount;
	private String title;
	private String author;
	private int currentPage = 0;
	
	public Book(int pageCount) {
		this.pageCount = pageCount;
	}
	
	public Book(int pageCount, String title) {
		this.pageCount = pageCount;
		this.title = title;
	}
	
	
	public int getPageCount() {
		return pageCount;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String newTitle) {
		title = newTitle;
	}
	
	public void turnThePage() {
		currentPage += 2;
	}
	
	public String printBookInfo() {
		return title + " by " + author;
	}
}
