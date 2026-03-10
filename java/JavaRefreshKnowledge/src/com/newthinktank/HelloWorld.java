package com.newthinktank;
import java.util.*;
import java.util.stream.IntStream;

public class HelloWorld {
	static Scanner sc = new Scanner(System.in);
	final double SHORTPI = 3.14159;
	
	public static void main(String[] args) {
//		System.out.println("Me");
//		System.out.println("Hello World");
//		int var1 = 100;
//		int v2, v3;
//		
//		//byte, short, char, boolean, int, float,
//		//double, and long
//		boolean happy = true;
//		char a= 'a';
//		float fNum = 1.111111F;
//		float fNum2 = 1.1111111F;
//		System.out.println("Float : " + (fNum + fNum2));
//		
//		double thousand = 1e+3;
//		System.out.println(thousand);
//		
//		//casting 10 min mark
//		int smInt = 10;
//		long smLong = smInt;
//		
//		//casting needed
//		double cDbl = 1.234;
//		int cInt = (int) cDbl;
//		System.out.println(cInt);
//		
//		long bigLong = 21474893453L;
//		int bInt = (int) bigLong;
//		System.out.println(bInt);
//		
//		String favNumString = Double.toString(1.618);
////		Byte.parseByte
//		int strInt = Integer.parseInt("10");
//		System.out.println(strInt);
//		
//		//13:00 math functions
//		System.out.println("\n13:00 min mark. math");
//		System.out.println("5+4 = " + (5+4));
//		System.out.println("5-4 = " + (5-4));
//		System.out.println("5*4 = " + (5*4));
//		System.out.println("5/4 = " + (5/4));
//		System.out.println("5%4 = " + (5%4));
//
//		System.out.println("5/4 = " + (5.0/4.0));
//		//familiar with num++ num-- and such operations
//		
//		//16:00 Random Numbers
//		System.out.println("\n16:00 random numbers");
//		int minNum = 5;
//		int maxNum = 20;
//		int randomNum = minNum + (int)(Math.random()*(maxNum-minNum)+1);
//		System.out.println("randomNum = "+ randomNum);
//		
//		//17:00 Strings
//		System.out.println("\n17:00 Strings");
//		String nameString = "firstName";
//		String wNameString = nameString + "lastName";
//		wNameString += " is my name";
//		System.out.println(wNameString);
//		System.out.println(wNameString.charAt(4));
//		System.out.println(wNameString.contains("lastName"));
//		System.out.println(wNameString.indexOf('N'));
//		System.out.println(wNameString.length());
//		
//		//string comparison
//		System.out.println("dog equals cat? " + "dog".equals("cat"));
//		System.out.println(wNameString.compareTo("ABC"));
//		System.out.println(wNameString.replace("lastName", "Robert"));
//		for(String x: wNameString.split(" "))System.out.println(x); 
		
		//23:20 Strings builders and buffers
		System.out.println("\n17:00 Strings builders and buffers");
		StringBuilder sb = new StringBuilder("I'm a new string builder");
		System.out.println(sb.length());
		System.out.println(sb.capacity());
		System.out.println(sb.append(" Yeah"));
		System.out.println(sb.replace(6, 9, "TMP"));
		System.out.println(sb.substring(6,10));
		System.out.println(sb.delete(6,10));
		System.out.println(sb.charAt(4));
		System.out.println(sb.indexOf("Yeah"));
		
		//26:40 Array
		System.out.println("\n 26:40 Array");
		int[] a1 = new int[10];
		a1[0] = 1;
		Arrays.fill(a1,2);
		System.out.println(a1[0]);
		System.out.println(a1.length);
		String[] a2 = {"one", "two"};
		int[] oneTo10 = IntStream.rangeClosed(1, 10).toArray();
		for(int x:oneTo10) {
			System.out.println(x);
		}
		System.out.println("index of found: " + Arrays.binarySearch(oneTo10, 9));
		
		int a3[][] = new int[2][2];
		String[][] a4 = {{"00","10"},
				{"01","11"},
		};
		System.out.println(a4[1][1]);
		//three dimensional
		String a5[][][] = {{{"000"}, {"100"}, {"200", "300"}},
			{{"000"}, {"100"}, {"200", "300"}},
			{{"000"}, {"100"}, {"200", "300"}}};
		
		System.out.println(a5[2][2][1]);
		//copying array into another
		int a6[] = {3,2,1};
		int a7[] = Arrays.copyOf(a6,3);
		System.out.println(Arrays.equals(a6, a7));
		Arrays.sort(a7);
		System.out.println(Arrays.toString(a7));
		
		//33:40 Array List
		System.out.println("\n33:40 Array List");
		ArrayList<String> al1 = new ArrayList<String>(20);
		al1.add("Sue");
		ArrayList<Integer> al2 = new ArrayList<Integer>(Arrays.asList(1,2,3,4));
		for(Integer x: al2) System.out.println(x);
		System.out.println(al2.get(1));
		al2.set(1, 5);
		al2.remove(3);
		
		//Iterator
		Iterator it = al2.iterator();
		while(it.hasNext())System.out.println(it.next());
		
		//Linked List: each item has reference to before/after item
		//37:00 LinkedList
		System.out.println("\n37:00 LinkedList");
		LinkedList <Integer> l1 = new LinkedList<Integer>(); 
		l1.add(1); l1.add(2); l1.add(3);
		l1.addAll(Arrays.asList(1,2,3,4));
		l1.addFirst(0);
		l1.addLast(0);
		System.out.println(l1.indexOf(4));
		l1.set(0, 2);
		System.out.println(l1.get(0));
		l1.remove(1);
		System.out.println(l1);
		l1.clear();
		System.out.println(l1);
		
		//39:50 User Input
		System.out.println("\n39:50 User Input");
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
