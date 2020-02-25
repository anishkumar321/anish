package com.threading;

public class ResolveDeadLockTest {
	 
    public static void main(String[] args) {
        ResolveDeadLockTest test = new ResolveDeadLockTest();
 
        final A a = test.new A();
        final B b = test.new B();
 
        // Thread-1
        Runnable block1 = new Runnable() {
            public void run() {
                synchronized (a) {
                	System.out.println("A:> Got A's lock");
                    try {
                        // Adding delay so that both threads can start trying to
                        // lock resources
                    	System.out.println("A:> Sleeping inside monitor");
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("A:> Sleep over.. trying to acquire B's lock");
                    // Thread-1 have A but need B also
                    synchronized (b) {
                        System.out.println("In block 1");
                    }
                }
            }
        };
 
        // Thread-2
        Runnable block2 = new Runnable() {
            public void run() {
                System.out.println("\tB:>trying to acquire B's lock");
                synchronized (b) {
                	System.out.println("\tB:>Got B's lock");
                    // Thread-2 have B but need A also
                    System.out.println("\tB:>trying to acquire A's lock");
                    synchronized (a) {
                        System.out.println("In block 2");
                    }
                }
            }
        };
 
        new Thread(block1).start();
        new Thread(block2).start();
    }
 
    // Resource A
    private class A {}
 
    // Resource B
    private class B {}
}