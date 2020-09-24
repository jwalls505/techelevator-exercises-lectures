package com.techelevator.CardGame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * What it is?
 * Collection of Cards
 * 
 * What can it do?
 * Draw
 * Shuffle
 */

public class Deck {
	
	// private instance variable
	private List<Card> listOfCards = new ArrayList<Card>();
	
	public Deck(String[] suits, String[] ranks) {
		for(String suit : suits) {
			for(String rank : ranks) {
				Card myCard = new Card(suit, rank);
				listOfCards.add(myCard);
			}
		}
	}
	
	public Card drawCard() {
		// If there is nothing in my deck, return null
		if(listOfCards.size() == 0) {
			return null;
		}
		
		Card topCard = listOfCards.remove(0);
		topCard.flip();
		return topCard;
	}
	
	public void shuffle() {
		Collections.shuffle(listOfCards);
	}
	
	

}
