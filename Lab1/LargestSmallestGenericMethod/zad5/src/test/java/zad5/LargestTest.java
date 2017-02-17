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
	public void findMaxForPositiveIntegers()
	{
		Integer[] intArray = { new Integer(5), new Integer(10), new Integer(0), new Integer(1) };
		assertEquals((int)test.max(intArray), 10);
	}
	
	@After
	public void after(){
		test = null;
	}

}
