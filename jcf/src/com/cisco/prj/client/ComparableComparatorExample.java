package com.cisco.prj.client;

import java.util.Arrays;

public class ComparableComparatorExample {

	public static void main(String[] args) {
		String[] names = { "Clooney", "Brad", "Angelina", "Lee" };

		Arrays.sort(names);
		for (String name : names) {
			System.out.println(name);
		}

		System.out.println("*******");
		// Anonymous class
//		Comparator<String> strComp = new Comparator<String>() {
//			@Override
//			public int compare(String o1, String o2) {
//				return o1.length() - o2.length();
//			}
//		};
//		
//		
//		Arrays.sort(names, strComp);

		Arrays.sort(names, (s1,s2) -> s1.length() - s2.length()); 
		for (String name : names) {
			System.out.println(name);
		}
	}

}
