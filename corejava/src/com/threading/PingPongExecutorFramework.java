package com.threading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PingPongExecutorFramework {

	public static void main(String[] args) {
		ExecutorService executor = Executors.newFixedThreadPool(2);
		Runnable runnable = new Runnable() {
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
		Runnable runnable2 = new Runnable() {
			public void run() {
				for(int i=0;i<20;i++) {
					System.out.println("\t PONG");
					try {
						Thread.sleep(200);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
			};
		executor.execute(runnable);
		executor.execute(runnable2);
		executor.shutdown();
	}

}
