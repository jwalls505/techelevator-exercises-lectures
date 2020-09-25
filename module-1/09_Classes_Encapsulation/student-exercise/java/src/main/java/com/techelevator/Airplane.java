package com.techelevator;

public class Airplane {
	private String planeNumber;
	private int totalFirstClassSeats;
	private int bookedFirstClassSeats;
	private int availableFirstClassSeats;
	private int totalCoachSeats;
	private int bookedCoachSeats;
	private int availableCoachSeats;

	public Airplane(String planeNumber, int totalFirstClassSeats, int totalCoachSeats) {
		this.planeNumber = planeNumber;
		this.totalFirstClassSeats = totalFirstClassSeats;
		this.totalCoachSeats = totalCoachSeats;
	}

	public String getPlaneNumber() {
		return planeNumber;
	}

	public int getTotalFirstClassSeats() {
		return totalFirstClassSeats;
	}

	public int getBookedFirstClassSeats() {
		return bookedFirstClassSeats;
	}

	public int getAvailableFirstClassSeats() {
		return availableFirstClassSeats = totalFirstClassSeats - bookedFirstClassSeats;
	}

	public int getTotalCoachSeats() {
		return totalCoachSeats;
	}

	public int getBookedCoachSeats() {
		return bookedCoachSeats;
	}

	public int getAvailableCoachSeats() {
		return availableCoachSeats = totalCoachSeats - bookedCoachSeats;
	}

	public boolean reserveSeats(boolean forFirstClass, int totalNumberOfSeats) {
		if(forFirstClass == true) {
			if(totalNumberOfSeats <= (totalFirstClassSeats - bookedCoachSeats)) {
				bookedFirstClassSeats = bookedFirstClassSeats + totalNumberOfSeats;
				return true;
			}
		} else {
			if(totalNumberOfSeats <= (totalCoachSeats - bookedCoachSeats)) {
				bookedCoachSeats = bookedCoachSeats + totalNumberOfSeats;
				return true;
			}
		}
		

		return false;
	}
}
