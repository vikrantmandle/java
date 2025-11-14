package com.app.test;

public class StringPrograms {

	public static void main(String[] args) {
		
		String s1= "Test";
		//intern checks if pool values exists or not if yes returns pool reference if no
		//creates a pool value and then returns it reference
		String s2 = new String ("Test").intern();
		String s3 = "Test";
		String s4 = s1.concat(" World");
		String s5 = "Test World";
		String s6 ="TEST";
		s1=s1.toUpperCase();

		System.out.println("Checking Equality s1==s2->"+(s1==s2));
		System.out.println("Checking Equality s1==s3->"+(s1==s3));
		System.out.println("Checking Equality s4==s5->"+(s4==s5));
		System.out.println("Checking Equality s6==s1->"+(s6==s1));
	}

}
