package com.collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FailFastFailSafeq8 extends Thread{

	public static void main(String[] args) {
		
		List<String> arrayList = new ArrayList<String>();
		Runnable r1 = new Runnable() {
			public void run() {
				for(int i=0;i<10;i++) {
					arrayList.add("ABC");
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}	
		};
		Runnable r2 = new Runnable() {
			public void run() {
				Iterator<String> itr = arrayList.iterator();
				while(itr.hasNext()) {
					String name = itr.next();
					System.out.println(name);
				
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		};
		Thread tAdd=new Thread(r1);
		Thread tIterator=new Thread(r2);
		tAdd.start();
		tIterator.start();
	}
}


