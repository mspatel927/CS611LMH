package pa4;
/*
 * Manish Patel - CS 611 (Spring 2022)
 * InaccessibleCell.java: Defines the class that represents an inaccessible space on the game board
 */

public class InaccessibleCell extends Cell {
	public InaccessibleCell() {
		this.setEntry(new Marker("  X  "));
		this.setType("Inaccessible");
	}
}
