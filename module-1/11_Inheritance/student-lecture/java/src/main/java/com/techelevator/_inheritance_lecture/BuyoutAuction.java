package com.techelevator._inheritance_lecture;

public class BuyoutAuction extends Auction {
	private int buyoutPrice;
	private boolean isAuctionComplete;
	public BuyoutAuction(String itemForSale, int buyoutPrice) {
		super(itemForSale);
		this.buyoutPrice = buyoutPrice;
	}
	
	
	@Override
	public boolean placeBid(Bid offeredBid) {
		//1. add to list of bids
		addBid(offeredBid);
		
		//2. if it's the highest bid, mark it as the current high bid
		// if its also equal to buyout price, then auction ends.
		if(getCurrentHighBid().getBidAmount() < offeredBid.getBidAmount()) {
			
			setCurrentHighBid(offeredBid);
			if(offeredBid.getBidAmount() >= buyoutPrice) {
				endAuction();
			}
			
			return true;
		}
		
		// 3. return true if its highest bid, otherwise return false;
		
		
		return false;
	}
	@Override
	public boolean isAuctionComplete() {
		boolean isBuyoutPriceMet = getCurrentHighBid().getBidAmount() >= buyoutPrice;
		return isBuyoutPriceMet || super.isAuctionComplete();
	}
	

	

}
