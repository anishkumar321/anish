package com.threading;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.WindowEvent;

import java.awt.event.WindowAdapter;

public class WaterTankTemplate extends Frame {
	public static int y=400;
	public static int height=0;
	public static int percent = 70;
	public WaterTankTemplate() {
		super("Ball game");
		setBackground(Color.CYAN);
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
		Thread inlet=new Thread(new Runnable() {
			public void run() {
				   
					while(true) {
						 
						y = y - 5;
						height = height + 5;
						waterTank.repaint();
						try {
							Thread.sleep(100);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
			});
Thread outlet =new Thread(new Runnable() {
	public void run() {
		
		for(;;) {
			y = y + 5;
			height = height - 5;
			waterTank.repaint();
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
		
	}
		});
Thread controller =new Thread(new Runnable() {
	
	
	@Override
	public void run() {
		while(true)
		{
		if(y<210)
		{	inlet.suspend();
			outlet.resume();
			
			
		}
		else
		{	outlet.suspend();
			inlet.resume();
			
			
		}
		}
	}
});
inlet.start();
outlet.start();
controller.setDaemon(true);
controller.start();
	
	}
	


}