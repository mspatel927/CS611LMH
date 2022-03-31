package pa4;
/*
 * Manish Patel - CS 611 (Spring 2022)
 * MarketCell.java: Defines the class that represents a market space on the game board
 */

public class MarketCell extends Cell {
	
	public MarketCell() {
		this.setEntry(new Marker(" MKT "));
		this.setType("Market");
	}
	
	public void enterMarket() {
		System.out.println("Welcome to a Market! Would you like to \"Buy\" or \"Sell\"?");
		System.out.println("     You can enter \"N\" if you don't want to do either");
		String choice = Game.acceptValidDecision();
		
		if (choice.equals("Buy")) {
			buyAtMarket();
		} else if (choice.equals("Sell")) {
			sellAtMarket();
		} else { // "N" 
			return;
		}
	}


	public void buyAtMarket() {
		System.out.println("What would like to buy?");
	}
	
	public void sellAtMarket() {
		System.out.println("What would like to sell?");
	}
}
