package com.app.basic.streams.data;

import java.util.List;

import com.app.java.streams.prep.Employee;

public class Department {
	  private String name;
	  private List<Employee> employees;
	  
	  public Department(String name, List<Employee>employee) {
		  this.name=name;
		  this.employees=employee;
	  }

	  public static List<Department> populateDepartments() {

		    List<Employee> hrEmployees = List.of(
		        new Employee("John", 100000),
		        new Employee("Julie", 450000),
		        new Employee("Adam", 120000)
		    );

		    List<Employee> itEmployees = List.of(
		        new Employee("Ben", 300000),
		        new Employee("Geralt", 190000),
		        new Employee("James", 67000)
		    );

		    List<Employee> cyberSecEmployees = List.of(
		        new Employee("Cyril", 80000),
		        new Employee("William", 50000)
		    );

		    List<Department> departments = List.of(
		        new Department("HR", hrEmployees),
		        new Department("IT", itEmployees),
		        new Department("Cyber Security", cyberSecEmployees)
		    );

		    return departments;
		}

	  
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	@Override
	public String toString() {
		return "Department [name=" + name + ", employees=" + employees + "]";
	}
	  
	  
}
