package com.jUnit;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

public class CalculatorTest {
		static Calculator c=null;
		@BeforeClass
		public static void beforeClass() {
			System.out.println("BEFORE CLASS");
			c=new Calculator();
		}
		
		@AfterClass
		public static void afterClass() {
			System.out.println("AFTER CLASS");	
		}
		
		@Before
		public void before() {
			System.out.println("BEFORE");
		}
		@After
		public void after() {
			System.out.println("AFTER");
		}
		
		@Test
		public void testDivide() {
			System.out.println("TESTING DIVIDE CASE 1");
			assertEquals(3,c.divide(15, 5));
		}
		@Test(expected=ArithmeticException.class)
		public void testDivide2() {
			System.out.println("TESTING DIVIDE CASE 2");
			assertEquals("INFINTE",5,c.divide(15, 0));
		}
		@Ignore
		public void testDivide3() {
			System.out.println("TESTING DIVIDE CASE 3");
			assertEquals(5,c.divide(15, 0));
		}
		
		
}
