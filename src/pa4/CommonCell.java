package pa4;
/*
 * Manish Patel - CS 611 (Spring 2022)
 * CommonCell.java: Defines the class that represents a common space on the game board
 */

public class CommonCell extends Cell {
	public CommonCell() {
		this.setEntry(new Marker(" ~~~ "));
		this.setType("Common");
	}
}
