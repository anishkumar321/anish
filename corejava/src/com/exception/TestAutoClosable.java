package com.exception;

class A implements AutoCloseable{
	public A() {
		System.out.println("CONSTRUCTOR OF A");
	}
	public void disp() {
		System.out.println("HELLO WORLD");
	}
	
	@Override
	public void close() {
		System.out.println("closed");
	}
}
public class TestAutoClosable {

	public static void main(String[] args) {
		
		try(A a=new A()) {
			a.disp();
		}
		catch(Exception e) {
			e.printStackTrace();
		}

	}

}
