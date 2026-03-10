package com.objectOrientedProgramming;

public class Warrior {
	//class variables, generally private
	protected String nameString = "Warrior";
	public int health =0;
	public int attKMax = 0;
	public int blockMax = 0;
	
	//instance variable. sub classes at runtime will decide
	// if they can teleport or not
	public Teleports teleportType;
	
	//constructor. has same name as class
	//whenever a new Warrior object is called
	public Warrior() {
	}

	//constructor with setting attributes
	public Warrior(String name, int health, int attkMax, int blockMax) {
		this.setNameString(name);
		this.setHealth(health);
		this.setAttKMax(attkMax);
		this.setBlockMax(blockMax);
	}
	//getters and setters auto generated through eclpise
	public String getNameString() {
		return nameString;
	}

	public void setNameString(String nameString) {
		this.nameString = nameString;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public int getAttKMax() {
		return attKMax;
	}

	public void setAttKMax(int attKMax) {
		this.attKMax = attKMax;
	}

	public int getBlockMax() {
		return blockMax;
	}

	public void setBlockMax(int blockMax) {
		this.blockMax = blockMax;
	}

	//model capabilities
	public int attack() {
		return 1 + (int)(Math.random() *
				((attKMax-1)+1));
	}
	public int block() {
		return 1 + (int)(Math.random() *
				((blockMax-1)+1));
	}
	
	public String teleport() {
		return teleportType.teleport();
	}
	//allow dynamically change
	public void setTeleportAbility(Teleports newTeleportType) {
		teleportType = newTeleportType;
	}
}
