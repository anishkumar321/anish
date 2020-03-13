package com.jUnit;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class ComplexAddTest {

		private ComplexAdd c1;
		private ComplexAdd c2;
		
		public ComplexAddTest(int r1,int r2,int i1,int i2) {
			c1=new ComplexAdd(r1,i1);
			c2=new ComplexAdd(r2,i2);
		}
		@Parameterized.Parameters
		public static Collection testAdd() {
			System.out.println("INSIDE COLLECTION");
			return Arrays.asList(new Object [][]{
				{2,3,3,2},{1,1,1,1},{2,3,1,2}
			});
		}
		@Before
		public void before() {
			System.out.println("before()");
		}
		@After
		public void after() {
			System.out.println("after()");
		}
		@Test
		public void testComplexAdd() {
			System.out.println("TESTING");
			ComplexAdd ca = null;
			assertEquals(ca,c1.add(c2));
		}
}
