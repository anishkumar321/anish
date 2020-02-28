package com.lamdaexpressions;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;


public class KeyValuePairIntoStringq7 {

	public static void main(String[] args) {
		Map<String,String> hm=new HashMap<String,String>();
		hm.put("A","Anish");
		hm.put("B","Banita");
		hm.put("C","Chandan");
		hm.put("D","Debasish");
		hm.put("E","Epili");
		Consumer<StringBuilder> consumer=(StringBuilder s)->System.out.println(s);
		StringBuilder sb=new StringBuilder("");
		for(Map.Entry<String,String> mapentry:hm.entrySet()) {
			sb.append(mapentry.getKey()+mapentry.getValue());
		}
		consumer.accept(sb);

	}

}
