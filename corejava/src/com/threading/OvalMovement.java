package com.threading;

import java.awt.*;
import java.awt.event.*;

public class OvalMovement extends Frame implements Runnable {

	int y1 = 400, y2 = 400, y3 = 400;
	boolean b1Reached, b2Reached, b3Reached;
	
	Thread t1, t2, t3;
	
	public OvalMovement() {
		super("Oval Game");
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		t1 = new Thread(this, "Ball_1");
		t2 = new Thread(this, "Ball_2");
		t3 = new Thread(this, "Ball_3");
		t1.start();t2.start();t3.start();
	}
	
	public synchronized void waitForOtherBalls() {
		if (b1Reached && b2Reached && b3Reached) {
			b1Reached = false;
			b2Reached = false;
			b3Reached = false;
			notifyAll();
		}
		else {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void run() {
		Thread currentThread = Thread.currentThread();
		if (currentThread.getName().equals("Ball_1")) {
			for(;;) {
				for(int i=400; i>100; i = i-5) {
					y1 = i;
					repaint();
					try { Thread.sleep(100); } catch(Exception e) {}
					if (i < 10)
						break;
				}
				b1Reached = true;
				waitForOtherBalls();
				for(int i=100; i<=400; i = i+5) {
					y1 = i;
					repaint();
					try { Thread.sleep(100); } catch(Exception e) {}
					if (i > 395)
						break;
				}
				b1Reached = true;
				waitForOtherBalls();
			}
		}

		else if (currentThread.getName().equals("Ball_2")) {
			for(;;) {
				for(int i=400; i>100; i = i-5) {
					y2 = i;
					repaint();
					try { Thread.sleep(200); } catch(Exception e) {}
					if (i < 10)
						break;
				}
				b2Reached = true;
				waitForOtherBalls();
				for(int i=100; i<=400; i = i+5) {
					y2 = i;
					repaint();
					try { Thread.sleep(200); } catch(Exception e) {}
					if (i > 395)
						break;
				}
				b2Reached = true;
				waitForOtherBalls();
			}
		}
		else if (currentThread.getName().equals("Ball_3")) {
			for(;;) {
				for(int i=400; i>100; i = i-5) {
					y3 = i;
					repaint();
					try { Thread.sleep(300); } catch(Exception e) {}
					if (i < 10)
						break;
				}
				b3Reached = true;
				waitForOtherBalls();
				for(int i=100; i<=400; i = i+5) {
					y3 = i;
					repaint();
					try { Thread.sleep(300); } catch(Exception e) {}
					if (i > 395)
						break;
				}
				b3Reached = true;
				waitForOtherBalls();
			}
		}
	}
	
	public void paint(Graphics g) {
		g.setColor(Color.RED);
		g.fillOval(100, y1, 50, 50);
		g.setColor(Color.GREEN);
		g.fillOval(200, y2, 50, 50);
		g.setColor(Color.BLUE);
		g.fillOval(300, y3, 50, 50);
	}
	
	public static void main(String args[]) throws Exception{
		Frame om = new OvalMovement();
		om.setSize(600, 600);
		om.setBackground(Color.CYAN);
		om.setVisible(true);
	}
}