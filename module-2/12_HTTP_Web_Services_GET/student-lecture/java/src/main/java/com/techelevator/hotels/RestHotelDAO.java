package com.techelevator.hotels;

import org.springframework.web.client.RestTemplate;

public class RestHotelDAO implements HotelDAO {

	private RestTemplate restTemplate;
	public RestHotelDAO() {
		restTemplate = new RestTemplate();
	}

	@Override
	public Hotel[] getAlHotels() {
		Hotel[] allHotels = restTemplate.getForObject("http:??localhost:3000/hotels", Hotel[].class);
		return allHotels;
	}

	@Override
	public Hotel getHotelById(int id) {
		Hotel[] theHotel = restTemplate.getForObject("http:??localhost:3000/hotels?id=" + id, Hotel[].class);
		if(theHotel != null && theHotel.length > 0) {
			return theHotel[0];
		} 
		return null;
		
	}



	@Override
	public Hotel[] getHotesByStarRating(int starCount) {
		// TODO Auto-generated method stub
		return null;
	}

}
