package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import test.Calculator;

public class CalculatorTest {
	
	private Calculator test;
	
	@Before
	public void before(){
		test = new Calculator();
	}

	@Test
	public void CalculatorAddTest0() {
		double result = test.add(0, 0.1);
		assertNotNull(result);
		assertEquals(0.1, result, 0);
	}
	
	@Test
	public void CalculatorAddTest() {
		double result = test.add(5.1, 5.2);
		assertNotNull(result);
		assertEquals(10.3, result, 0);
	}
	
	@Test
	public void CalculatorAddTest1() {
		double result = test.add(5.5, 5.55);
		assertNotNull(result);
		assertEquals(11.05, result, 0.01);
	}
	
	public void CalculatorAddTest2() {
		double result = test.add(-5.1, 5);
		assertNotNull(result);
		assertEquals(-0.1 , result, 0);
	}
	
	@Test
	public void CalculatorSubTest() {
		double result = test.sub(15, 12);
		assertNotNull(result);
		assertEquals(3.0 , result, 0);
	}
	
	@Test
	public void CalculatorMultiTest() {
		double result = test.multi(5.5, 4);
		assertNotNull(result);
		assertEquals(22, result, 0);
	}
	
	@Test
	public void CalculatorDivTest() {
		double result = test.div(10, 2);
		assertNotNull(result);
		assertEquals(5.0, result, 0);
	}
	
	@Test
	public void CalculatorGreaterTrueTest() {
		boolean result = test.greater(1.9, 1.8999);
		assertNotNull(result);
		assertEquals(true, result);
	}
	
	@Test
	public void CalculatorGreaterLessTest() {
		boolean result = test.greater(1.99999, 1.9999999);
		assertNotNull(result);
		assertEquals(false, result);
	}
	
	@Test(expected = ArithmeticException.class)
	public void CalculatorShouldThrowException() {
		test.div(0.0001, 0);
	}
	
	@After
	public void after(){
		test = null;
	}
}
