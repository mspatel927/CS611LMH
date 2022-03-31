package pa4;
/*
 * Manish Patel - CS 611 (Spring 2022)
 * Warrior.java - Defines the class that represents the Warrior type of hero in the game of LHM
 */

import java.util.*;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;


public class Warrior extends Hero {
	public static List<String> allOptions = listOptions();

	public Warrior() {
		super("Warrior");
	}
	
	public Warrior(String stats) {
		super("Warrior");
		String[] splitStats = stats.split("\\s+");
		this.heroName = splitStats[0];
		this.mana = Integer.parseInt(splitStats[1]);
		this.strength = Integer.parseInt(splitStats[2]);
		this.agility = Integer.parseInt(splitStats[3]);
		this.dexterity = Integer.parseInt(splitStats[4]);
		this.money = Integer.parseInt(splitStats[5]);
		this.experience = Integer.parseInt(splitStats[6]);
	}
	
	public static List<String> listOptions() {
		String file = System.getProperty("user.dir") + "/ConfigFiles/" + "Warriors.txt";
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
