package pa4;
/*
 * Manish Patel - CS 611 (Spring 2022)
 * Monster.java - Defines the class that represents a generic monster in the game of LHM
 */

import java.util.*;


public class Monster {
	String monsterType;
	String monsterName;
	int damage;
	int defense;
	int dodge_chance;
	
	public Monster(String choice) {
		this.monsterType = choice;
	}

	public String toString() {
		String repr = this.monsterType + ": " + this.monsterName + " with damage=" + this.damage + ", with defense=" + this.defense + ", with dodge chance=" + this.dodge_chance;
		return repr;
	}
	
	public boolean spawnMonster() {
		Random random_gen = new Random();
		float coinFlip = random_gen.nextFloat();
		if (coinFlip <= 0.5) {
			return true;
		} else {
			return false;
		}

	}
	
}

