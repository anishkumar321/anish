package com.collections;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

class Date {
	int day;
	int month;
	int year;
	
	public Date(int day, int month, int year) {
		super();
		this.day = day;
		this.month = month;
		this.year = year;
	}
	@Override
	public boolean equals(Object ob) {
		Date d=(Date) ob;
		if(this.day==d.day && this.month==d.month)
			return true;   //removes duplicacy
		else
			return false;
	}
	@Override
	public int hashCode() {
		return 45;
	}
	@Override
	public String toString() {
		return "Date [day=" + day + ", month=" + month + ", year=" + year + "]";
	}
	
}
public class HashMapDateEmployeeq4 {

	public static void main(String[] args) {
		testHashMap();
	}
	private static void testHashMap() {
		Map<Date, String> hm = 
				new HashMap<Date, String>();
		Date d1=new Date(26,12,1997);
  		Date d2=new Date(26,12,2000);
		Date d3=new Date(17,9,1997);
		
		
		hm.put(d1, "Anand");
		hm.put(d2, "Bipin");
		hm.put(d3, "Chandan");
	
		String name = hm.get(d1);
		System.out.println(name);
		String name2 = hm.get(d2);
		System.out.println(name2);
		String name3 = hm.get(d3);
		System.out.println(name3);
		/*Iterator<Date> itr = hm.keySet().iterator();
		while(itr.hasNext()) {
			Date d = itr.next();
			System.out.println(d);
		}*/
		
	}
}

