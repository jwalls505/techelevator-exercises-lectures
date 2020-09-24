package com.techelevator.CardGame;


/*
 * What are we?
 * Value
 * Suit
 * Color
 * 
 * What can we do?
 * Flip 
 */
public class Card {
	private String suit;
	private String rank;
	private boolean isFaceUp = false;
		
	public Card(String suit, String rank) {
		this.suit = suit;
		this.rank = rank;
	}
	
	public String getSuit() {
		return suit;
	}
	
	public String getRank() {
		return rank;
	}
	
	public String getColor() {
		if(suit.equals("Hearts") || suit.equals("Diamonds")) {
			return "Red";
		}
		
		return "Black";
	}
	
	public boolean isFaceUp() {
		return isFaceUp;
	}
	
	public void flip() {
		isFaceUp = !isFaceUp;
	}
	
	
	public int getValue() {
		return CardGameMain.getCardValue(this);
	}
	
	public String printCard() {
		return rank + " of " + suit; // e.g. ACE of Spades
	}
	
	
}

