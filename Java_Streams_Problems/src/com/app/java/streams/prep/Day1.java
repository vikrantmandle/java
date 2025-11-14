package com.app.java.streams.prep;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Day1 {

	public static void main(String[] args) {
		
		//problem 1
		List<String>names= Arrays.asList("Virat", "Rohit", "Rahul", "Rishabh", "Bumrah", "Ishan");
		List<String>filteredNames=names.stream().
										filter(name-> name.startsWith("R")).
										sorted().
										collect(Collectors.toList());
		filteredNames.forEach(System.out::println);
		
		//problem 2
		List<Integer> numbers= Arrays.asList(2, 3, 4, 5);
		int sum=numbers.stream().
			   map(n->n*n).
			   reduce(0,(a,b)->a+b);
		System.out.println("Squared numbers "+sum);
		
		//problem 3
		List<String> uniqueFruits= Arrays.asList("apple", "banana", "apple", "orange", "banana", "grape");
		long count = uniqueFruits.stream().distinct().count();
		System.out.println("Count of unique fruits is -> "+count);
		
		//problem 4
		List<Employee> employeData= Arrays.asList(new Employee(1, "Harsh", 20000),
												 new Employee(1, "Sadhana", 50000),
												 new Employee(1, "Aarav", 60000),
												 new Employee(1, "Justin", 70000),
												 new Employee(1, "Ruhi", 45000));
		List<String>filteredEmployeData=employeData.stream().
				filter(n->n.getSalary()>50000).
				map(Employee::getName).
				toList();
		filteredEmployeData.forEach(System.out::println);
		//problem 5
		List<Transaction> transactions = List.of(
			    new Transaction("GROCERY", 2000),
			    new Transaction("ELECTRONICS", 8000),
			    new Transaction("GROCERY", 1500),
			    new Transaction("CLOTHING", 4000)
			);
		Map<String,Integer>newFilteredTransaction=transactions.stream().
				    collect(
					Collectors.groupingBy(Transaction::getCategory,Collectors.summingInt(Transaction::getBudget)));

		newFilteredTransaction.forEach((a,b)->System.out.println(a+b));
	}

}
