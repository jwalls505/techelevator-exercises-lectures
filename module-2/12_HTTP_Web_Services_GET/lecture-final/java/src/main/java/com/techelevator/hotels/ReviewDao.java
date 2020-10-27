package com.techelevator.hotels;

public interface ReviewDao {

	Review[] getAllReviews();
	
	Review[] getAllReviewsForHotel(int hotelId);
}
