package com.app.java.streams.prep;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class Day3 {
	//Problem 1: Partition Even and Odd Numbers
	static void  problem1() {
		List<Integer> numbers= Arrays.asList(1, 2, 3, 4, 5, 6, 7);
		Map<Boolean,List<Integer>>sortedNumbers=numbers.stream().collect(Collectors.partitioningBy(n->n%2==0));
		
		sortedNumbers.forEach((a,b)-> System.out.println(a +"="+b));
	}
	
	//Problem 2: Employee Average Salary by Department
	static void problem2() {
		List<Employee> employee= Employee.populateEmployee();
		Map<String, Double>averageSalary=employee.stream().
										 collect(Collectors.groupingBy(Employee::getDepartment,Collectors.averagingDouble(Employee::getSalary)));
	
	averageSalary.forEach((a,b)->System.out.println(a+" "+b));
	}

	//Problem 3: Flatten Nested Lists of Integers
	static void problem3() {
		List<List<Integer>> numbers = List.of(List.of(1,2), List.of(3,4), List.of(5,6));
		List<Integer> flattenList=numbers.stream().
								  flatMap(n->n.stream()).collect(Collectors.toList());
		flattenList.forEach(System.out::println);
	}
	
	//Problem 4: Find Department with Maximum Average Salary
	static void problem4() {
		List<Employee>employee=Employee.populateEmployee();
		Map<String,Double> maxAverageSalary=employee.stream().
				collect(Collectors.
						groupingBy(Employee::getDepartment,Collectors.averagingDouble(Employee::getSalary)));
		Optional<Map.Entry<String,Double>> maxSalaray=maxAverageSalary.entrySet().stream().max(Map.Entry.comparingByValue());
	
		maxSalaray.ifPresent(entry ->
	    System.out.println("Department with highest average salary: " 
	        + entry.getKey() + " (" + entry.getValue() + ")"));
	
	}
	
	//Problem 5: Top 3 Salaries Across All Departments
	
	static void problem5() {
		List<Employee> employee=Employee.populateEmployee();
		
		List<Employee>topEmployee=employee.stream().sorted(Comparator.comparingLong(Employee::getSalary).reversed()).limit(3).toList();
	
	topEmployee.forEach(System.out::println);
	}
	
	//Problem 6: Given a list of transactions (id, type, amount, status),
	//return a map where keys are transaction types and values are total amount of successful transactions only.
	static void problem6() {
		List<Transaction>successfulTransaction=Transaction.populateDefaultTransactions();
		
		Map<String,Integer>transactionData=successfulTransaction.stream().filter(n->n.getStatus()=="SUCCESS").
				collect(Collectors.groupingBy(Transaction::getCategory,Collectors.summingInt(Transaction::getBudget)));
	
		transactionData.forEach((a,b)->System.out.println("Transaction = "+a+" success amount="+b));
	
	}
	public static void main(String[] args) {
	
//		System.out.println("Hello Vikrant the battle of life continues today");
//		System.out.println("Remember the Knight within you and start working");
//		System.out.println("Its great seeing you showing up each day");
		System.out.println("------------------------");
		problem1();
		System.out.println("------------------------");
		problem2();
		System.out.println("------------------------");
		problem3();
		System.out.println("------------------------");
		problem4();
		System.out.println("------------------------");
		problem5();
		System.out.println("------------------------");
		problem6();
	}

}
