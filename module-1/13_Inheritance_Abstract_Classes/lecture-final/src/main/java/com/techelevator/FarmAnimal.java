package com.techelevator;

import java.math.BigDecimal;

public abstract class FarmAnimal implements Singable, Sellable {
	private String name;
	private String sound;
	private String eatsWhat;
	private String locationOnFarm;
	private BigDecimal price;
	private boolean isAsleep = false;
	
	
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
	
	public final String getSound() {
		if(isAsleep) {
			return "Zzzzz";
		}
		
		return sound;
	}
	
	public void setSound(String sound) {
		this.sound = sound;
	}
	
	protected String getTypeOfAnimal() {
		return "Farm Animal";
	}
	
	public BigDecimal getPrice() {
		return price;
	}
	
	public void sleep() {
		isAsleep = true;
	}
	
	public void wakeUp() {
		isAsleep = false;
	}
	
	public abstract String eat();
}
