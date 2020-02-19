package com.exception;

public class TestExceptions {

	public static void main(String[] args) {
		int x=5,y=0;
		try {
			System.out.println("Enter try");
			int div=x/y;
			System.out.println("Exit try");
		}
		catch(ArithmeticException e){
			System.out.println("Enter catch");
			e.printStackTrace();
			System.out.println("Exit catch");
		}
		catch(Exception e) {
			System.out.println("Enter exception catch");
			e.printStackTrace();
			System.out.println("Exception catch");
		}
		System.out.println("Exit main");

	}

}
