package com.threading;
//Annonymous Inner Class
public class PingPongTest3 extends Thread{
	
	public PingPongTest3(String threadName) {
		super.setName(threadName);
		super.start();
	}
	

	public static void main(String[] args) {
		

	
	Runnable r1=new Runnable() {
	public void run(){
			for(int i=0;i<20;i++) {
				System.out.println("PING");
			try {
				Thread.sleep(500);
			}
			catch(Exception e) { 
				e.printStackTrace();
			}
			}
	}
	};
	Runnable r2=new Runnable() {
		public void run(){
				for(int i=0;i<20;i++) {
					System.out.println("\t PONG");
				try {
					Thread.sleep(500);
				}
				catch(Exception e) {
					e.printStackTrace();
				}
				}
		}
		};
		Thread t1 = new Thread(r1);
		Thread t2 = new Thread(r2);
		t1.start();
		t2.start();
		
}
}
