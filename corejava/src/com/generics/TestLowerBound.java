package com.generics;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TestLowerBound {

	public static void main(String[] args) {
		List<Integer> list1=new ArrayList<Integer>();
		addNumbers(list1);
		Iterator<?> itr=list1.iterator();
		while(itr.hasNext()) {
			Number n=(Number) itr.next();
			System.out.println(n);
		}
	}
	public static void addNumbers(List<? super Integer> list) {
		for (int i= 1; i<= 10; i++) {
			list.add(i);
		}
	}

}
