package com.techelevator._inheritance_lecture;

import java.util.ArrayList;
import java.util.List;

public class Auction {
	private String itemForSale;
	private Bid currentHighBid;
	private List<Bid> allBids;
	public boolean isAuctionComplete;

	public Auction(String itemForSale) {
		this.itemForSale = itemForSale;
		this.currentHighBid = new Bid("", 0);
		allBids = new ArrayList<>();
	}

	public boolean placeBid(Bid offeredBid) {
		//1. add the bid to the list of all bids.
		allBids.add(offeredBid);
		//2. check if the bid is the new high bid, if so assign it.
		if(currentHighBid.getBidAmount() < offeredBid.getBidAmount()) {
			currentHighBid = offeredBid;
			return true;
		}
		//3. return true if the new bid is the high bid, otherwise false.
		
		
		
		return false;
	}

	public Bid getCurrentHighBid() {
		return currentHighBid;
	}

	public List<Bid> getAllBids() {
		return new ArrayList<>(allBids);
	}

	public String getItemForSale() {
		return itemForSale;
	}
	public void addBid(Bid myBid) {
		allBids.add(myBid);
	}
	public void setCurrentHighBid(Bid currentHighBid) {
		this.currentHighBid = currentHighBid;
	}
	public void endAuction() {
		this.isAuctionComplete = true;
	}
	public boolean isAuctionComplete() {
		return this.isAuctionComplete = true;
	}
	
}
