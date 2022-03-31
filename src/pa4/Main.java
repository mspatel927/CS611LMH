package pa4;

/*
 * Manish Patel - CS 611 (Spring 2022)
 * Main.java - Defines the concise main class that allows the users to begin playing a game
 */

public class Main {
	
	// The function that first executes, allowing the user to choose which game to play and start it session
	public static void main(String[] args) {
		String toPlay = Game.chooseGame();
		Game newGame = new Game(toPlay);
		newGame.start();
	}
}
