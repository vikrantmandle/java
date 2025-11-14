package com.app.java.streams.prep;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Day1_Revision {

	public static void main(String[] args) {
		
		//Problem 1
		//names: ["Virat", "Rohit", "Rahul", "Rishabh", "Bumrah", "Ishan"]
		
		List<String>names=Arrays.asList("Virat", "Rohit", "Rahul", "Rishabh", "Bumrah", "Ishan");
		List<String>filteredNames=names.stream().filter(n->n.startsWith("R")).sorted().collect(Collectors.toList());
		filteredNames.forEach(System.out::println);
		System.out.println("----------------------");
		//Problem 2
		//Use Stream API to calculate the sum of squares of all numbers.
		List<Integer> numbers=Arrays.asList(2, 3, 4, 5);
		int sum=numbers.stream().map(n->n*n).reduce(0,(a,b)->a+b);
		System.out.println("Sum of square of given numbers= "+sum);
		System.out.println("----------------------");
		//Problem 3
		//Use Stream operations to find the count of unique words.
		List<String>fruits=Arrays.asList("apple", "banana", "apple", "orange", "banana", "grape");
		long count=fruits.stream().distinct().count();
		System.out.println("Count of unique elements is = "+count);
		
		//another way to show the names
		Set<String> uniqueFruits=new HashSet<String>(fruits);
		uniqueFruits.forEach(System.out::println);
		
		System.out.println("----------------------");
		//problem 4
		//Return a list of employee names having salary greater than 50,000, sorted in descending order of salary.
		List<Employee> employees= Arrays.asList(new Employee(1, "Harsh", 20000),
				 new Employee(2, "Sadhana", 50000),
				 new Employee(3, "Aarav", 60000),
				 new Employee(4, "Justin", 70000),
				 new Employee(5, "Ruhi", 45000),
				 new Employee(6, "Ben", 51000));
		List<String> filteredEmployeeNames=employees.stream().filter(emp->emp.getSalary()>50000).sorted(Comparator.comparingLong(Employee::getSalary).reversed())
				.map(Employee::getName).toList();
				
		filteredEmployeeNames.forEach(System.out::println);
		System.out.println("----------------------");
		
		
		//Problem 5
		
		List<Transaction> transactions = List.of(
			    new Transaction("GROCERY", 2000),
			    new Transaction("ELECTRONICS", 8000),
			    new Transaction("GROCERY", 1500),
			    new Transaction("CLOTHING", 4000)
			);
		Map<String,Integer> filteredTransaction= transactions.
												 stream().
												 collect(Collectors.groupingBy(Transaction::getCategory,Collectors.summingInt(Transaction::getBudget)));
				
				
		filteredTransaction.forEach((a,b)->System.out.println(a+b));
	}

}
