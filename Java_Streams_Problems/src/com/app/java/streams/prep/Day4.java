package com.app.java.streams.prep;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.LongSummaryStatistics;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class Day4 {

	//Problem 1 — Nested Grouping: Employees by Department and Salary Range
	static void problem1() {
		List<Employee>employee=Employee. populateEmployee();
		
		Map<String,Map<String,List<Employee>>>sortedEmployeeData=employee.stream().
																collect(Collectors.groupingBy(Employee::getDepartment,
																Collectors.groupingBy(emp->{  if (emp.getSalary() < 50000)
											                        return "LOW";
											                    else if (emp.getSalary() < 100000)
											                        return "MID";
											                    else
											                        return "HIGH";})));
		sortedEmployeeData.forEach((dept, rangeMap) -> {
		    System.out.println("\nDepartment: " + dept);
		    rangeMap.forEach((range, emps) -> {
		        System.out.println("  " + range + " => " + emps);
		    });
		});
	}
	
	//Problem 2 — Department with Max Total Salary
	static void problem2() {
		List<Employee>employee=Employee.populateEmployee();
		Map<String,Long>departmentSalary=employee.stream().
				collect(Collectors.groupingBy(Employee::getDepartment,Collectors.summingLong(Employee::getSalary)));
		Optional<Map.Entry<String,Long>> highestSalaryDepartment=departmentSalary.entrySet().stream().max(Map.Entry.comparingByValue());
	
		highestSalaryDepartment.ifPresent(entry->{
		    System.out.println("Department with highest salary: " 
			        + entry.getKey() + " (" + entry.getValue() + ")");
		});
		
		//Enhancement : If departments with similar salaries are present
//		long max = departmentSalary.values().stream().mapToLong(Long::longValue).max().orElse(0);
//		departmentSalary.entrySet().stream()
//		        .filter(e -> e.getValue() == max)
//		        .forEach(System.out::println);

	}
	
	//Problem 3 — Join All Names Alphabetically
	static void problem3() {
		List<String>names=Arrays.asList("John", "Ben", "Adam", "Clark");
		String combined=names.stream().sorted().collect(Collectors.joining(", ", "[", "]"));
		System.out.println("Combined names "+combined);
		
	}
	
	//Problem 4 — Average Budget of Successful Transactions by Category
	static void problem4() {
		List<Transaction> transactions=Transaction.populateDefaultTransactions();
		
		Map<String, LongSummaryStatistics>averageTransactionValue=transactions.stream().filter(n->"SUCCESS".equals(n.getStatus())).
				collect(Collectors.groupingBy(Transaction::getCategory,Collectors.summarizingLong(Transaction::getBudget)));
		
		averageTransactionValue.forEach((a,b)->System.out.println("Department = "+a+" Average success amount="+b.getAverage()));
	
		//Enhancement: Collectors.averagingLong(Transaction::getBudget)

	
	}
	
	//	Problem 5 — Custom Collector: Count and Sum of Even Numbers
//	Given a list of integers, write a stream that returns both:
//	The count of even numbers
//	The sum of even numbers
//	Hint: Try to use Collectors.teeing() (Java 12+) OR do it using two collectors manually.
	
	static void problem5() {
		List<Integer> numbers=Arrays.asList(1,6,4,56,23,44,89,21,43,54);
		//long evenCount=numbers.stream().filter(n->n%2==0).count();
		
		//int sum= numbers.stream().filter(n->n%2==0).mapToInt(Integer::intValue).sum();
		
		Map<String,Number> result=numbers.stream().filter(n->n%2==0).collect(Collectors.
				teeing(Collectors.counting(), Collectors.summingInt(Integer::intValue), (count,sum)->Map.of("count",count,"sum",sum)));
		System.out.println("Count = " + result.get("count"));
		System.out.println("Sum = " + result.get("sum"));
	}
	
	
	public static void main(String [] args) {
		//Hello Vikrant welcome back you are really showing up for the work
		System.out.println("------------------------------");
		problem1();
		System.out.println("------------------------------");
		problem2();
		System.out.println("------------------------------");
		problem3();
		System.out.println("------------------------------");
		problem4();
		System.out.println("------------------------------");
		problem5();
	}
}
