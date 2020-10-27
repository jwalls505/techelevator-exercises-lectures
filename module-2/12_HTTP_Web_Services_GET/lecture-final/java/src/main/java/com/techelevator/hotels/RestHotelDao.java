package com.techelevator.hotels;

import org.springframework.web.client.RestTemplate;

public class RestHotelDao implements HotelDao {

	private RestTemplate restTemplate;
	
	public RestHotelDao() {
		 restTemplate = new RestTemplate();
	}
	
	@Override
	public Hotel[] getAllHotels() {
		Hotel[] allHotels = restTemplate.getForObject("http://localhost:3000/hotels", Hotel[].class);

		return allHotels;
	}
	
	@Override
	public Hotel[] getHotelsByStarRating(int starCount) {
		Hotel[] allHotels = restTemplate.getForObject("http://localhost:3000/hotels?stars=" + starCount, Hotel[].class);

		return allHotels;
	}
	
	@Override
	public Hotel getHotelById(int id) {
		Hotel[] theHotel = restTemplate.getForObject("http://localhost:3000/hotels?id=" + id, Hotel[].class);
		
		if(theHotel != null && theHotel.length > 0) {
			return theHotel[0];
		} else {
			return null;
		}
	}

}
