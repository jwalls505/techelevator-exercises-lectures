package com.techelevator._inheritance_lecture;

import java.util.ArrayList;
import java.util.List;

public class Auction {
	private String itemForSale;
	private Bid currentHighBid;
	private List<Bid> allBids;
	private boolean isAuctionComplete;

	public Auction(String itemForSale) {
		this.itemForSale = itemForSale;
		this.currentHighBid = new Bid("", 0);
		allBids = new ArrayList<>();
	}
	
	public String printAuctionDetails() {
		return "Basic Auction";
	}

	public boolean placeBid(Bid offeredBid) {
		// 1. add the bid to the list of all bids
		allBids.add(offeredBid);
		
		// 2. check if the bid is the new high bid, and if so, assign it
		// 3. return true if the bid is the new high bid, otherwise false
		
		if (currentHighBid.getBidAmount() < offeredBid.getBidAmount()) {
			currentHighBid = offeredBid;
			return true; // step 3
		}
		
		return false; // step 3
	}

	public Bid getCurrentHighBid() {
		return currentHighBid;
	}
	
	public void setCurrentHighBid(Bid currentHighBid) {
		this.currentHighBid = currentHighBid;
	}

	public List<Bid> getAllBids() {
		return new ArrayList<>(allBids);
	}

	public String getItemForSale() {
		return itemForSale;
	}
	
	public boolean isAuctionComplete() {
		// if current time is > time to end auction
		// then return true;
		
		return this.isAuctionComplete;
	}
	
	public void endAuction() {
		this.isAuctionComplete = true;
	}
	
	public void addBid(Bid myBid) {
		allBids.add(myBid);
	}
}
