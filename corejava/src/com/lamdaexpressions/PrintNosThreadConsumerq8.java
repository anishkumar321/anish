package com.lamdaexpressions;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
																				//incomplete
public class PrintNosThreadConsumerq8 extends Thread{

	public static void main(String[] args) {
		List<Integer> list= new ArrayList<Integer>();
		list.add(5);
		list.add(10);
		list.add(15);
		list.add(20);
		Consumer<Integer> consumer=(Integer i)->System.out.println(i);
		Runnable r1=()->{
			for(Number n:list) {
				consumer.(list.next());
			}
		};
		Thread t1=new Thread(r1);
		t1.start();
		

	}

}
