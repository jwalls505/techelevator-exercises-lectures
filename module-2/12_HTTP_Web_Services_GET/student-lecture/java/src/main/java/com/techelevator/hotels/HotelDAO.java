package com.techelevator.hotels;

public interface HotelDAO {
	Hotel[] getAlHotels();
	Hotel getHotelById(int id);
	Hotel[] getHotesByStarRating(int starCount);
}
