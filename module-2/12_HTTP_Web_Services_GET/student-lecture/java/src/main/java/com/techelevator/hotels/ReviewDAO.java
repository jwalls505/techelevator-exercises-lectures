package com.techelevator.hotels;

public interface ReviewDAO {
	Review[] getAllReviews();
	Review[] getAllReviewsForHotel(int id);
}
