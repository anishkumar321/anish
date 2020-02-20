package com.threading;
//is a relationship
public class PingPongTest implements Runnable{
	
	Thread t1,t2;
	public PingPongTest() {
		t1=new Thread(this);
		t2=new Thread(this);
		t1.setName("PING");
		t2.setName("PONG");
		t1.start();
		t2.start();
	}

	public static void main(String[] args) {
		new PingPongTest();

	}
	@Override
	public void run() {
		Thread currentThread=Thread.currentThread();
		if(currentThread.getName().equals("PING")) {
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
		else if(currentThread.getName().equals("PONG")) {
			for(int i=0;i<20;i++) {
				System.out.println("\t PONG");
			try {
				Thread.sleep(300);
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			}
	}

}
}
