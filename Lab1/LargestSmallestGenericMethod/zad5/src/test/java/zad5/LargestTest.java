package zad5;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class LargestTest 
{
	private Largest test;
	
	@Before
	public void before(){
		test = new Largest();
	}
	
	@Test
	public void findMaxForPositiveIntegersAsc()
	{
		Integer[] intArray = { new Integer(5), new Integer(10), new Integer(15), new Integer(20) };
		assertNotNull(test.max(intArray));
		assertEquals((int)test.max(intArray), 20);
	}
	
	@Test
	public void findMaxForPositiveIntegersDesc()
	{
		Integer[] intArray = { new Integer(5), new Integer(4), new Integer(3), new Integer(2) };
		assertNotNull(test.max(intArray));
		assertEquals((int)test.max(intArray), 5);
	}
	
	@Test
	public void findMaxForPositiveIntegersRandom()
	{
		Integer[] intArray = { new Integer(5), new Integer(10), new Integer(0), new Integer(1) };
		assertNotNull(test.max(intArray));
		assertEquals((int)test.max(intArray), 10);
	}
	
	@Test
	public void findMaxForNegativeIntegersAsc()
	{
		Integer[] intArray = { new Integer(-5), new Integer(-3), new Integer(-1) };
		assertNotNull(test.max(intArray));
		assertEquals((int)test.max(intArray), -1);
	}
	
	@Test
	public void findMaxForNegativeIntegersDesc()
	{
		Integer[] intArray = { new Integer(-1), new Integer(-3), new Integer(-5) };
		assertNotNull(test.max(intArray));
		assertEquals((int)test.max(intArray), -1);
	}
	
	@Test
	public void findMaxForNegativeIntegersRandom()
	{
		Integer[] intArray = { new Integer(-1), new Integer(-5), new Integer(-2) };
		assertNotNull(test.max(intArray));
		assertEquals((int)test.max(intArray), -1);
	}
	
	@Test
	public void findMaxForIntegers()
	{
		Integer[] intArray = { new Integer(-1), new Integer(0), new Integer(1) };
		assertNotNull(test.max(intArray));
		assertEquals((int)test.max(intArray), 1);
	}

	@Test
	public void findMaxForDouble()
	{
		Double[] doubleArray = { new Double(-0.11), new Double(0.0), new Double(1.1), new Double(1.12), new Double(1.11) };
		assertNotNull(test.max(doubleArray));
		assertEquals((double)test.max(doubleArray), 1.12, 0);
	}
	
	@Test
	public void findMaxForDouble2()
	{
		Double[] doubleArray = { new Double(1), new Double(0.0), new Double(2), new Double(1.555), new Double(1.55) };
		assertNotNull(test.max(doubleArray));
		assertEquals((double)test.max(doubleArray), 2, 0);
	}
	
	
	@After
	public void after(){
		test = null;
	}

}
