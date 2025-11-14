package com.app.basic.streams.revision;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import com.app.java.streams.prep.Employee;

public class Day3 {

	//Problem 1: Partition Even and Odd Numbers
	static void problem1() {
		List<Integer> numbers= Arrays.asList(1, 2, 3, 4, 5, 6, 7,9,10);
		Map<Boolean,List<Integer>>partionedNums=numbers.stream().collect(Collectors.partitioningBy(n->n%2==0));
	
	partionedNums.forEach((a,b)->System.out.println(a+" "+b));
	}
	
	//Problem 2: Employee Average Salary by Department
	static void problem2() {
		List<Employee>employee=Employee.populateEmployee();
		Map<String,Double>averageEmpSalary=employee.stream().collect(Collectors.groupingBy(Employee::getDepartment,
				Collectors.averagingDouble(Employee::getSalary)
				));
		averageEmpSalary.forEach((a,b)->System.out.println(a+" "+b));
	}
	
	//Problem 3: Flatten Nested Lists of Integers
	static void problem3() {
		List<List<Integer>> numbers = List.of(List.of(1,2), List.of(3,4), List.of(5,6));
		List<Integer> flatList=numbers.stream().flatMap(n->n.stream()).collect(Collectors.toList());
		
		flatList.forEach(System.out::println);
	}
	
	//Problem4 Find Department with Maximum Average Salary
	static void problem4() {
		List<Employee> employee=Employee.populateEmployee();
		
		Map<String,Double>averageEmpSalary=	employee.stream().
		collect(Collectors.groupingBy(Employee::getDepartment,Collectors.averagingDouble(Employee::getSalary)));

		Optional<Map.Entry<String,Double>>highestAverageSalary= averageEmpSalary.entrySet().stream().max(Map.Entry.comparingByValue());
		highestAverageSalary.ifPresent(entry ->
	    System.out.println("Department with highest average salary: " 
		        + entry.getKey() + " (" + entry.getValue() + ")"));
	}
	
	//Problem 5: Top 3 Salaries Across All Departments
	static void problem5() {
		List<Employee> employee=Employee.populateEmployee();
		List<Employee>topEmployee=employee.stream().sorted(Comparator.comparingLong(Employee::getSalary).reversed()).limit(3).toList();
		System.out.println(topEmployee);
	
	}
	public static void main(String[] args) {
		problem1();
		System.out.println("---------------------------");
		problem2();
		System.out.println("---------------------------");
		problem3();
		System.out.println("---------------------------");
		problem4();
		System.out.println("---------------------------");
		problem5();
	}

}
