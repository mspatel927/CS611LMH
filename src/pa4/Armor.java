package pa4;
/*
 * Manish Patel - CS 611 (Spring 2022)
 * Armor.java: Defines the class that an Armor item that a hero can equip
 */

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Armor extends Item { //implements Equippable interface
	public static List<String> allOptions = listOptions();
	int damageReduction;
	
	public Armor() {
		super("Armor");
	}
	
	public Armor(String specs) {
		super("Armor");
		String[] splitStats = specs.split("\\s+");
		this.itemName = splitStats[0];
		this.itemCost = Integer.parseInt(splitStats[1]);
		this.requiredLevel = Integer.parseInt(splitStats[2]);
		this.damageReduction = Integer.parseInt(splitStats[3]);
	}
	
	public static List<String> listOptions() {
		String file = System.getProperty("user.dir") + "/ConfigFiles/" + "Armory.txt";
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
