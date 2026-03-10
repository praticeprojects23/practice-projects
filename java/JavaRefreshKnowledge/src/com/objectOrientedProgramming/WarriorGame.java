package com.objectOrientedProgramming;

public class WarriorGame {

	public static void main(String[] args) throws InterruptedException {
		Warrior thor = new Warrior ("Thor", 800, 130, 40);
		Warrior loki = new DodgeWarrior ("Loki", 800, 85, 40, .25);
		Battle.startFight(thor, loki);
		
		System.out.println("Loki " +loki.teleport());
		loki.setTeleportAbility(new CantTeleport());
		System.out.println("Loki " +loki.teleport());

	}
}
