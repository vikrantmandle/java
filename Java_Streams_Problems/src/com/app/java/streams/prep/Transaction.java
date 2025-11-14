package com.app.java.streams.prep;

import java.util.List;

public class Transaction {

	private long id;
	private String category;
	private int budget;
	private String status;
	
	public Transaction(String category, int budget) {
		this.category=category;
		this.budget=budget;
	}
	
	public Transaction(String category, int budget,long id,String status) {
		this.category=category;
		this.budget=budget;
		this.status=status;
		this.id=id;
	}
	
	public static List<Transaction> populateDefaultTransactions(){
		List<Transaction> transactions = List.of(
			    new Transaction("GROCERY", 2000,1,"SUCCESS"),
			    new Transaction("ELECTRONICS", 8000,2,"SUCCESS"),
			    new Transaction("GROCERY", 1500,3,"FAILED"),
			    new Transaction("CLOTHING", 4000,4,"INPROGRESS"),
			    new Transaction("GROCERY", 200,5,"SUCCESS"),
			    new Transaction("CLOTHING", 5000,6,"SUCCESS"),
			    new Transaction("ELECTRONICS", 9000,7,"SUCCESS")
				);
		
		return transactions;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getBudget() {
		return budget;
	}

	public void setBudget(int budget) {
		this.budget = budget;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
