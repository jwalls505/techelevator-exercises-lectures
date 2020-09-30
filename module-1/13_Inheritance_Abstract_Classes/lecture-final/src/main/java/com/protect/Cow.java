package com.protect;

import com.techelevator.FarmAnimal;

public class Cow extends FarmAnimal {

	public Cow(String name, String sound) {
		super(name, sound);
		
	}

	@Override 
	public String eat() {
		// TODO Auto-generated method stub
		return null;
	}
	
	// I can do this even though getTypeOfAnimal is protected and in a different package
	// because I'm a child of FarmAnimal.
	@Override 
	protected String getTypeOfAnimal() {
		return "Cow";
	}
}
