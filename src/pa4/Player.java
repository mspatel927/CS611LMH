package pa4;
/*
 * Manish Patel - CS 611 (Spring 2022)
 * Player.java - Defines the class that represents an individual player of a game and their traits 
 */

public class Player {

	// The identification of a player (e.g. Player 1, Order, etc.)
	private String playerID;
	// The piece that the player will be using on their turns of the game
	private Marker gamePiece;
	// The number of total game wins that this Player has attained
	private int numWins; 
	// The list of heroes that this Player has on their team
	private Hero[] heroes;
	// Current location of the Player on the board
	private int[] currLoc = new int[2];

	
	// Constructor that creates a new Player with the given ID and game piece, and sets their win record to 0 
	public Player(String id, String icon) {
		this.playerID = id;
		this.gamePiece = new Marker(icon);
		setNumWins(0);
	}
	
	// Constructor that creates a new Player with the given ID and game piece and number of Heroes, and sets their win record to 0 
	public Player(String id, String icon, int numHeroes) {
		this.playerID = id;
		this.gamePiece = new Marker(icon);
		setNumWins(0);
		this.heroes = new Hero[numHeroes];
		System.out.println("Player " + id + ", Choose your heroes:");
		for (int i=0; i < numHeroes; i++) {
			// this.heroes[i] = new Hero(Hero.chooseHero(i+1));
			String heroType = Hero.chooseHeroType(i+1);
			this.heroes[i] = Hero.chooseHero(heroType);
			System.out.println("     " + this.heroes[i].toString());
		}
	}
	
	// Getter method for the playerID attribute
	public String getPlayerID() {
		return this.playerID;
	}
	
	// Getter method for the gamePiece attribute
	public Marker getGamePiece() {
		return this.gamePiece;
	}
	
	// Getter method for the numWins attribute
	public int getNumWins() {
		return this.numWins;
	}
	
	// Setter method that updates the number of wins for this player (used as games are played)
	public void setNumWins(int n) {
		this.numWins = n;
	}
	
	// Getter method for the current row location of the given player on the board 
	public int getLocationRow() {
		return this.currLoc[0];
	}
	
	// Getter method for the current column location of the given player on the board 
	public int getLocationCol() {
		return this.currLoc[1];
	}
	
	// Setter method that updates the current location of the given player on the board 
	public void setLocation(int i, int j) {
		this.currLoc[0] = i;
		this.currLoc[1] = j;
	}
	
	// When printing a Player object, we want to describe it's ID, the game piece being used, and how many games that Player won
	public String toString() {
		return ("Player " + this.getPlayerID() + " with game piece " + this.getGamePiece() + " won " + this.getNumWins() + " game(s).");

	}
}
