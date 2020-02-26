package com.collections;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class HashsetLinkedHashsetq2 {

	public static void main(String[] args) {
	testHashSet();
	testLinkedHashSet();
	}	
	private static void testHashSet() {
		Set<String> hset = new HashSet<String>();
		hset.add("ABC");
		hset.add("XYZ");
		hset.add("PQR");
		hset.add("XYZ");
		System.out.println("Testing HashSet");	
		Iterator<String> itr = hset.iterator();
		while(itr.hasNext()) {
			String name = itr.next();
			System.out.println(name);
		}
	}
	private static void testLinkedHashSet() {
		Set<String> lhset = new LinkedHashSet<String>();
		lhset.add("ABC");
		
		lhset.add("PQR");
		lhset.add("XYZ");
		
		System.out.println("Testing LinkedHashSet");
		Iterator<String> it = lhset.iterator();
		while(it.hasNext()) {
			String name = it.next();
			System.out.println(name);
		}
	}
	

}
