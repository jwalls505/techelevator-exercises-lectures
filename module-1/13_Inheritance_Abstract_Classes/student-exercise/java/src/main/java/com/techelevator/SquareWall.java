package com.techelevator;

public class SquareWall extends RectangleWall {
	private int sideLength;

	public SquareWall(String name, String color, int length, int height) {
		super(name, color, length, height);
		
	}
	public SquareWall(String name, String color, int sideLength) {
		super(name, color);
		this.sideLength = sideLength;
	}
	public int getSideLength() {
		return sideLength;
	}
	public String toString() {
		return getName() + " " + "(" + sideLength + "x" + sideLength + ")" + " square";
	}
	@Override
	public int getArea() {
		return sideLength * sideLength;
	}

}
