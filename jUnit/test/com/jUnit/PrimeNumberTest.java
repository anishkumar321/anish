package com.jUnit;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class PrimeNumberTest {

	private PrimeNumber primeNumber;
	private int primeNo;
	public PrimeNumberTest(int primeNo) {
		this.primeNo = primeNo;
		System.out.println("Inside constructor: " + this.primeNo);
	}
	@Parameterized.Parameters
	public static Collection primeNumbers() {
		System.out.println("Inside primeNumbers collection");
		return Arrays.asList(new Object[]{
			2, 3, 7, 11, 13, 4	
		});
	}
	@Before
	public void initialize() {
		primeNumber = new PrimeNumber();
		System.out.println("Inside initialize()");
	}
	@Test
	public void testIsPrime() {
		System.out.println("Inside testIsPrime()");
		assertTrue(primeNumber.isPrime(this.primeNo));
	}

}
