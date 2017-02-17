package zad5;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SmallestTest 
{
	private Smallest test;
	
	@Before
	public void before()
	{
		test = new Smallest();
	}
	
	@Test
	public void findMinForPositiveIntegersAsc()
	{
		Integer[] intArray = { new Integer(5), new Integer(10), new Integer(15), new Integer(20) };
		assertNotNull(test.min(intArray));
		assertEquals((int)test.min(intArray), 5);
	}
	
	@Test
	public void findMinForPositiveIntegersDesc()
	{
		Integer[] intArray = { new Integer(5), new Integer(4), new Integer(3), new Integer(2) };
		assertNotNull(test.min(intArray));
		assertEquals((int)test.min(intArray), 2);
	}
	
	@Test
	public void findMinForPositiveIntegersRandom()
	{
		Integer[] intArray = { new Integer(5), new Integer(10), new Integer(0), new Integer(1) };
		assertNotNull(test.min(intArray));
		assertEquals((int)test.min(intArray), 0);
	}
	
	@Test
	public void findMinForNegativeIntegersAsc()
	{
		Integer[] intArray = { new Integer(-5), new Integer(-3), new Integer(-1) };
		assertNotNull(test.min(intArray));
		assertEquals((int)test.min(intArray), -5);
	}
	
	@Test
	public void findMinForNegativeIntegersDesc()
	{
		Integer[] intArray = { new Integer(-1), new Integer(-3), new Integer(-5) };
		assertNotNull(test.min(intArray));
		assertEquals((int)test.min(intArray), -5);
	}
	
	@Test
	public void findMinForNegativeIntegersRandom()
	{
		Integer[] intArray = { new Integer(-1), new Integer(-5), new Integer(-2) };
		assertNotNull(test.min(intArray));
		assertEquals((int)test.min(intArray), -5);
	}
	
	@Test
	public void findMinForIntegers()
	{
		Integer[] intArray = { new Integer(-1), new Integer(0), new Integer(1) };
		assertNotNull(test.min(intArray));
		assertEquals((int)test.min(intArray), -1);
	}

	@Test
	public void findMinForDouble()
	{
		Double[] doubleArray = { new Double(-0.11), new Double(0.0), new Double(1.1), new Double(1.12), new Double(1.11) };
		assertNotNull(test.min(doubleArray));
		assertEquals((double)test.min(doubleArray), -0.11, 0);
	}
	
	@Test
	public void findMinForDouble2()
	{
		Double[] doubleArray = { new Double(1), new Double(0.0), new Double(2), new Double(1.555), new Double(1.55) };
		assertNotNull(test.min(doubleArray));
		assertEquals((double)test.min(doubleArray), 0, 0);
	}

	@Test
	public void findMinForCharAsc()
	{
		Character[] charArray = { new Character('a'), new Character('b'), new Character('c') };
		assertNotNull(test.min(charArray));
		assertEquals((char)test.min(charArray), 'a');
	}
	
	@Test
	public void findMinForCharDesc()
	{
		Character[] charArray = { new Character('c'), new Character('b'), new Character('a') };
		assertNotNull(test.min(charArray));
		assertEquals((char)test.min(charArray), 'a');
	}
	
	@Test
	public void findMinForString()
	{
		String[] stringArray = { new String("Ala"), new String("ma"), new String("kota") };
		assertNotNull(test.min(stringArray));
		assertEquals(test.min(stringArray).toString(), "Ala");
	}
	
	@Test
	public void findMinForString2()
	{
		String[] stringArray = { new String("A"), new String("AA"), new String("AAA") };
		assertNotNull(test.min(stringArray));
		assertEquals(test.min(stringArray).toString(), "A");
	}
	
	@After
	public void after()
	{
		test = null;
	}
}
