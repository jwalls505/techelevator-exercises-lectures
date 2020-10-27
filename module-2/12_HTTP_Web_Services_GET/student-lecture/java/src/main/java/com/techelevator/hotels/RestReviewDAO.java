package com.techelevator.hotels;

import org.springframework.web.client.RestTemplate;

public class RestReviewDAO implements ReviewDAO {
	private RestTemplate restTemplate;
	public RestReviewDAO() {
		restTemplate = new RestTemplate();
	}
	@Override
	public Review[] getAllReviews() {
		return restTemplate.getForObject("http://localhost:3000/reviews", Review[].class);
		
	}
	@Override
	public Review[] getAllReviewsForHotel(int id) {
		return restTemplate.getForObject("http://localhost:3000/reviews?=" + id, Review[].class);
	}
	
	
}
