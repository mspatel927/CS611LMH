package pa4;
/*
 * Manish Patel - CS 611 (Spring 2022)
 * Game.java - Defines the top (in the hierarchy) class that lets a player choose a game and creates the game session
 */
import java.util.*;

public class Game {
	// The attribute simply containing the name of the game desired to be played
	private String gameName;
	
	// Constructor used to create a game session using the user-provided name
	public Game(String name) {
		this.setGameName(name);
	}
	
	// No-arg constructor that will create an essentially null game session
	public Game() {
		this.setGameName("");
	}
	
	// Getter method for the name of the game for this session
	public String getGameName() {
		return this.gameName;
	}
	
	// Setter method to set the name of the game for this session
	public void setGameName(String name) {
		this.gameName = name;
	}
	
	// A static method initially used by the user to welcome the player to the session and tell them to select a game
	public static String chooseGame() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Hello! Please choose a game to play: ");
		System.out.println( "(Enter \"1\" for Legends: Monsters and Heroes)" );
		// Loop until we get a valid game selection (doesn't terminate the program)
		while (true) {
			String choice = scanner.nextLine();
			// If the selection isn't 1
			if ( !choice.equals("1") ) {
				System.out.println("Please select a game from the list above!");
			} else {
				return choice;
			}
		}
	}
	
	// A method used to start the respective game session of whichever game the user selected
	public void start() {
		if (this.getGameName().equals("1")) {
				LHM legends = new LHM();
				legends.playGame();
			} else { 
				// A second (last resort) check to verify the validity of the game selection 
				System.out.println("Sorry, that game is not available!");
			}
	}
	
	// Used to print the name of the game in this session
	public String toString() {
		 return this.getGameName();
	}
	
	// Method to be used by any class that allows us to validate input integers to be used in our games 
	// Examples of use: selecting number of players, board size, location of moves, etc.
	public static int acceptValidPosInt() {
		Scanner scanner = new Scanner(System.in);
	    while (true) {
	    	
	    	// Take in the next string from by the user
	        String validInput = scanner.nextLine();
	        
	        // Check if we have even gotten an integer as input
	        try {
	    	    int num = Integer.parseInt(validInput);
	    	    // Check if its positive, and return if it is
	    	    if (num > 0) {
	    	    	return num;
	    	    } else {
	    	    	// If it's not positive, we want to tell the user to enter a valid value
	    	    	throw new java.lang.NumberFormatException();
	    	    }
	    	    
	    	// If we did not get an integer, or specifically a positive integer, ask the user again and re-loop
	        } catch (java.lang.NumberFormatException error) {
	            System.out.println("Please enter a VALID (positive) integer value: ");
	        }
	    }
	}
	
	// Method to be used by any class that allows us to validate a string as "Buy" or "Sell" or "N"
	public static String acceptValidDecision() {
		String validInput;
		Scanner scanner = new Scanner(System.in);
	    while (true) {
	    	// Take in the next input from the user 
	    	validInput = scanner.nextLine();
	    	// If we got a valid Yes or No, then we can return such
	    	if ( validInput.equals("Buy") || validInput.equals("Sell") || validInput.equals("N") ) {
	    		return validInput;
	    	} else {
	    		// Otherwise, prompt the user again and re-loop
	            System.out.println("Please enter a VALID (\"Buy\", \"Sell\", or \"N\") decision: ");
	        }
	    }
	}
	
	// Method to be used by any class that allows us to validate the key entered to control the game
	// Used when a player is able to choose their next move in a game
	public static String acceptValidKey() {
		String validInput;
		Scanner scanner = new Scanner(System.in);
	    while (true) {
	    	// Take in the next input from the user 
	    	validInput = scanner.nextLine();
	    	// If we got a valid key from "WASDQIwasdqi", then return it
	    	String validKeys = "WASDQIwasdqi";
	    	if ( validInput.length() == 1 && validKeys.contains(validInput) ) {
	    		return validInput;
	    	} else {
	    		// Otherwise, prompt the user again and re-loop
	            System.out.println("Please enter a VALID key for your next action: ");
	        }
	    }
	}

}
