package pa4;
/*
 * Manish Patel - CS 611 (Spring 2022)
 * RPGame.java - Defines the abstract class that defines the attributes and methods we want each of our Role-Playing Games to contain
 */

public abstract class RPGame extends Game {
	// String gameName inherited from Game superclass
	private GameBoard board;
	private Player[] players;
	
	// No-arg constructor for our abstract class
	public RPGame() {
		this.board = new GameBoard();
		this.players = new Player[1];
	}
	
	// Method used to create the String representation of a Board Game
	public String toString() {
		return "Game of" + this.getGameName() + " with " + players.length + " players";
	}
	
	// Getter method for the board attribute 
	public GameBoard getGameBoard() {
		return this.board;
	}
	
	// Getter method for the players attribute
	public Player[] getPlayers() {
		return this.players;
	}
	
	// Setter method for the board attribute 
	public void setBoard(GameBoard brd) {
		this.board = brd;
	}
	
	// Setters method for the players attribute, using an entire list of Players
	public void setPlayers(Player[] playersList) {
		this.players = playersList;
	}
	
	// Setters method for just of one of Players in the players attribute, using a given index and new Player 
	public void setPlayerIndex(int index, Player newPlayer) {
		this.players[index] = newPlayer;
	}
	
	// Method used to clear the board for this board game
	public void clear() {
		this.board.emptyBoard();
	}
	
	// The methods we want any subclass of RPGame to implement
	abstract public void playGame();
	abstract public void setUpBoard();
}
