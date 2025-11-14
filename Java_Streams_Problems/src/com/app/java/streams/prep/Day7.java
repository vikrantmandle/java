package com.app.java.streams.prep;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.LongSummaryStatistics;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import com.app.basic.streams.data.Department;
import com.app.basic.streams.data.Product;

public class Day7 {
	
	static void problem1() {
	List<Department>departmentData=Department.populateDepartments();
	Map<String, Map<String, List<String>>>result =departmentData.stream()
			.collect(Collectors.toMap(Department::getName, n->n.getEmployees().stream()
					.collect(Collectors.groupingBy(emp->{
				if (emp.getSalary() < 50000)
                    return "LOW";
                else if (emp.getSalary() < 100000)
                    return "MID";
                else
                    return "HIGH";
			},Collectors.mapping(Employee::getName, Collectors.toList())))
			));
	
	result.forEach((dept, rangeMap) -> {
	    System.out.println(dept + ":");
	    rangeMap.forEach((range, names) ->
	        System.out.println("  " + range + " -> " + names));
	});
	}

	//Problem 2 — Find The Longest Word in Nested Sentences
	static void problem2() {
		List<String> sentences = List.of(
			    "java streams are powerful",
			    "practice makes mastery",
			    "interviewers test your thinking"
			);
	String longestWord=sentences.stream().flatMap(sentence->Arrays.stream(sentence.split(" ")))
								.sorted(Comparator.comparingInt(String::length).reversed())
								.findFirst()
								.orElse(null);
	System.out.println("Longest word =>"+longestWord);
	
	//approach 2:
	Optional<String> longWord =
		    sentences.stream()
		        .flatMap(s -> Arrays.stream(s.split(" ")))
		        .max(Comparator.comparingInt(String::length));

		longWord.ifPresent(System.out::println);
	}
	
	static void problem3() {
			List<com.app.basic.streams.data.Product>productData=com.app.basic.streams.data.Product.populateProducts();
		Map<String,List<Product>> sortedProductData=productData.stream()
			.collect(Collectors.groupingBy(Product::getCategory,
					Collectors.collectingAndThen(Collectors.toList(), n->n.stream().sorted(Comparator.comparingDouble(Product::getPrice).reversed()).limit(2).toList())
					));
		sortedProductData.forEach((a,b)->   System.out.println(a + ":" + b));
	}	
	
	private static String capitalizeFirstWord(String name) {
		return name.substring(0,1).toUpperCase()+name.substring(1);
	}
	
	private static boolean nameStartsWithVowel(String name) {
		String firstLetter=String.valueOf(name.charAt(0));
		return Pattern.matches("^[aeiouAEIOU].*", firstLetter);
	}
	
	private static boolean nameStartsVowel(String name) {
	    char first = Character.toLowerCase(name.charAt(0));
	    return "aeiou".indexOf(first) != -1;
	}

	static void problem4() {
		List<Employee>departmentData=Employee.populateEmployee();
	Map<String,LongSummaryStatistics>data=	departmentData.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.summarizingLong(Employee::getSalary)));
	
	data.forEach((a,b)->{System.out.println("Department: "+a+"{count= "+b.getCount()+", min= "+b.getMin()+", max= "+b.getMax()+", sum= "+b.getSum()+"average= "+b.getAverage()+"}");});
	
	}
	static void problem5() {
		List<String> names = List.of("  harsh ", " VIKRANT", "sadhana ", "  aarav");
	    String result = names.stream()
	            .map(String::trim)
	            .map(String::toLowerCase)
	            .map(Day7::capitalizeFirstWord)        
	            .sorted()
	            .collect(Collectors.joining(" | "));
		System.out.println("Result=> "+result);
	}
	
	static void problem6() {
		String paragraph = "Java Stream API is powerful and Java is fun and Stream is useful";
		List<String> wordsList=List.of(paragraph.split(" "));
		Map<String,Long>result=wordsList.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
		Optional<Map.Entry<String, Long>>	highestWordCount=result.entrySet().stream().max(Map.Entry.comparingByValue());
	
		highestWordCount.ifPresent((entry->{
			System.out.println("Word =>"+entry.getKey() +" Count=>"+entry.getValue());
		}));
	}
	
	static void problem7() {
		List<Employee>employeeData=Employee.populateEmployee();
		
		List<Employee> promotionList=employeeData.stream().filter(emp->emp.getSalary()>150000).filter(n->nameStartsVowel(n.getName()))
		.sorted(Comparator.comparingLong(Employee::getSalary).reversed())
		.collect(Collectors.toList());
		
		promotionList.forEach(System.out::println);
	}
	
	public static void main(String[] args) {
		problem1();
		System.out.println("----------------------");
		problem2();
		System.out.println("----------------------");
		problem3();
		System.out.println("----------------------");
		problem4();
		System.out.println("----------------------");
		problem5();
		System.out.println("----------------------");
		problem6();
		System.out.println("----------------------");
		problem7();
	}

}


/*
Problem 1 — Multi-Level Grouping: Department → Salary Range → Names
	Salary ranges:
	LOW: < 50,000
	MID: 50,000 – 100,000
	HIGH: > 100,000
	
Problem 2 — Find The Longest Word in Nested Sentences
Task:
Use Streams to find the longest word across all sentences.
Hint:

*/