package com.app.basic.streams;

import java.util.List;

// Programm to find maximum number in given list
public class Day1 {
	
	public static void main(String [] args) {
		List<Integer> list = List.of(14,56,7,8,83,32,56);
		int maxNumber  = list.stream().max(Integer::compare).orElseThrow();
		System.out.println("Maximum number from the list is : "+maxNumber);
	}

}

// programm to find minimum number
  class Day1_1 {
	
	public static void main(String [] args) {
		List<Integer> list = List.of(14,56,7,8,83,32,56);
		int minNumber  = list.stream().min(Integer::compare).orElseThrow();
		System.out.println("Minimum number from the list is : "+minNumber);
	}

}