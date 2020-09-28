package com.techelevator._inheritance_lecture;

public class ReserveAuction extends Auction {
	private int reservePrice;

	public ReserveAuction(String itemForSale, int reservePrice) {
		super(itemForSale);
		this.reservePrice = reservePrice;
	}
	
	@Override
	public boolean placeBid(Bid offeredBid) {
		// 1. add the bid
		addBid(offeredBid);
		
		// 2. only set the high bid if it's bigger than the minimum 
		//    AND bigger than the current high bid
		// 3. return true if it's the current high bid
		if (offeredBid.getBidAmount() >= reservePrice) {
			
			if (getCurrentHighBid().getBidAmount() < offeredBid.getBidAmount()) {
				setCurrentHighBid(offeredBid);
				return true; // step 3
			}
		}
		
		
		return false; // step 3
	}
	
	@Override
	public String printAuctionDetails() {
		String parentAuctionString = super.printAuctionDetails();
		
		return parentAuctionString + " - Reserve Included";
	}

}
