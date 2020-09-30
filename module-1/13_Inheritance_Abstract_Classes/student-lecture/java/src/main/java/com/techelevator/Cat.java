package com.techelevator;

import java.math.BigDecimal;

public class Cat extends FarmAnimal {
	
	public Cat(String name, String sound) {
		super(name, sound, new BigDecimal(1000000000));
	}
	
	public String print() {
		return "I'm a cat!!";
	}
	
	@Override
	public String getTypeOfAnimal() {
		return "Cat";
	}
}
