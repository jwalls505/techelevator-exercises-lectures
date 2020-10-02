package com.techelevator.tictactoe;

public class Board {
	private char[] topRow = new char[3];
	private char[] middleRow = new char[3];
	private char[] bottomRow = new char[3];
	
	public void addValue(char gamePiece, int boardPos) {
		if(boardPos < 1 || boardPos > 9) {
			return;
		}
		
		if(boardPos <= 3) {
			topRow[boardPos - 1] = gamePiece;
		} else if(boardPos <= 6) {
			middleRow[boardPos - 4] = gamePiece;
		} else {
			bottomRow[boardPos - 7] = gamePiece;
		}
	}
	
	/* Assume the board reads like this
	 * topRow    0 1 2 -> 1 2 3
	 * middleRow 0 1 2 -> 4 5 6
	 * bottomRow 0 1 2 -> 7 8 9
	 */
	public char getValue(int boardPos) {
		if(boardPos < 1 || boardPos > 9) {
			return ' ';
		}
		
		if(boardPos <= 3) {
			return topRow[boardPos - 1];
		} else if(boardPos <= 6) {
			return middleRow[boardPos - 4];
		} else {
			return bottomRow[boardPos - 7];
		}
	}
	
	private String getRowString(char[] row) {
		String myReturnString = "";
		
		for(int i = 0; i < row.length; i++) {
			
			if(row[i] == '\u0000') { // if the space is empty
				myReturnString += " ";
			} else {
				myReturnString += row[i];
			}
			
			if(i < row.length - 1) {
				myReturnString += '|'; 
			}
		}
		
		return myReturnString;
	}
	
	@Override
	public String toString() {
		String myReturnString = "";
		
		myReturnString += getRowString(topRow);
		
		myReturnString += "\n";
		myReturnString += "- - -\n";
		
		myReturnString += getRowString(middleRow);
		
		myReturnString += "\n";
		myReturnString += "- - -\n";
		
		myReturnString += getRowString(bottomRow);
		
		return myReturnString;
	}
}
