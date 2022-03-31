package pa4;
/*
 * Manish Patel - CS 611 (Spring 2022)
 * LHM.java - Defines the class that defines and allows the users to play the game of Legends: Heroes and Monsters
 */

import java.util.*;

public class LHM extends RPGame {
	// String gameName inherited from Game superclass
	// GameBoard board inherited from RPGame superclass
	// Player[] players inherited from RPGame superclass
	
	// The ceiling for the size of the board the user can set
	private static final int MAX_BOARD_SIZE = 20;
	// The floor for the size of the board the user can set (in order to maintain 4-in-a-row at least once in every direction)
	private static final int MIN_BOARD_SIZE = 4;

	// The ceiling for the number of heroes per team the user can set
	private static final int MAX_HEROES_PER_TEAM = 3;
	// The floor for the number of heroes per team the user can set
	private static final int MIN_HEROES_PER_TEAM = 1;
	
	private static final String gamePieces = "OXABCDEFGHIJKLMNPQRSTUVWYZ";

	
	public LHM(int size, int numPlayers) {
		// Set the board to have the input size and create the appropriate array for the number players 
		this.setBoard(new GameBoard(size));
		this.setPlayers(new Player[numPlayers]);
		// Initialize each of the game's players with an ID and an appropriate game piece 
		for (int i=0; i < numPlayers; i++) {
			this.setPlayerIndex(i, new Player(String.valueOf(i+1), gamePieces.substring(i % gamePieces.length(), i % gamePieces.length() + 1)));
		}
	}
	
	public LHM() {
		// Welcome the player to the game and prompt them for the values we need 
		System.out.println("Welcome to the game of Legends: Heroes and Monsters!"); 
		System.out.println("Please enter what size board you'd like to play with (e.g. enter 8 for the default 8x8 board):");
		// Integer greater than 0 
		int size = Game.acceptValidPosInt();
		// We do not want to exceed the ceiling, so simply use the pre-set maximum
		if (size > MAX_BOARD_SIZE) {
			System.out.println("TOO HIGH! The maximum board size is " + MAX_BOARD_SIZE + "x" + MAX_BOARD_SIZE + ", so that will be the size used.");
			size = MAX_BOARD_SIZE;
		} else if (size < MIN_BOARD_SIZE) {
			System.out.println("TOO LOW! The minimum board size is " + MIN_BOARD_SIZE + "x" + MIN_BOARD_SIZE + ", so that will be the size used.");
			size = MIN_BOARD_SIZE;
		}
		
		System.out.println("Please enter how many players are competing:");
		// Integer greater than 0 
		int numPlayers = Game.acceptValidPosInt();
		
		System.out.println("Please enter how many heroes (1-3) will be on each team (for each player):");
		// Integer greater than 0 but less than 4
		int numHeroesPerTeam = Game.acceptValidPosInt();
		
		if (numHeroesPerTeam > MAX_HEROES_PER_TEAM) {
			System.out.println("TOO HIGH! The maximum number of heroes per team is " + MAX_HEROES_PER_TEAM + ", so that will be the amount used.");
			numHeroesPerTeam = MAX_HEROES_PER_TEAM;
		} else if (numHeroesPerTeam < MIN_HEROES_PER_TEAM) {
			System.out.println("TOO LOW! The minimum number of heroes per team is " + MIN_HEROES_PER_TEAM + ", so that will be the amount used.");
			numHeroesPerTeam = MIN_HEROES_PER_TEAM;
		}
		
		// Using the input variables, set up the game board and players array
		this.setBoard(new GameBoard(size));
		this.setPlayers(new Player[numPlayers]);
		
		// Initialize each of the game's players with an ID and an appropriate game piece 
		for (int i=0; i < numPlayers; i++) {
			this.setPlayerIndex(i, new Player(String.valueOf(i+1), "PY" + String.valueOf(i+1), numHeroesPerTeam));
		}
	}

	public void playGame() {
		// Clear the board before starting a new game
		this.clear();
		// Set up the board with the random assignment of each cell
		this.setUpBoard();
		
		for (int i=0; i < this.getPlayers().length; i++) {
			this.getGameBoard().chooseStartingPoint(this.getPlayers()[i]);
		}
		
		System.out.println(this.getGameBoard());		
		
		boolean continuing = true;
		while (continuing) {
			// Alternate between all of the players that we have (take turns)
			for (int i=0; i < this.getPlayers().length; i++) {
				System.out.println("Player " + this.getPlayers()[i].getPlayerID() + " What would you like to do? ");
				printKeyBindings();
				String next_move = Game.acceptValidKey();
				
				if (next_move.equals("Q") || next_move.equals("q") ) {
					continuing = false;
				}
				
//				this.getGameBoard().makeMove(next_move, this.getPlayers()[i].getPlayerID());
//				
//				// print the new state of the board
//				System.out.println(this.getGameBoard());
			}
		}
	}
	
	// Method used to randomly initialize the arrangement of cells of the board 
	// Using suggested distribution of (randomly assigned) 20% non-accessible cells, 30% markets and 50% common cells.
	public void setUpBoard() {
		Random random_gen = new Random();

		for (int i=0; i < this.getGameBoard().getNumRows(); i++) {
			for (int j=0; j < this.getGameBoard().getNumCols(); j++) {
				float random_cell = random_gen.nextFloat();
				if (random_cell <= 0.2) {
					this.getGameBoard().assignCell(i, j, "Inaccessible");
				} else if (random_cell <= 0.5) {
					this.getGameBoard().assignCell(i, j, "Market");
				} else { // if (random_cell < 1.0) 
					this.getGameBoard().assignCell(i, j, "Common");
				}
			}
		}		
	}
	
	public static void printKeyBindings() {
		System.out.println("     Enter W/w to move up");
		System.out.println("     Enter A/a to move left");
		System.out.println("     Enter S/s to move down");
		System.out.println("     Enter D/d to move right");
		System.out.println("     Enter Q/q to quit the game");
		System.out.println("     Enter I/i to show information");
	}
	

}
