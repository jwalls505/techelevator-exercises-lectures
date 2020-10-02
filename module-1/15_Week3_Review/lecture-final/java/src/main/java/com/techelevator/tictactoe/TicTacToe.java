package com.techelevator.tictactoe;

import com.techelevator.game.Game;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TicTacToe extends Game {
	private Board myBoard;
	private char x = 'X';
	private char o = 'O';
	private Map<Integer, Player> playerMap;
	private Scanner myScanner = new Scanner(System.in);
	
	public TicTacToe() {
		super(2);
	}

	@Override
	protected void setup(int numberOfPlayers) {
		// 1. Create the empty playing board AND print it
		myBoard = new Board();
		System.out.println(myBoard);
		
		// 2. Need two different markers Xs and Os
		// done above
		
		// 3. Figure out who goes first
		Player playerOne = new Player("Player One", x);
		Player playerTwo = new Player("Player Two", o);
		
		playerMap = new HashMap<>();
		playerMap.put(1, playerOne);
		playerMap.put(2, playerTwo);
		
	}

	@Override
	protected void takeTurn(int player) {
		// 1. Figure out who's turn it is
		Player currentPlayer = playerMap.get(player);
		
		// 1a. Print out available moves (maybe)
		
		// 2. Ask the user for their move
		
		boolean isMoveValid = true;
		int playersMove = 0;
		do {
			System.out.print("Enter your move (1-9): ");
			
			String userInput = myScanner.nextLine();
			playersMove = Integer.parseInt(userInput);
			
			// 3. Figure out if a move is valid
			if(playersMove < 1 
					|| playersMove > 9 
					|| myBoard.getValue(playersMove) == x 
					|| myBoard.getValue(playersMove) == o) {
				System.out.println("Invalid move. Please try again.");
				isMoveValid = false;
			} else {
				isMoveValid = true;
			}
			
		} while(!isMoveValid);
		
		
		// 4. Draw the X or the O
		char currentGamePiece = currentPlayer.getGamePiece();
		myBoard.addValue(currentGamePiece, playersMove);
		
		System.out.println(myBoard); // print the board
		
	}

	@Override
	protected boolean isGameOver() {
		return false;
	}

	@Override
	protected void finishGame() {
		myScanner.close();
	}


}
