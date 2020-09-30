package com.techelevator;

public class Goat extends FarmAnimal {

	public Goat(String name) {
		super(name, "Blehhhh Taylor!");
	}
	
	public String print() {
		return "I'm a goat!!";
	}
	
	@Override
	public String getTypeOfAnimal() {
		return "Goat";
	}

	@Override
	public String eat() {
		return "Everything, including the shirt off your back!";
	}
}
