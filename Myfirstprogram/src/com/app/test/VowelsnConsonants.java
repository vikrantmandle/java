package com.app.test;

import java.util.Scanner;

public class VowelsnConsonants {
	

public static void main(String[] args) {
		
	Scanner sc = new Scanner (System.in);
	System.out.println("Enter a String");
	String input = sc.nextLine();
	int vowels =0;
	int consonants=0;
	for (char c: input.toCharArray()) {
		if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')){
			if("aeiou".contains(String.valueOf(c))){
				vowels++;
			}else {
				consonants++;
			}
		}
	}
	System.out.println("Total vowels -> "+vowels + "consonants -> "+consonants);
}

}
