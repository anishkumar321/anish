package com.jUnit;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Collection;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
@RunWith(Parameterized.class)
public class RandomNumberTest {

	private RandomNumber randomNumber;
	private int num;
	public RandomNumberTest() {
	}	
	@Parameterized.Parameters
	public static Collection randomNumbers() {
		System.out.println("Inside randomNumbers collection");
		return Arrays.asList(new Object[][] {
			{},{},{},{}	
		});
	}
	@Before
	public void before() {
		randomNumber = new RandomNumber();
		System.out.println("before()");
	}
	@After
	public void after() {
		System.out.println("after()");
	}
	@Test
	public void testCreateRandom() {
		System.out.println("testCreateRandom()");
		assertTrue(randomNumber.createRandom()<=100);
	} 
}
