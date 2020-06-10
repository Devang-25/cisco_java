package com.cisco.prj.client;

import java.util.Arrays;
import java.util.List;

public class StreamExample {

	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(45,10,52,12,30,11,9);
		
		// use filter/forEach to print even numbers
		numbers.stream()
			.filter(no -> no % 2 == 0)
			.forEach(no -> System.out.println(no));
		
		// each element multiple by 2 ==> MAP
		
		System.out.println("******");
		numbers.stream()
			.map(no -> no * 2)
			.forEach(no -> System.out.println(no));
		
		
		// Task: double all elements which are > 25 and print
		// use filter/forEach to print even numbers
				numbers.stream()
					.filter(no -> no > 25)
					.map(no -> no *2)
					.forEach(no -> System.out.println(no));
		
	}

}
