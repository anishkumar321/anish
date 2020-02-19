package com.exception;

public class TestTryFinally {

	public static void main(String[] args) {
		try {
				int div=5/0;
		}
		/*catch(ArithmeticException e) {
			e.printStackTrace();
		}*/
		finally {
			
				System.out.println("Done");
				
		}

	}

}
