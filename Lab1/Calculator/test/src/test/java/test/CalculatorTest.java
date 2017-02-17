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
	public void CalculatorAddTest() {
		int result = test.add(5, 5);
		assertNotNull(result);
		assertEquals(10 , result);
	}
	
	public void CalculatorAddTest2() {
		int result = test.add(-5, 5);
		assertNotNull(result);
		assertEquals(0 , result);
	}

	@Test
	public void CalculatorSubTest() {
		int result = test.sub(15, 12);
		assertNotNull(result);
		assertEquals(3 , result);
	}
	
	@Test
	public void CalculatorMultiTest() {
		int result = test.multi(5, 4);
		assertNotNull(result);
		assertEquals(20, result);
	}
	
	@Test
	public void CalculatorDivTest() {
		int result = test.div(10, 2);
		assertNotNull(result);
		assertEquals(5, result);
	}
	
	@Test
	public void CalculatorGreaterTrueTest() {
		boolean result = test.greater(10, 2);
		assertNotNull(result);
		assertEquals(true, result);
	}
	
	@Test
	public void CalculatorGreaterLessTest() {
		boolean result = test.greater(2, 5);
		assertNotNull(result);
		assertEquals(false, result);
	}
	
	@Test(expected = ArithmeticException.class)
	public void CalculatorShouldThrowException() {
		test.div(10, 0);
	}
	
	@After
	public void after(){
		test = null;
	}
}
