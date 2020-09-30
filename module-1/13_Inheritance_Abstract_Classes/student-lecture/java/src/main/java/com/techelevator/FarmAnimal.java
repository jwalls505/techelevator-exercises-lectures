package com.techelevator;

import java.math.BigDecimal;

public class FarmAnimal implements Singable, Sellable {
	private String name;
	private String sound;
	private String eatsWhat;
	private String locationOnFarm;
	private BigDecimal price;
	
	public FarmAnimal(String name, String sound) {
		this.name = name;
		this.sound = sound;
		price = new BigDecimal(0);
	}
	
	public FarmAnimal(String name, String sound, BigDecimal price) {
		this.name = name;
		this.sound = sound;
		this.price = price;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getSound() {
		return sound;
	}
	
	public void setSound(String sound) {
		this.sound = sound;
	}
	
	public String getTypeOfAnimal() {
		return "Farm Animal";
	}
	
	public BigDecimal getPrice() {
		return price;
	}
}
