package com.techelevator.tictactoe;

/*
 * name
 * game piece X or O
 * 
 */

public class Player {
	private String name;
	private char gamePiece;
	
	public Player(String name, char gamePiece) {
		this.name = name;
		this.gamePiece = gamePiece;
	}

	public String getName() {
		return name;
	}

	public char getGamePiece() {
		return gamePiece;
	}
}
