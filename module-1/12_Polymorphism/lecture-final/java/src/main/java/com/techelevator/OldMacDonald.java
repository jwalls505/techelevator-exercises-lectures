package com.techelevator;

import java.util.ArrayList;
import java.util.List;

public class OldMacDonald {

	public static void main(String[] args) {

		Tractor myTractor = new Tractor("Johnny D.", "vroom");
		
		Goat myGoat = new Goat("Billy");
		Goat myGoat2 = new Goat("Billy Jr");
		
		Cat myCat = new Cat("Jorge", "Meow");
		
		System.out.println("My goat " + myGoat.getName() + " says " + myGoat.getSound());
		
		System.out.println("My cat " + myCat.getName() + " says " + myCat.getSound());
		
		List<Singable> listOfSingableThings = new ArrayList<>();
		listOfSingableThings.add(myGoat);
		listOfSingableThings.add(myGoat2);
		listOfSingableThings.add(myCat);
		listOfSingableThings.add(myTractor);
		
		List<Goat> myListOfGoats = new ArrayList<>();
		
		
		for(Singable mySingableThing : listOfSingableThings) {
//			String type = myFarmAnimal.getTypeOfAnimal();
			String name = mySingableThing.getName();
			String sound = mySingableThing.getSound();
			
			System.out.println("My " + name + " says " + sound);
		}
		
		List<Sellable> listOfSellableThings = new ArrayList<>();
		listOfSellableThings.add(myTractor);
		listOfSellableThings.add(myGoat);
		listOfSellableThings.add(myCat);
		
		for(Sellable mySellableThing : listOfSellableThings) {			
			System.out.println("My asking price is " + mySellableThing.getPrice());
		}
		
	}

}
