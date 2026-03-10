package com.objectOrientedProgramming;

public class Battle {
	public static  void startFight(Warrior w1, Warrior w2) throws InterruptedException {
		while(true) {
			//continues till one of the two is no more.
			if(getAttackResult(w1, w2).equals("Game Over")) {
				System.out.println("Game Over");
				break;
			}
			if(getAttackResult(w2, w1).equals("Game Over")) {
				System.out.println("Game Over");
				break;
			}
		}
	}

	public static String getAttackResult(Warrior wA, Warrior wB) throws InterruptedException {
		int wAAttkAmt = wA.attack();
		int wBBlockAmt = wB.block();
		
		int dmg2WarB = wAAttkAmt-wBBlockAmt;
		if(dmg2WarB>0) {
			
			wB.health -= dmg2WarB;
		} else dmg2WarB = 0;
		
		//printf is for formatted output
		
		/*
		 * %s
		 * %d
		 * %f
		 * .2f
		 * %c
		 * %e
		 * %t
		 * %b
		 */
		
		System.out.printf("%s Attacks %s and deals "
				+ "%d Damage\n", wA.getNameString(), wB.getNameString(),dmg2WarB);
		System.out.printf("%s Has %d Health \n\n",
				wB.getNameString(), wB.getHealth());
		Thread.sleep(1500);
		
		if(wB.getHealth()<=0) {
			System.out.printf("%s has Died and %s is "
					+ "Victorious\n", wB.getNameString(), 
					wA.getNameString());
			return "Game Over";
		}
		else return "fight Again";
		
	}
}