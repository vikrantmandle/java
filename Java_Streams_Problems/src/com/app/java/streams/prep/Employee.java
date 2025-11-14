package com.app.java.streams.prep;

import java.util.Arrays;
import java.util.List;

public class Employee {

	//id,name,salary
	private int id;
	private String name;
	private long salary;
	private String department;
	
	public Employee(int id, String name,long salary) {
		this.id=id;
		this.name=name;
		this.salary=salary;
	}
	
	  public Employee(String name, String department,long salary) {
	    	this.name=name;
	    	this.department=department;
	    	this.salary=salary;
	    }
	  
	  
	  
	public Employee(String name, long salary) {
		this.name = name;
		this.salary = salary;
	}

	public static List<Employee> populateEmployee() {
		List<Employee> employee = Arrays.asList(new Employee("John","HR",100000),new Employee("Ben","IT",300000),
				new Employee("Julie","HR",450000),new Employee("William","Cyber security",50000),
				new Employee("Geralt","IT",190000),new Employee("James","IT",67000),
				new Employee("Daniel","Cyber security",8000),new Employee("Peter","IT",1000),
				new Employee("Cyril","Cyber security",80000),new Employee("Adam","HR",10000));
	 
	 return employee;
	 }
	
	public static List<Employee> popuplateEmployeeWithoutDep(){
		
		 List<Employee> employee = Arrays.asList(new Employee("John",100000),new Employee("Ben",300000),
					new Employee("Julie",450000),new Employee("William",50000),
					new Employee("Geralt",190000),new Employee("James",67000),
					new Employee("Daniel",8000),new Employee("Peter",1000),
					new Employee("Cyril",80000),new Employee("Adam",10000));
		 
		 return employee;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getSalary() {
		return salary;
	}

	public void setSalary(long salary) {
		this.salary = salary;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return "Employee {name=" + name + ", salary=" + salary + "}";
	}
	
	
}
