package com.app.collection.practise.data;

import java.util.Objects;

public class Employee {
	
	private int emp_id;
	private String name;
	private int age;
	private String department;
	public Employee(int emp_id, String name, int age, String department) {
		super();
		this.emp_id = emp_id;
		this.name = name;
		this.age = age;
		this.department = department;
	}
	public int getEmp_id() {
		return emp_id;
	}
	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	@Override
	public int hashCode() {
		return Objects.hash(age, department, emp_id, name);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return age == other.age && Objects.equals(department, other.department) && emp_id == other.emp_id
				&& Objects.equals(name, other.name);
	}
	
	

}
