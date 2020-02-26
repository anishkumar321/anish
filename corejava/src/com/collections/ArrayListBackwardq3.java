package com.collections;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class ArrayListBackwardq3 {

	public static void main(String[] args) {
		testArrayList();

	}
	private static void testArrayList() {
		List<String> arrayList = new ArrayList<String>();
		arrayList.add("ABC");
		arrayList.add("PQR");
		arrayList.add("XYZ");
		
		ListIterator<String> itr = arrayList.listIterator(arrayList.size());
		while(itr.hasPrevious()) {
			String name = itr.previous();
			System.out.println(name);
		}
		/*for(int i=0;i<arrayList.size();i++) {
			System.out.println(arrayList.get(i));
		}*/
	}

}
