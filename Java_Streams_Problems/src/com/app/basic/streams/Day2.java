package com.app.basic.streams;

import java.util.Arrays;
import java.util.List;

public class Day2 {

	public static void main(String[] args) {
		
		List<Integer> numbers = List.of(2,4,5,34,56,7,8,99,3,18,43);
		int count=(int)numbers.stream().filter(abc->abc%2==0).count();
		System.out.println("Total integers in a list is"+count);
	}
	
}

class Day2_2{
	public static void main(String [] args) {
		
//		String [] names = {"Namit","sumit","rishabh","sai","julie","johanthan","abeer"};
//		List<String> nameList = List.of(names);
//		nameList=nameList.stream().map(String::toUpperCase).toList();
//		nameList.forEach(n->System.out.println(n));
		
		
		List<String> names = Arrays.asList("Namit","sumit","rishabh","sai","julie","johnathan","abeer");
		List<String>filteredNames=names.stream().
								 map(String::toUpperCase)
								 .toList();
		filteredNames.forEach(System.out::println);
	}
}

class Day2_3{
	public static void main (String[] args) {
		String [] names = {"Namit","sumit","rishabh","sai","julie","johanthan","abeer","alien","arav"};
		List<String> nameList = List.of(names);
		nameList=nameList.stream().filter(name-> name.startsWith("a")).toList();
		nameList.forEach(n->System.out.println(n));
	}
}