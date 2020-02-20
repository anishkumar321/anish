package com.threading;
//has a relationship
public class PingPongTest2 extends Thread{
	
	public PingPongTest2(String threadName) {
		super.setName(threadName);
		super.start();
	}
	

	public static void main(String[] args) {
		new PingPongTest2("PING");
		new PingPongTest2("PONG");

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
