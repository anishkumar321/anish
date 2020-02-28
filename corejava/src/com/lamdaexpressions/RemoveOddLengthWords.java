package com.lamdaexpressions;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;

public class RemoveOddLengthWords {

	public static void main(String[] args) throws Exception{
		List<String> words=new ArrayList<String>();
		words.add("ABC");
		words.add("XY");
		words.add("HJKK");
		words.add("PQR");
		words.add("GHBCD");
		words.add("ABC");
		Predicate<String> pr=(String s)->
		{if(s.length()%2!=0)
			return false;
		else
			return true;};
			
			words.removeIf(pr);	
			Iterator<String> itr=words.iterator();
			while(itr.hasNext()) {
				String name = itr.next();
				System.out.println(name);
			}
			
			

	}

}
