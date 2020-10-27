package com.techelevator.hotels;

import org.springframework.web.client.RestTemplate;

public class RestReviewDao implements ReviewDao {

	private RestTemplate restTemplate;
	
	public RestReviewDao() {
		restTemplate = new RestTemplate();
	}
	
	@Override
	public Review[] getAllReviews() {
		return restTemplate.getForObject("http://localhost:3000/reviews", Review[].class);
	}
	
	@Override
	public Review[] getAllReviewsForHotel(int hotelId) {
		return restTemplate.getForObject("http://localhost:3000/reviews?hotelID=" + hotelId, Review[].class);
	}
}
