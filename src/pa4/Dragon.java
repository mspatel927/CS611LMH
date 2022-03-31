package pa4;
/*
 * Manish Patel - CS 611 (Spring 2022)
 * Dragon.java - Defines the class that represents the Dragon monster in the game of LHM
 */

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

public class Dragon extends Monster {
	public static List<String> allOptions = listOptions();

	public Dragon() {
		super("Dragon");
	}
	
	public Dragon(String stats) {
		super("Dragon");
		String[] splitStats = stats.split("\\s+");
		this.monsterName = splitStats[0];
		this.damage = Integer.parseInt(splitStats[1]);
		this.defense = Integer.parseInt(splitStats[2]);
		this.dodge_chance = Integer.parseInt(splitStats[3]);
	}
	
	public static List<String> listOptions() {
		String file = System.getProperty("user.dir") + "/ConfigFiles/" + "Dragons.txt";
		List<String> lines = Collections.emptyList();
		try {
			lines = Files.readAllLines(Paths.get(file), StandardCharsets.UTF_8);
		} catch (IOException e) {
			System.out.println("Please enter the correct filepath");
			e.printStackTrace();
		}
		return lines;
	}

}
