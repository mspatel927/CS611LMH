package pa4;
/*
 * Manish Patel - CS 611 (Spring 2022)
 * GameBoard.java - Defines the class of the physical board for a given game and all the actions performed on it throughout the game
 */

import java.util.*;

public class GameBoard {
	// A two-dimensional array of cells
	private Cell[][] board;
	// One dimension of the square board
	private int boardSize;
	// First dimension of the board (if non-square)
	private int boardNumRows;
	// Second dimension of the board (if non-square)
	private int boardNumCols;
	
	// The constructor we will use to create an empty board given the user-defined input dimension 
	public GameBoard(int size) {
		this.boardSize = size;
		this.boardNumRows = size;
		this.boardNumCols = size;
		// We want the board to be square, so set both dimensions with the same size
		this.board = new Cell[this.boardSize][this.boardSize];
		// Initialize our board to have all empty cells 
		this.emptyBoard();
	}
		
	// Use constructor chaining to make the no-arg constructor default to a 8 x 8 board
	public GameBoard() {
		this(8);
	}
	
	// This constructor creates a possibly non-square empty board given the user-defined input dimension 
	public GameBoard(int numRows, int numCols) {
		this.boardNumRows = numRows;
		this.boardNumCols = numCols;
		// We want the board to be square, so set both dimensions with the same size
		this.board = new Cell[this.boardNumRows][this.boardNumCols];
		// Initialize our board to have all empty cells 
		this.emptyBoard();
	}
	
	// Getter method for the number of rows in this game board
	public int getBoardSize() {
		return this.boardSize;
	}
	
	// Getter method for the number of rows in this game board
	public int getNumRows() {
		return this.boardNumRows;
	}
	
	// Getter method for the number of columns in this game board
	public int getNumCols() {
		return this.boardNumCols;
	}
	
	// Clear the board (such as after a completed game) by emptying all the cells through a nested loop
	public void emptyBoard() {
		// Empty Cells using the no-arg constructor of Cell
		for (int i=0; i < this.boardNumRows; i++) {
			for (int j=0; j < this.boardNumCols; j++) {
				this.board[i][j] = new Cell();
			}
		}
	}
	
	// Set the type/marker of a specified cell in the board attribute
	public void assignCell(int row, int col, String cellType) {
		if ( cellType.equals("Inaccessible") ) {
			this.board[row][col] = new InaccessibleCell();
		} else if ( cellType.equals("Market") ) {
			this.board[row][col] = new MarketCell();
		} else if ( cellType.equals("Common") ) {
			this.board[row][col] = new CommonCell();
		} else {
			this.board[row][col] = new Cell(cellType);
		}
	}
	
	public void chooseStartingPoint(Player currPlayer) {
		Random random_gen = new Random();
		int i = 0;
		int j = 0;
		
		while (this.board[i][j].getType().equals("Inaccessible")) {
			int rand_row = random_gen.nextInt(0, this.boardNumRows-1);
			int rand_col = random_gen.nextInt(0, this.boardNumCols-1);
			i = rand_row;
			j = rand_col;
		}
		
		this.board[i][j].setEntry(new Marker("*" + currPlayer.getGamePiece() + "*")); 
		currPlayer.setLocation(i, j);
		
	}
	
	// Method used for the string representation of the game board
	public String toString() {
		String boardStr = "";
		for (int i=0; i < this.boardNumRows; i++) {
			boardStr += "+=====".repeat(this.boardNumCols);
			boardStr += "+\n";
			for (int j=0; j < this.boardNumCols; j++) {
				boardStr += "|" + this.board[i][j];
			}
			boardStr += "|\n";
		}
		boardStr += "+=====".repeat(this.boardNumCols) + "+";
		return boardStr;
	}

	// Verify that the input for the row of the board is not off the board (non-existent)
	private boolean validRow (int i) {
		return (i>=0) && (i<this.boardNumRows);
	}
	
	// Verify that the input for the column of the board is not off the board (non-existent)
	private boolean validCol (int j) {
		return (j>=0) && (j<this.boardNumCols);
	}
	
	// Verify that the proposed move has not already been performed and that the space exists on the board (i.e. not off the board)
	private boolean validMove (int i, int j) {
		return validRow(i) && validCol(j)
				&& this.board[i][j].isCellEmpty();
	}
	
	// After making sure the move is valid, place the piece at the empty space
	// If it's not valid, prompt the user to enter a valid move and call the function recursively to try again with the new input
	public void makeMove(int index, Marker playerPiece) {
		// Since the user is inputting a single value for the location of their move
		// We need to break it up into a row and column that can be used to actually index into the 2D array 
		int i = index / this.boardSize;
		int j = index % this.boardSize;
		
		// If the proposed move is at the end of a row, we need to adjust the numbers slightly
		if (j == 0) {
			i -= 1;
			j += this.boardSize;
		}
		
		// If its a valid move (checked with our helped method), then we can place the marker at that Cell 
		if ( validMove(i,j-1) ) {
			this.board[i][j-1].setEntry(playerPiece);
		} else {
			// If not valid, prompt the user again and call this function again 
			System.out.println("Please enter a VALID move:");
			int newIndex = Game.acceptValidPosInt();
			makeMove(newIndex, playerPiece);
		}
	}
	
	
}
