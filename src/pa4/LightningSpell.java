package pa4;
/*
 * Manish Patel - CS 611 (Spring 2022)
 * LightningSpell.java - Defines the class that represents the Lightning Spell item in the game of LHM that a hero can use to attack
 */

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

public class LightningSpell extends Spell { // implements Attackable
	public static List<String> allOptions = listOptions();


	public static List<String> listOptions() {
		String file = System.getProperty("user.dir") + "/ConfigFiles/" + "LightningSpells.txt";
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
