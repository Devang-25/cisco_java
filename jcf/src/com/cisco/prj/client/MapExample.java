package com.cisco.prj.client;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapExample {

	public static void main(String[] args) {
		// key is String, value is Integer type
		// initial size is 10, loadfactor is 70% ==> if 70% of buckets are full , capacity
		// doubles and re-hashing happens
		Map<String, Integer> books = new HashMap<String, Integer>(10, 0.7f);
		
		books.put("Java", 1200);
		books.put("Angular", 3200);
		books.put("React", 800);
		books.put("JavaScript", 1200);
		
		books.put("React", 980); // over writes old entry
		
		System.out.println(books.get("Angular"));
		
		books.forEach((k,v) -> System.out.println(k + " : " + v));
		
		System.out.println("*********");
		
		Set<String> keys = books.keySet();
		
		for(String key : keys) {
			System.out.println(key);
			if(key.startsWith("Java")) {
				System.out.println(books.get(key));
			}
		}
		
	}

}
