package com.threading;

public class PingPongTong extends Thread {

	public static void main(String[] args) {
		
		Runnable r1 = new Runnable() {
			public void run() {
				for(int i=0;i<20;i++) {
					System.out.println("PING");
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
				for(int i=0;i<20;i++) {
					System.out.println("\tPONG");
					try {
						Thread.sleep(300);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		};
		Runnable r3 = new Runnable() {
			public void run() {
				for(int i=0;i<20;i++) {
					//for(;;) {             //to check daemon in infinite loop
					System.out.println("\t      TONG");
					try {
						Thread.sleep(700);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		};
		
		Thread t1 = new Thread(r1);
		Thread t2 = new Thread(r2);
		Thread t3 = new Thread(r3);
		t3.setDaemon(true);  //setting Daemon
		t1.start();
		t2.start();
		t3.start();
	}
}