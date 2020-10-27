package com.techelevator.auction;

import org.springframework.web.client.RestTemplate;

//attempt at DAO encapsulation-could not get tests to work with my DAO objects however

public class RestAuctionDao implements AuctionDao {
	RestTemplate restTemplate = new RestTemplate();
	
	public RestAuctionDao() {
		this.restTemplate = new RestTemplate();
	}
	
	@Override
	public Auction[] listAllAuctions() {
		Auction[] allAuctions = restTemplate.getForObject("http://localhost:3000/auctions", Auction[].class);
		return allAuctions;
	}
	
}
