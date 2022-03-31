package pa4;
/*
 * Manish Patel - CS 611 (Spring 2022)
 * Weapon.java - Defines the class that represents the Weapon item in the game of LHM that a hero can equip and use to attack
 */

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Weapon extends Item { //implements Attackable and Equippable
	public static List<String> allOptions = listOptions();
	int damage;
	int requiredHands;
	
	public Weapon() {
		super("Weapon");
	}
	
	public Weapon(String specs) {
		super("Weapon");
		String[] splitStats = specs.split("\\s+");
		this.itemName = splitStats[0];
		this.itemCost = Integer.parseInt(splitStats[1]);
		this.requiredLevel = Integer.parseInt(splitStats[2]);
		this.damage = Integer.parseInt(splitStats[3]);
		this.requiredHands = Integer.parseInt(splitStats[4]);
	}
	
	public static List<String> listOptions() {
		String file = System.getProperty("user.dir") + "/ConfigFiles/" + "Weaponry.txt";
		List<String> lines = Collections.emptyList();
		try {
			lines = Files.readAllLines(Paths.get(file), StandardCharsets.UTF_8);
		} catch (IOException e) {
			System.out.println("Please enter the correct filepath");
			e.printStackTrace();
		}
		return lines;
	}
	
	public static void showAvailOptions() {
		System.out.println("              " + allOptions.get(0));
		for (int i=1; i < allOptions.size(); i++) {
			System.out.println("          (" + i + ") " + allOptions.get(i));
		}
	}


}
