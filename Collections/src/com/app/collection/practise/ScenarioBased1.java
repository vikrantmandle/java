package com.app.collection.practise;

import java.util.ArrayList;
import java.util.List;

import com.app.collection.custom.MyArrayList;
import com.app.collection.practise.data.Employee;

public class ScenarioBased1 {
	
	public static void main(String[] args) {
		Employee emp1 = new Employee(1, "Aman", 30, "HR");
		Employee emp5=new Employee(1, "Aman", 30, "HR");
		System.out.println(emp1.equals(emp5));
		System.out.println(emp1.hashCode());
		System.out.println(emp5.hashCode());
		
		
		List<Integer> numbers= new ArrayList<Integer>();
		//Checking custom ArrayList implementation
		MyArrayList list = new MyArrayList();
		
		list.add(5);
		list.add("test");
		list.remove(0);
	
		System.out.println(list);
	}

}
