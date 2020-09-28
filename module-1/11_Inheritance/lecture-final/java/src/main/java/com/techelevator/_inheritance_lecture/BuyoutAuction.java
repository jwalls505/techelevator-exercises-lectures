package com.techelevator._inheritance_lecture;

public class BuyoutAuction extends Auction {
	private final int buyoutPrice;	
	
	
	public BuyoutAuction(String itemForSale, int buyoutPrice) {
		super(itemForSale);
		
		this.buyoutPrice = buyoutPrice;
	}
	
	@Override
	public boolean placeBid(Bid offeredBid) {
		// 1. add to the list of bids
		super.addBid(offeredBid);
		
		
		// 2. if it's the highest bid, mark it as the current high bid
		//    if it's also met the buyout price, then the auction is over
		if (getCurrentHighBid().getBidAmount() < offeredBid.getBidAmount()) {
			
			setCurrentHighBid(offeredBid);
			
			if (offeredBid.getBidAmount() >= buyoutPrice) {
				// end the auction
				endAuction();
			}
			
			return true; // step 3
		}
		
		
		// 3. return true if it's the highest bid, otherwise false
		
		
		return false; // step 3
	}
	
	@Override
	public boolean isAuctionComplete() {
		boolean isBuyoutPriceMet = getCurrentHighBid().getBidAmount() >= buyoutPrice;
		
		return isBuyoutPriceMet || super.isAuctionComplete();
	}
}
