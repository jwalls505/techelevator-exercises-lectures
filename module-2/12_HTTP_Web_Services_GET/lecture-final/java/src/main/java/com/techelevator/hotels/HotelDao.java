package com.techelevator.hotels;

public interface HotelDao {

	Hotel[] getAllHotels();
	
	Hotel[] getHotelsByStarRating(int starCount);
	
	Hotel getHotelById(int id);
}
