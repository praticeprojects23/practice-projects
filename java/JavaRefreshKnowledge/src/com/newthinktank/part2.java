package com.newthinktank;
import java.util.*;

import javax.swing.JOptionPane;

public class part2 {
	static Scanner sc = new Scanner(System.in);
	public enum Day {Monday,Tuesday,Wednesday,Thursday};
	
	public static void main(String[] args) {
		//39:50 User Input
		System.out.println("\n39:50 User Input");
		System.out.println("Enter name : ");
		//line represents string. short/etc. for other data types
		if(sc.hasNextLine()) {
			String usernameString = sc.nextLine();
			//sc.short, sc.integer, etc.
			System.out.println("Hello " + usernameString);
		}
		//Dialog Boxes..41:10 second mark
//		String jobNameString = 
//				JOptionPane.showInputDialog("Enter name");
		
		
		//..skipped to enumerator types at 1:01 mark
		Day favDay = Day.Thursday;
		System.out.println("Fav day is " + favDay);
	}

}
