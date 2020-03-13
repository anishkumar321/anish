package com.jUnit;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({CalculatorTest.class,PrimeNumberTest.class,RandomNumberTest.class,ComplexAddTest.class})
public class AllTestsSuite {

}
