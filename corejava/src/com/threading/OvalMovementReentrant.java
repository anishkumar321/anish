package com.threading;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.WindowEvent;
import java.awt.event.WindowAdapter;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock; 

public class OvalMovementReentrant extends Frame implements Runnable{
	ReentrantLock lock;
	Condition condition; 
	Thread t1, t2, t3;
	//modify y
	int count=0;
	int y1 = 400, y2 = 400, y3 = 400;
	public OvalMovementReentrant() {
		 lock=new ReentrantLock();
		 condition=lock.newCondition();
		 
		setBackground(Color.black);
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
	
	
	public void function() throws InterruptedException
	{
		/*synchronized(this)
		{
			if (count<3)
			{
				wait();
			}
			else if(count==3)
			{
				count=0;
				notifyAll();
			}
				
		}*/
		
		
		try
		{
			lock.lock();
			if (count<3)
			{
				condition.await();

			}
			else if(count==3)
			{
				count=0;
				condition.signalAll();
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally {lock.unlock();}
		
		 
				 
		
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
		Frame mf = new OvalMovementReentrant();
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
				//System.out.println("y1: "+y1);
				repaint();
				if (y1==100)
					{
					count++;
					try {
						function();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println("");
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
					{
					count++;
					try {
						function();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;}
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
					count++;
					try {
						function();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println("");
					break;			
					
					}
				try
				{
					Thread.sleep(200);
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
				{
					count++;
					try {
						function();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;
					}
				try
				{
					Thread.sleep(200);
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
					count++;
					try {
						function();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println("");
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
					{
					count++;
					try {
						function();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
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
		}		
		}
		
	}	
}