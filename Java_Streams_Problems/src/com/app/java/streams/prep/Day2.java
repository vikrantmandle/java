package com.app.java.streams.prep;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

class User {
    private String name;
    private List<String> emails;
    
    public User(String name,List<String>emails) {
		this.name=name;
		this.emails=emails;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getEmails() {
		return emails;
	}

	public void setEmails(List<String> emails) {
		this.emails = emails;
	}
    
}

class Product {
    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Product{name='" + name + "', price=" + price + "}";
    }
}


public class Day2 {

	public static void main(String[] args) {
		
		
		//problem 1
		List<User> users = List.of(
			    new User("Alice", List.of("alice@gmail.com", "alice@work.com")),
			    new User("Bob", List.of("bob@yahoo.com")),
			    new User("Charlie", List.of("charlie@gmail.com", "c@company.com"))
			);
		List<String>gmailUsers=users.stream().
							 flatMap(
						     emails->emails.getEmails().stream().
						     filter(n->n.endsWith("@gmail.com")))
							 .collect(Collectors.toList());
		gmailUsers.forEach(n->System.out.println(n));
		System.out.println("----------------------");
		
		//problem 2
		List<Employee> employee = Arrays.asList(new Employee("John","HR",100000),new Employee("Ben","IT",300000),
				new Employee("Julie","HR",450000),new Employee("William","Cyber security",50000),
				new Employee("Geralt","IT",190000),new Employee("James","IT",67000),
				new Employee("Cyril","Cyber security",80000),new Employee("Adam","HR",10000));
		
		Map<String, Optional<Employee>> filteredEmployee = employee.stream()
			    .collect(Collectors.groupingBy(
			        Employee::getDepartment,
			        Collectors.maxBy(Comparator.comparingLong(Employee::getSalary))
			    ));

		filteredEmployee.forEach((a,b)->System.out.println("{"+a+" "+b.orElse(null)));
		System.out.println("----------------------");
	
		//Problem 3
		List<Integer> list1 = List.of(1, 2, 3, 4, 5);
		List<Integer> list2 = List.of(4, 5, 6, 7, 8);
		
		List<Integer> commonElements=list1.stream().
									  filter(n->list2.contains(n)).distinct().collect(Collectors.toList());

		commonElements.forEach(System.out::println);
		System.out.println("----------------------");
		
		
		//Problem 4
		List<String> sentences = List.of(
			    "java stream api is powerful",
			    "java is versatile",
			    "stream api simplifies code"
			);
		
		Map<String, Long> wordCount = sentences.stream()
			    .flatMap(sentence -> Arrays.stream(sentence.split(" ")))
			    .collect(Collectors.groupingBy(
			        Function.identity(),
			        Collectors.counting()
			    ));

			wordCount.forEach((word, count) -> System.out.println(word + " => " + count));
			System.out.println("----------------------");
		
		
		//Problem 5
		List<Product> products = List.of(new Product("Laptop", 85000),
			    new Product("Smartphone", 50000),
			    new Product("Earbuds", 5000),
			    new Product("Smartwatch", 15000),
			    new Product("Monitor", 15000),
			    new Product("Mouse", 3000)
			);

		
		List<Product> sortedProducts=products.stream().
				sorted(Comparator.comparing(Product::getPrice).thenComparing(Product::getName)).toList();
		
		sortedProducts.forEach(System.out::println);
	}	
	

}
