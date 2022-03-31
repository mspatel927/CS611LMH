package pa4;
/*
 * Manish Patel - CS 611 (Spring 2022)
 * Marker.java: Defines the class that represents what each cell on a Game Board contain (player or what type of cell) 
 */
public class Marker {
	
	// The string or character that represents the player's game piece 
	private String piece;
	
	// Constructor for a Marker using an input String
	public Marker(String mark) {
		this.piece = mark;
	}
	
	// No-arg constructor that uses the empty String to call the other constructor
	public Marker() {
		this("\0");
	}
	
	// Getter method to return the piece that this Marker object represents 
	public String getPiece() {
		return this.piece;
	}
	
	// Method to be used to print out the piece that this Marker represents 
	public String toString() {
		return this.piece;
	}
}
