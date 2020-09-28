package com.techelevator._inheritance_lecture;
//can only extend from one superclass
public class ReserveAuction extends Auction {
	private int reservePrice;
	public ReserveAuction(String itemForSale, int reservePrice) {
		super(itemForSale);// call the super first, rule of java-create the subclass-then fill in remainder of subclass
		this.reservePrice = reservePrice;
	}
	@Override   //how to anotate an over-written method from parent class;
	public boolean placeBid(Bid offeredBid) {
		//1. add the bid.
		addBid(offeredBid);
		//2. only set the high bid if its bigger then the min, and bigger then currentHighBid;
		if(offeredBid.getBidAmount() >= reservePrice) {
			if(getCurrentHighBid().getBidAmount() < offeredBid.getBidAmount()) {
				setCurrentHighBid(offeredBid);
				return true;
				
			}
		}
		//3. return true if its the current high bid;
		return false;
	}
	

}
