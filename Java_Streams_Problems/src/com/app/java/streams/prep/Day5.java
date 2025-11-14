package com.app.java.streams.prep;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Day5 {
	
	static void problem1() {
		List<String> names = Arrays.asList("Alice", "Bob", "Arjun", "Charlie", "Ankit", "David");

		Map<String, List<String>> orderedNames = names.stream()
			    .collect(Collectors.groupingBy(
			        name -> name.substring(0, 1),       
			        TreeMap::new,                        
			        Collectors.toList()
			    ));
		orderedNames.forEach((a,b)->System.out.println("Key= "+a+" Value ="+b));
	}
	
	static void problem2() {
		List<Employee>employee=Employee.populateEmployee();
		
		Map<String,Optional<Employee>> employeeData=employee.stream()
											.collect(Collectors.
													groupingBy(Employee::getDepartment,
															Collectors.maxBy(Comparator.comparingLong(Employee::getSalary))));
	
		employeeData.forEach((a,b)->System.out.println("Department :"+a +" "+b.orElse(null)));
	}
	
	static void problem3() {
		List<Employee>employee=Employee.populateEmployee();
		List<String>departmentName=employee.stream().map(Employee::getDepartment).distinct().collect(Collectors.toList());
		
		String departmentNames=departmentName.stream().collect(Collectors.joining(", ", "[", "]")).toUpperCase();
		
		System.out.println("Total Department Names=> "+departmentNames);
	}
	
	static void problem4() {
		List<Employee>employee= Employee.populateEmployee();
		Map<String,List<Employee>>employeeData=employee.stream().collect(Collectors.groupingBy(Employee::getDepartment));
		
		employeeData.forEach((dep,empData)->{
			
			List<Employee>sortedData=empData.stream().sorted(Comparator.comparingLong(Employee::getSalary).reversed()).toList();
			if(sortedData.size()>=2) {
				System.out.println("Department "+dep+" Salary "+sortedData.get(1).getSalary());
			}
		});
	}
	
	static void problem5() {
		List<Employee>employee=Employee.populateEmployee();
		
		Map<Boolean,List<Employee>>sortedData= employee.stream().collect(Collectors.partitioningBy(emp->emp.getSalary()>100000));
	
		System.out.println("High earners: ");
		sortedData.get(true).forEach((a)->System.out.println(a.getName()) );
	
		System.out.println("\nOthers: ");
		sortedData.get(false).forEach((a)->System.out.println(a.getName()) );
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
