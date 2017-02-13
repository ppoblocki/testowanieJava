package test;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class LargestTest 
{
	private Largest test;
	
	@Before
	public void before()
	{
		test = new Largest();
	}
	
	@Test
	public void findMaxTestAsc()
	{
		int array[] = {0,1,2,3,4};
		int result = test.findMax(array);
		assertNotNull(result);
		assertEquals(4, result);	
	}
	
	@Test
	public void findMaxTestDesc()
	{
		int array[] = {4,3,2,1,0};
		int result = test.findMax(array);
		assertNotNull(result);
		assertEquals(4, result);	
	}
	
	@Test
	public void findMaxTestSameNumbers()
	{
		int array[] = {1,1,1,1,1};
		int result = test.findMax(array);
		assertNotNull(result);
		assertEquals(1, result);	
	}
	
	@Test
	public void findMaxTestRandomNumbers()
	{
		int array[] = {0,5,8,3,1,6,5,8,9,10,4,2,1,15,0,5,4};
		int result = test.findMax(array);
		assertNotNull(result);
		assertEquals(15, result);	
	}
	
	@Test
	public void findMaxTestNegativeAsc()
	{
		int array[] = {-3, -2, -1, 0, 1, 2, 3};
		int result = test.findMax(array);
		assertNotNull(result);
		assertEquals(3, result);	
	}
	
	@Test
	public void findMaxTestNegativeDesc()
	{
		int array[] = {2,1,0,-1,-2};
		int result = test.findMax(array);
		assertNotNull(result);
		assertEquals(2, result);	
	}
	
	@Test
	public void findMaxTestOneNumber()
	{
		int array[] = {5};
		int result = test.findMax(array);
		assertNotNull(result);
		assertEquals(5, result);	
	}
	
	@After
	public void after()
	{
		test = null;
	}
}
