package pa4;
/*
 * Manish Patel - CS 611 (Spring 2022)
 * Cell.java: Defines the class that represents each entry (or square) of a GameBoard 
 */

public class Cell {
	
	// The item that is stored inside the cell, representing a player's game piece
	private Marker entry;
	// The type of the cell
	private String type;
	
	// Can construct a Cell object using a String, which is made into a Marker object ...
	public Cell(String input) {
		this.setEntry(new Marker(input));
	}
	
	// Or can construct a Cell object with a previously created Marker object
	public Cell(Marker input) {
		this.setEntry(input);
	}
	
	// No-arg constructor that simply sets the Cell to be empty
	public Cell() {
		this.setEntry(new Marker("     "));
	}
	
	// Getter method for the "entry" attribute of a cell
	public Marker getEntry() {
		return this.entry;
	}
	
	// Setter method to update the "entry" attribute of a cell
	public void setEntry(Marker piece) {
		this.entry = piece;
	}
	
	// Getter method for the "type" attribute of a cell
	public String getType() {
		return this.type;
	}
	
	// Setter method for the "type" attribute of a cell
	public void setType(String type) {
		this.type = type;
	}
	
	// Checks if this Cell has not been assigned a value yet
	// Returns true if the cell is empty, and false otherwise
	public boolean isCellEmpty() {
		return (this.getEntry().getPiece() == "\0");
	}
	
	// Prints out the Type, if any, of this Cell
	public String toString() {
		return this.getEntry().toString();
	}
	
	// Checks if two non-empty Cells have equal values inside of them
	public boolean equals(Cell other) {
		return (this.getEntry().getPiece().equals(other.getEntry().getPiece()) && (!this.isCellEmpty()));
	}
}
