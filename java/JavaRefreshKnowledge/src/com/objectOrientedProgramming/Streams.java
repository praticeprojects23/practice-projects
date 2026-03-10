package com.objectOrientedProgramming;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import javax.security.auth.x500.X500Principal;

public class Streams {

	public static void main(String[] args) {
		/*
		 * Java Streams, introduced in Java 8, provide a powerful, declarative, 
		 * functional-style API for processing sequences of elements 
		 * without modifying the original data source. 
		 * They are not a data structure themselves but rather a pipeline for operations.
		 */
		
		List<Integer> oneTo10 = IntStream.rangeClosed(0, 10).boxed().collect(Collectors.toList());
		//not sure about the long block of code above
		//collect(Collectors.toList()) makes it into list 
		List<Integer> squares = oneTo10.stream().map(x -> x*x).collect(Collectors.toList());
		//map takes each value in the list and performs an operation
		for(Integer x: squares) {
			System.out.println(x);
		}
		//show a filter to eliminate values based off a condition
		List<Integer> evensList = oneTo10.stream().filter(x -> (x%2) == 0).collect(Collectors.toList());
		for(Integer x:evensList)System.out.println(x);
		
		IntStream limitTo5 = IntStream.range(1,10).limit(5);
		limitTo5.forEach(System.out::println);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
