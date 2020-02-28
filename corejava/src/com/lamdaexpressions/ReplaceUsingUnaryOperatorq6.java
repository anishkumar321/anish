package com.lamdaexpressions;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.UnaryOperator;

public class ReplaceUsingUnaryOperatorq6 {

	public static void main(String[] args) {
		List<String> words=new ArrayList<String>();
		words.add("abc");
		words.add("xyz");
		words.add("Anish");
		words.add("Raj");
		UnaryOperator<String> unary=(String s)->s.toUpperCase();
		words.replaceAll(unary);
		Iterator<String> itr=words.iterator();
		while(itr.hasNext()) {
			String name = itr.next();
			System.out.println(name);
		}

	}

}
