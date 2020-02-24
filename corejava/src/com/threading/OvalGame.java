package com.threading;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.WindowEvent;
import java.awt.event.WindowAdapter;

public class OvalGame extends Frame implements Runnable{

	Thread t1, t2, t3;
	//modify y
	int y1 = 400, y2 = 400, y3 = 400;
	public OvalGame() {
		super("Oval game");
		setBackground(Color.CYAN);
		setSize(500, 500);
		setVisible(true);
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		
		t1=new Thread(this);
		t2=new Thread(this);
		t3=new Thread(this);

		
		t1.setName("red");
		t2.setName("green");
		t3.setName("blue");
		t1.start();
		t2.start();
		t3.start();
	}
		
	public void paint(Graphics g) {
		g.setColor(Color.RED);
		g.fillOval(100, y1, 50, 50);
		g.setColor(Color.GREEN);
		g.fillOval(200, y2, 50, 50);
		g.setColor(Color.BLUE);
		g.fillOval(300, y3, 50, 50);
	}
	
	

	public static void main(String[] args) {
		Frame mf = new OvalGame();
		mf.setSize(500, 500);
		mf.setVisible(true);		
		
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		Thread myThread=Thread.currentThread();
		long t=100;
		if(myThread.getName().equals("red"))
		{
			
			while (true)
			{
				while(true)
				{
					y1-=10;
					repaint();
					if (y1==100)
					{
						System.out.println("break");
						break;			
					
					}
					try
					{
						Thread.sleep(100);
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}			
							
				}			
				while(true)
				{
					y1+=10;
					repaint();
					if (y1==400)
					break;
					try
					{
						Thread.sleep(100);
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}								
				}
			}
				
		}
		
		else if(myThread.getName().equals("green"))
		{
			
			while (true)
			{
				while(true)
			{
				y2-=10;
				repaint();
				if (y2==100)
					{
					System.out.println("break");
					break;			
					
					}
				try
				{
					Thread.sleep(10);
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}			
							
			}			
			while(true)
			{
				y2+=10;
				repaint();
				if (y2==400)
					break;
				try
				{
					Thread.sleep(10);
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}								
				
			}
		}
			
			
		}
		
		if(myThread.getName().equals("blue"))
		{
			
			while (true)
			{
				while(true)
			{
				y3-=10;
				repaint();
				if (y3==100)
					{
					System.out.println("break");
					break;			
					
					}
				try
				{
					Thread.sleep(50);
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}			
							
			}			
			while(true)
			{
				y3+=10;
				repaint();
				if (y3==400)
					break;
				try
				{
					Thread.sleep(50);
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}								
				
			}
		}
			
			
		}
		
	}
		
		
		
		
	
}
	