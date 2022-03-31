package pa4;
/*
 * Manish Patel - CS 611 (Spring 2022)
 * Spell.java - Defines the class that represents a generic spell in the game of LHM that a hero can use to attack
 */

import java.util.*;

public abstract class Spell extends Item {
	int damage;
	int manaCost;
	
	public Spell() {
		super("Spell");
	}
	
	public Spell(String specs) {
		super("Spell");
		String[] splitStats = specs.split("\\s+");
		this.itemName = splitStats[0];
		this.itemCost = Integer.parseInt(splitStats[1]);
		this.requiredLevel = Integer.parseInt(splitStats[2]);
		this.damage = Integer.parseInt(splitStats[3]);
		this.manaCost = Integer.parseInt(splitStats[4]);
	}
	
	public static void showAvailOptions() {
		String spellChoice = chooseSpellType();
		
		if (spellChoice.equals("Fire")) {
			FireSpell.showAvailOptions();
		} else if (spellChoice.equals("Ice")) {
			IceSpell.showAvailOptions();
		} else {
			LightningSpell.showAvailOptions();
		}
	}

	public static String chooseSpellType() {
		System.out.print("     Choose which type of spell (Fire, Ice, or Lightning) you'd like to buy :"); 
		String classChoice = Spell.acceptValidSpellType();
		return classChoice;
		
	}
	
	// Method to be used to validate a string as "Fire", "Ice", or "Lightning"
	// Used for players to narrow down by spell types when buying a spell at the market 
	public static String acceptValidSpellType() {
		String validInput;
		Scanner scanner = new Scanner(System.in);
	    while (true) {
	    	// Take in the next input from the user 
	    	validInput = scanner.nextLine();
	    	// If we got a valid answer, then we can return such
	    	if ( validInput.equals("Fire") || validInput.equals("Ice") || validInput.equals("Lightning") ) {
	    		return validInput;
	    	} else {
	    		// Otherwise, prompt the user again and re-loop
	            System.out.println("Please enter a VALID (\"Fire\", \"Ice\",  or \"Lightning\") spell type: ");
	        }
	    }
	}

}
