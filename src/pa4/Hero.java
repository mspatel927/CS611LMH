package pa4;
/*
 * Manish Patel - CS 611 (Spring 2022)
 * Hero.java - Defines the class that represents a generic hero in the game of LHM
 */

import java.util.*;

public class Hero {
	String heroType;
	String heroName;
	int mana;
	int strength;
	int agility;
	int dexterity;
	int money;
	int experience;
	
	Item[] inventory;
	
	public Hero(String choice) {
		this.heroType = choice;
	}


	public static String chooseHeroType(int teamIndex) {
		System.out.print("     Choose Class (Warrior, Sorcerer, or Paladin) of Hero #" + String.valueOf(teamIndex) + ":"); 
		String classChoice = Hero.acceptValidHeroClass();
		if (classChoice.equals("Warrior")) {
			Warrior.showAvailOptions();
		} else if (classChoice.equals("Sorcerer")) {
			Sorcerer.showAvailOptions();
		} else {
			Paladin.showAvailOptions();
		}
		return classChoice;
		
	}
	
	// Method to be used to validate a string as "Warrior", "Sorcerer", or "Paladin"
	// Used for players to narrow down by hero classes when building their team
	public static String acceptValidHeroClass() {
		String validInput;
		Scanner scanner = new Scanner(System.in);
	    while (true) {
	    	// Take in the next input from the user 
	    	validInput = scanner.nextLine();
	    	// If we got a valid answer, then we can return such
	    	if ( validInput.equals("Warrior") || validInput.equals("Sorcerer") || validInput.equals("Paladin") ) {
	    		return validInput;
	    	} else {
	    		// Otherwise, prompt the user again and re-loop
	            System.out.println("Please enter a VALID (\"Warrior\", \"Sorcerer\",  or \"Paladin\") hero class: ");
	        }
	    }
	}
	
	public static Hero chooseHero(String type) {
		if (type.equals("Warrior")) {
			System.out.print("     Pick which Warrior to add to your team (from those shown above):");
			int warriorChoice = Game.acceptValidPosInt();
			while (warriorChoice < 1 || warriorChoice > Warrior.allOptions.size()-1) {
				System.out.println("That warrior is not available! Pick again!");
				warriorChoice = Game.acceptValidPosInt();
			}
			String chosenHeroInfo = Warrior.allOptions.get(warriorChoice);
			return new Warrior(chosenHeroInfo); 
		} else if (type.equals("Sorcerer")) {
			System.out.print("     Pick which Sorcerer to add to your team (from those shown above):");
			int sorcererChoice = Game.acceptValidPosInt();
			while (sorcererChoice < 1 || sorcererChoice > Sorcerer.allOptions.size()-1) {
				System.out.println("That sorcerer is not available! Pick again!");
				sorcererChoice = Game.acceptValidPosInt();
			}
			String chosenHeroInfo = Sorcerer.allOptions.get(sorcererChoice);
			return new Sorcerer(chosenHeroInfo); 
		} else {
			System.out.print("     Pick which Paladin to add to your team (from those shown above):");
			int paladinChoice = Game.acceptValidPosInt();
			while (paladinChoice < 1 || paladinChoice > Paladin.allOptions.size()-1) {
				System.out.println("That paladin is not available! Pick again!");
				paladinChoice = Game.acceptValidPosInt();
			}
			String chosenHeroInfo = Sorcerer.allOptions.get(paladinChoice);
			return new Paladin(chosenHeroInfo); 
		}
	}
	
	public String toString() {
		String repr = this.heroType + ": " + this.heroName + " with mana=" + this.mana + ", with strength=" + this.strength + ", with agility=" + this.agility + ", with dexterity=" + this.dexterity + ", with money=" + this.money + ", with experience=" + this.experience;
		return repr;
	}
	
	
}
