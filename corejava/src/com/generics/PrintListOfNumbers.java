package com.generics;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PrintListOfNumbers {

	public static void main(String[] args) {
		List<Integer> list1=new ArrayList<Integer>();
		list1.add(5);
		list1.add(10);
		list1.add(15);
		list1.add(20);
		

		List<Double> list2=new ArrayList<Double>();
		list2.add(5.2);
		list2.add(10.1);
		list2.add(15.5);
		list2.add(20.6);
		/*List<String> list=new ArrayList<String>();
		list.add("ABC");
		list.add("PQR");*/  //it will throw error cause printnos list is of type number.
		PrintNos(list1);
		PrintNos(list2);
	}
	public static void PrintNos(List<? extends Number> list) {
		Iterator<?> itr=list.iterator();
		while(itr.hasNext()) {
			Number n=(Number) itr.next();
			System.out.println(n);
		}
	}

}
