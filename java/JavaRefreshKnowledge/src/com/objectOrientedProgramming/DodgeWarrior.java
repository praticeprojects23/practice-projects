package com.objectOrientedProgramming;

import java.util.Random;

//extends: everything in Warrior is in DodgeWarrior
public class DodgeWarrior extends Warrior {
	double dodgePercent;
	Random rand = new Random();
	
	public DodgeWarrior(String name, int health, int attackMax, int blockMax, double dodgePercent) {
		super(name, health, attackMax, blockMax);
		this.dodgePercent = dodgePercent;
		
		teleportType = new CanTeleport();
	}
	
	//overwrite warrior block ability
	public int block() {
		double chance = rand.nextDouble();
		if( chance <= dodgePercent) {
			System.out.printf("%s Dodged the Atack\n\n", this.getNameString());
			return 10000;
		}else {
			return 1 + (int)(Math.random() *
					((blockMax-1)+1));
		}
	}
}
