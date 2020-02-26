package com.collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Vector;

public class CollectionsTest {

	public static void main(String[] args) {
		testTreeMap();
	}

	private static void testTreeMap() {
		Map<String, String> treeMap = new TreeMap<String, String>();
		treeMap.put("A", "Anand");
		treeMap.put("EE", null);
		treeMap.put("B", "Bipin");
		treeMap.put("D", "Dawood");
		treeMap.put("C", "Chandan");
		
		Iterator<String> itr = treeMap.keySet().iterator();
		while(itr.hasNext()) {
			String name = itr.next();
			System.out.println(name);
		}
	}
	private static void testTreeSet() {
		TreeSet<AB> treeSet = new TreeSet<AB>();
		treeSet.add(new AB(50));
		treeSet.add(new AB(35));
		treeSet.add(new AB(88));
		treeSet.add(new AB(100));
		
		Iterator<AB> itr = treeSet.iterator();
		while(itr.hasNext()) {
			AB a = itr.next();
			System.out.println(a);
		}
	}
	private static void testHashSet() {
		Set<String> hset = new HashSet<String>();
		hset.add("ABC");
		hset.add("XYZ");
		hset.add("PQR");
		hset.add("XYZ");
		
		Iterator<String> itr = hset.iterator();
		while(itr.hasNext()) {
			String name = itr.next();
			System.out.println(name);
		}
	}
	private static void testHashMap() {
		Map<String, String> ht = 
				new HashMap<String, String>();
		ht.put("A", "Anand");
		ht.put("B", "Bipin");
		ht.put("C", "Chandan");
		ht.put("D", "Dawood");
		ht.put("E", null);
		
		String name = ht.get("D");
	}
	private static void testArrayList() {
		List<String> arrayList = new ArrayList<String>();
		arrayList.add("ABC");
		arrayList.add("PQR");
		arrayList.add("XYZ");
		
		arrayList.remove(1);
		Iterator<String> itr = arrayList.iterator();
		while(itr.hasNext()) {
			String name = itr.next();
			System.out.println(name);
		}
		for(int i=0;i<arrayList.size();i++) {
			System.out.println(arrayList.get(i));
		}
	}
	private static void testVector() {
		Vector<String> vec = new Vector<String>();
		vec.add("ABC");
		vec.add("PQR");
		vec.add("XYZ");
		
		vec.remove(1);
		Iterator<String> itr = vec.iterator();
		while(itr.hasNext()) {
			String name = itr.next();
			System.out.println(name);
		}
		for(int i=0;i<vec.size();i++) {
			System.out.println(vec.get(i));
		}
	}
	
	private static void testLinkedList() {
		LinkedList<String> list = new LinkedList<String>();
		list.add("ABC");
		list.add("PQR");
		list.add("XYZ");
		
		list.remove(1);
		Iterator<String> itr = list.iterator();
		while(itr.hasNext()) {
			String name = itr.next();
			System.out.println(name);
		}
		for(int i=0;i<list.size();i++) {
			System.out.println(list.get(i));
		}
	}
}

class AB implements Comparable<AB>{
	int x;
	public AB(int x) {
		this.x = x;
	}
	@Override
	public int compareTo(AB ab) {
		if(this.x > ab.x) {
			return 1;
		}
		else if (this.x < ab.x){
			return -1;
		}
		else {
			return 0;
		}
	}
	@Override
	public String toString() {
		return "AB [x=" + x + "]";
	}
	
}