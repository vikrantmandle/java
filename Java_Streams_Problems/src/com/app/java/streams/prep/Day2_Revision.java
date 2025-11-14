package com.app.java.streams.prep;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Day2_Revision {

	public static void main(String[] args) {
		
		//Problem 1
		List<User> users = List.of(
			    new User("Alice", List.of("alice@gmail.com", "alice@work.com")),
			    new User("Bob", List.of("bob@yahoo.com")),
			    new User("Charlie", List.of("charlie@gmail.com", "c@company.com")),
			    new User("Mathew", List.of("mathew-wade@yahoo.com","mathew-new@gmail.com"))
			);
	
		List<String> sortedEmails=users.stream().
				flatMap(n->n.getEmails().stream().
						filter(elm->elm.endsWith("@gmail.com"))).collect(Collectors.toList());
	   System.out.println("----------------------");
	   
	   //Problem 2
	   List<Employee> employee = Arrays.asList(new Employee("John","HR",100000),new Employee("Ben","IT",300000),
				new Employee("Julie","HR",450000),new Employee("William","Cyber security",50000),
				new Employee("Geralt","IT",190000),new Employee("James","IT",67000),
				new Employee("Cyril","Cyber security",80000),new Employee("Adam","HR",10000));
	   
	   Map<String,Optional<Employee>>filteredEmployeeData=employee.stream().
			   collect(Collectors.groupingBy(Employee::getDepartment,Collectors.maxBy(Comparator.comparingLong(Employee::getSalary))));
	
	   filteredEmployeeData.forEach((a,b)->System.out.println("{"+a+" "+b.orElse(null)));
	   
	   System.out.println("----------------------");
	   
	   // problem 2 -> Enhanced version finding second or third highest salary
	   
	   Map<String,List<Employee>> groupedEmployeeData=employee.stream().
			   										  collect(Collectors.groupingBy(Employee::getDepartment));
	   
	   groupedEmployeeData.forEach((dep,empData)->{
		   							List<Employee>sortedEmployee=empData.stream()
		   														.sorted(Comparator.comparingLong(Employee::getSalary)
		   														.reversed()).toList();
		System.out.println("Department"+dep);
		if(sortedEmployee.size()>=2) {
			 System.out.println("  2nd Highest: " + sortedEmployee.get(1));
		}
		if(sortedEmployee.size()>=3) {
			 System.out.println("  3rd Highest: " + sortedEmployee.get(2));
		}
	   });
	   System.out.println("----------------------");
	   //problem 3
		List<Integer> list1 = List.of(1, 2, 3, 4, 5);
		List<Integer> list2 = List.of(4, 5, 6, 7, 8);
		
		List<Integer>commonElements=list1.stream().
									filter(elem1->list2.contains(elem1)).
									distinct().
									collect(Collectors.toList());
				
		commonElements.forEach(System.out::println);
		System.out.println("----------------------");

		//problem 4
		List<String> sentences = List.of(
			    "java stream api is powerful",
			    "java is versatile",
			    "stream api simplifies code"
			);
		Map<String,Long>countWords=sentences.stream().
				flatMap(sentence->Arrays.stream(sentence.split(" "))).
						collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
		countWords.forEach((word, count) -> System.out.println(word + " => " + count));
		System.out.println("----------------------");
		
		//Problem 5
		List<Product> products = List.of(new Product("Laptop", 85000),
			    new Product("Smartphone", 50000),
			    new Product("Earbuds", 5000),
			    new Product("Smartwatch", 15000),
			    new Product("Monitor", 15000),
			    new Product("Mouse", 3000)
			);
		List<Product>sortedProduct=products.stream().sorted(Comparator.comparing(Product::getName).thenComparing(Product::getPrice)).toList();

		sortedProduct.forEach(System.out::println);
	}

}
