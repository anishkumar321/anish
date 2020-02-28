package com.lamdaexpressions;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

public class FirstLetterOfStringq5 {

	public static void main(String[] args) {
		List<String> words=new ArrayList<String>();
		words.add("abc");
		words.add("bcd");
		words.add("cdf");
		words.add("efg");
		words.add("fgh");
		words.add("ghj");
		StringBuilder sb=new StringBuilder("");
		Iterator<String> itr=words.iterator();
		while(itr.hasNext()) {
			sb.append(itr.next().charAt(0));
		}
		Consumer<StringBuilder> consumer=(StringBuilder s)->System.out.println(s);
		consumer.accept(sb);
	}

}
