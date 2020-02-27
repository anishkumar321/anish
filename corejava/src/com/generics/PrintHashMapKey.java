package com.generics;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class PrintHashMapKey {

	public static void main(String[] args) {
		Map<Integer,String> hash=new HashMap<Integer,String>();
		hash.put(1,"Anish");
		hash.put(2,"Rahul");
		hash.put(3,"Raghav");
		hash.put(4,"Rajesh");
		printMapKeyValues(hash);
		

	}
	public static  void printMapKeyValues(Map<? extends Number,?> hm) {
		
		Set<? extends Number> keys = hm.keySet();
        for(Number key: keys){      //to print the set
            System.out.println(key);
        }
	}

}
