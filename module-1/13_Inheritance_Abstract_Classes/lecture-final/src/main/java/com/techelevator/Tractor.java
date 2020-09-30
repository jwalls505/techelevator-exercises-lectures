package com.techelevator;

import java.math.BigDecimal;

public class Tractor implements Singable, Sellable {
	private String name;
	private String sound;
	
	public Tractor(String name, String sound) {
		this.name = name;
		this.sound = sound;
	}
	
	@Override
	public String getName() {
		return name;
	}

	@Override
	public String getSound() {
		return sound;
	}

	@Override
	public void setSound(String sound) {
		this.sound = sound;
	}
	
	@Override
	public BigDecimal getPrice() {
		return new BigDecimal(1500);
	}

}
