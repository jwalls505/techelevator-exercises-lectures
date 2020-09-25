package com.techelevator;

public class Elevator {
	private int currentFloor = 1;
	private int numberOfFloors;
	private boolean doorOpen;
	
	
	
	public Elevator(int numberOfLevels) {
		numberOfFloors = numberOfLevels;
	}
	
	public int getCurrentFloor() {
		return currentFloor;
	}
	
	public int getNumberOfFloors() {
		return numberOfFloors;
	}
	public boolean getDoorOpen() {
		return doorOpen;
	}
	public boolean isDoorOpen() {
		 return this.doorOpen;
	}
	
	public void openDoor() {
		if(!doorOpen) {
			this.doorOpen = true;
		}
	}
	public void closeDoor() {
		this.doorOpen = !doorOpen;
	}
	public void goUp(int desiredFloor) {
		if(desiredFloor <= numberOfFloors && !doorOpen) {
			if(desiredFloor > currentFloor) {
				currentFloor = desiredFloor;
			}
		}
	
	}
	public void goDown(int desiredFloor) {
		if(!doorOpen && desiredFloor >= 1) {
			if(desiredFloor < currentFloor) {
				currentFloor = desiredFloor;
			}
		
		}
	}
	
	
	
	
}
