package com.app.java.streams.prep;

import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.LongSummaryStatistics;
import java.util.Map;
import java.util.stream.Collectors;

import com.app.basic.streams.data.Department;

public class Day6 {

	//Problem 1 — Flatten and Group Nested Data
	static void problem1() {
		List<Department> departments = Department.populateDepartments();
		
		Map<String, Long> totalSalaryPerDept = departments.stream()
			    .flatMap(dept -> dept.getEmployees().stream()
			            .map(emp -> new AbstractMap.SimpleEntry<>(dept.getName(), emp.getSalary())))
			    .collect(Collectors.groupingBy(
			            Map.Entry::getKey,
			            Collectors.summingLong(Map.Entry::getValue)
			    ));
		
		totalSalaryPerDept.forEach((dept, total) ->
	    System.out.println(dept + " → " + total)
	);
	}
	//Problem 2 — Find Top N Employees by Salary per Department
	static void problem2() {
		List<Department> departments = Department.populateDepartments();
		Map<String, Object> topEmployees = Department.populateDepartments().stream()
		        .collect(Collectors.toMap(
		                Department::getName,
		                dept -> dept.getEmployees().stream()
		                        .sorted(Comparator.comparingLong(Employee::getSalary).reversed())
		                        .limit(2)
		                        .collect(Collectors.toList())
		        ));

		topEmployees.forEach((dept, list) -> {
		    System.out.println(dept + " → " + list);
		});
	}
	
	//Problem 3 — Convert List to Custom String Format
	static void problem3() {
		List<String> names = List.of("John", "Ben", "Adam", "Clark");

		String formatted = names.stream()
		        .collect(Collectors.joining(" | ", "Employee Names: ", ""));

		System.out.println(formatted);

	}
	
	//Problem 4 — Partition Employees by Salary Range
	static void problem4() {
		List<Employee> employees = Department.populateDepartments().stream()
		        .flatMap(d -> d.getEmployees().stream())
		        .collect(Collectors.toList());

		Map<Boolean, List<Employee>> partitioned = employees.stream()
		        .collect(Collectors.partitioningBy(emp -> emp.getSalary() > 100000));

		partitioned.forEach((isHigh, list) -> {
		    System.out.println((isHigh ? "High Earners (>100k)" : "Others") + " → " + list);
		});

	}
	
	//Problem 5 — Department-wise Highest & Lowest Salaries
	static void problem5() {
		Map<String, LongSummaryStatistics> salaryStats = Department.populateDepartments().stream()
		        .collect(Collectors.toMap(
		                Department::getName,
		                dept -> dept.getEmployees().stream()
		                        .collect(Collectors.summarizingLong(Employee::getSalary))
		        ));

		salaryStats.forEach((dept, stats) ->
		        System.out.println(dept + " → Min: " + stats.getMin() + ", Max: " + stats.getMax()));

	}
	
	public static void main(String[] args) {
		
		problem1();
		System.out.println("--------------------");
		problem2();
		System.out.println("--------------------");
		problem3();
		System.out.println("--------------------");
		problem4();
		System.out.println("--------------------");
		problem5();
		
		
	}

}

