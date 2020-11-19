package com.techelevator.review.models;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

public class Review {

    private int id;

    @NotBlank( message = "The field 'reviewer' is required.")
    private String reviewer;
    
    @NotBlank( message = "The field 'title' is required.")
    private String title;
    
    @NotBlank( message = "The field 'review' is required.")
    private String review;
    
    @Min( value = 1, message = "The minimum number of stars is 1")
    @Max( value = 5, message = "The maximum number of stars is 5")
    private int stars;

    public Review() {}
    
    public Review(int id, String reviewer, String title, String review, int stars) {
    	this.id = id;
    	this.reviewer = reviewer;
    	this.title = title;
    	this.review = review;
    	this.stars = stars;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getReviewer() {
    	return reviewer;
    }

    public void setReviewer(String reviewer) {
    	this.reviewer = reviewer;
    }

    public String getTitle() {
    	return title;
    }

    public void setTitle(String title) {
    	this.title = title;
    }
    
    public String getReview() {
    	return review;
    }

    public void setReview(String review) {
    	this.review = review;
    }
    
    public int getStars() {
    	return stars;
    }

    public void setStars(int stars) {
    	this.stars = stars;
    }
}
