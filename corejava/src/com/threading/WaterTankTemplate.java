package com.threading;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.WindowEvent;
import java.awt.event.WindowAdapter;

public class WaterTankTemplate extends Frame {
	private int y=200;
	private int height=200;
	private int percent = 70;
	public WaterTankTemplate() {
		super("Ball game");
		setBackground(Color.ORANGE);
		setSize(500, 500);
		setVisible(true);
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}
	
	public void paint(Graphics g) {
		g.drawRect(150, 100, 200, 300);
		g.setColor(Color.RED);
		//g.fillRect(150, 200, 200, 200);
		g.fillRect(150, y, 200, height);
		g.drawString(percent + "%", 380, 200);
	}

	public static void main(String[] args) {
		WaterTankTemplate waterTank = new WaterTankTemplate();
		waterTank.setSize(500, 500);
		waterTank.setVisible(true);
		waterTank.new WaterManagement("CONTROLLER");
		waterTank.new WaterManagement("INLET");
		waterTank.new WaterManagement("OUTLET");
	}

	class WaterManagement implements Runnable {
		Thread t;
		public WaterManagement(String threadName) {
			t = new Thread(this, threadName);
			t.start();
		}
		public void run() {
			if(Thread.currentThread().getName().equals("OUTLET")) {
				for(int i=0;i<40;i++) {
					y = y + 5;
					height = height - 5;
					repaint();
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				
			}
			else if(Thread.currentThread().getName().equals("INLET")) {	
				/*for(int i=40;i>0;i--) {
					y=y-5;
					height = height + 5;
					repaint();
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}*/
				
			}
			else if(Thread.currentThread().getName().equals("CONTROLLER")) {
				
			}
		}
	}}
