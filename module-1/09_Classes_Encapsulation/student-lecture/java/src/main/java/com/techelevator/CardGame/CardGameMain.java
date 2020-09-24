package com.techelevator.CardGame;

import java.util.Map;
import java.util.HashMap;

public class CardGameMain {
	private static Map<String, Integer> rankValues = new HashMap<String, Integer>();
	
	public static void main(String[] args) {
			
//		Card aceOfSpades = new Card("Spades", "Ace");
//		Card twoOfHearts = new Card("Hearts", "Two");
//		
//		aceOfSpades.flip();
//		System.out.println("Ace of spades is face up: " + aceOfSpades.isFaceUp());
//		
//
//		System.out.println("Two of hearts is face up: " + twoOfHearts.isFaceUp());
//		
//		System.out.println("Two of hearts rank: " + twoOfHearts.getRank() + " suit: "
//				+ twoOfHearts.getSuit() + " color: " + twoOfHearts.getColor());
//		
		
		String[] mySuits = { "Spades", "Clubs", "Hearts", "Diamonds" };
		String[] myRanks = { "ACE", "TWO", "THREE", "FOUR", "FIVE", "SIX", "SEVEN", "EIGHT", "NINE", "TEN", "JACK", "QUEEN", "KING" };
		
		rankValues.put("ACE", 1);
		rankValues.put("TWO", 2);
		rankValues.put("THREE", 3);
		rankValues.put("FOUR", 4);
		rankValues.put("FIVE", 5);
		rankValues.put("SIX", 6);
		rankValues.put("SEVEN", 7);
		rankValues.put("EIGHT", 8);
		rankValues.put("NINE", 9);
		rankValues.put("TEN", 10);
		rankValues.put("JACK", 11);
		rankValues.put("QUEEN", 12);
		rankValues.put("KING", 13);
		
		
		// Create a traditional deck
		Deck myTraditionalDeck = new Deck(mySuits, myRanks);
		
		// shuffle the deck
		myTraditionalDeck.shuffle(); 

		// draw the first card
		Card firstCard = myTraditionalDeck.drawCard(); 
		
		// print the Card details
		System.out.println(firstCard.printCard() + " has a value of " + firstCard.getValue());
	}
	
	
	public static int getCardValue(Card card) {
		return rankValues.get(card.getRank());
	}
}
