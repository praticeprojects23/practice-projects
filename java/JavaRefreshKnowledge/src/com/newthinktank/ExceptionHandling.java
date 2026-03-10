package com.newthinktank;

import com.newthinktank.part2.Day;

public class ExceptionHandling {
	public static void main(String[] args) throws Exception {
		//01:02:00 Exception Handling
		System.out.println("\n01:02:00 Exception Handling");
		try {
//			int badInt =10/0;
			//throwing custom message
			throw new Exception("Bad Stuff");
		} catch (ArithmeticException e) {
			System.out.println(e);
			System.out.println(e.getMessage());
			System.out.println(e.toString());
			System.out.println("Can't divid by Zero");
		}
		catch (Exception e) {
			System.out.println(e);
		}
		finally {
			//oppportunity to close files/cleanup/etc
			System.out.println("Clean up");
		}
		System.out.println("last line");
	}
}
