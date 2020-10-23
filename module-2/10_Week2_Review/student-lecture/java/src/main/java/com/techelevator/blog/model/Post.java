package com.techelevator.blog.model;

import java.time.LocalDate;

public class Post {

	private Long id;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public LocalDate getDatePosted() {
		return datePosted;
	}
	public void setDatePosted(LocalDate datePosted) {
		this.datePosted = datePosted;
	}
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	private Long userId;
	private String title;
	private String content;
	private LocalDate datePosted;
	private boolean isActive;
	
	
}
