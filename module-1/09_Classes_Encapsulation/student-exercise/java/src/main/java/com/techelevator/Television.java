package com.techelevator;

public class Television {
	private boolean isOn;
	private int currentChannel = 3;
	private int currentVolume = 2;
	
	public boolean isOn() {
		return this.isOn;
	}
	public int getCurrentChannel() {
		return this.currentChannel;
	}
	public int getCurrentVolume() {
		return this.currentVolume;
	}
	
	public void turnOff() {
		this.isOn = false;
	}
	
	public void turnOn() {
		this.isOn = true;
	}
	
	public void changeChannel(int newChannel) {
		if(isOn == true && newChannel >= 3 && newChannel <= 18) {
			currentChannel = newChannel;
		}
	}
	public void channelUp() {
		if(isOn == true) {
			if(currentChannel !=18) {
				currentChannel++;
			} else
				currentChannel = 3;
		}
	}
	public void channelDown() {
		if(isOn == true) {
			if(currentChannel != 3) {
				currentChannel--;
			} else
				currentChannel = 18;
		}
	}
	public void raiseVolume() {
		if(isOn == true && currentVolume != 10) {
			currentVolume++;
			
		}
	}
	public void lowerVolume() {
		if(isOn == true && currentVolume != 0) {
			currentVolume--;
		}
	}
}
