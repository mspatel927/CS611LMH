package pa4;
/*
 * Manish Patel - CS 611 (Spring 2022)
 * Item.java - Defines the class that represents a generic item that can be bought or sold in the market
 */

import java.util.Scanner;

public class Item {
	String itemType;
	String itemName;
	int itemCost;
	int requiredLevel;
	
	public Item(String type) {
		this.itemType = type;
	}
	
	public static String chooseItemType() {
		System.out.print("     Choose which type of item (Armor, Weapon, Potion, or Spell) you'd like to buy:"); 
		String itemChoice = Item.acceptValidItemType();
		if (itemChoice.equals("Armor")) {
			Armor.showAvailOptions();
		} else if (itemChoice.equals("Weapon")) {
			Weapon.showAvailOptions();
		} else if (itemChoice.equals("Potion")) {
			Potion.showAvailOptions();
		} else {
			Spell.showAvailOptions();
		}
		return itemChoice;
		
	}
	
	// Method to be used to validate a string as "Warrior", "Sorcerer", or "Paladin"
	// Used for players to narrow down by item classes when visiting the market
	public static String acceptValidItemType() {
		String validInput;
		Scanner scanner = new Scanner(System.in);
	    while (true) {
	    	// Take in the next input from the user 
	    	validInput = scanner.nextLine();
	    	// If we got a valid item class, then we can return such
	    	if ( validInput.equals("Armor") || validInput.equals("Weapon") || validInput.equals("Potion") || validInput.equals("Spell") ) {
	    		return validInput;
	    	} else {
	    		// Otherwise, prompt the user again and re-loop
	            System.out.println("Please enter a VALID (\"Armor\", \"Weapon\", \"Potion\", or \"Spell\") item class: ");
	        }
	    }
	}

}
