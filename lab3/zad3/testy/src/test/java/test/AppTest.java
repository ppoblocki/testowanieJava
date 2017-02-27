package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class AppTest 
{
	private App test;
	
	@Before
	public void before()
	{
		test = new App();

	}
	
	@Test(expected=NullPointerException.class)
	public void nullArrayTest()
	{
		String[] stuff = null;
		assertEquals(test.search(stuff, "test", 0 , 0), -2);
	}
	
	@Test
	public void successSearch1()
	{
        String[] stuff = {"apple", "car", "ice cream", "mildew", "xylophone"};
		assertEquals(test.search(stuff,"ice cream",0,stuff.length-1), 2);
	}
	
	@Test
	public void successSearch2()
	{
        String[] stuff = {"apple", "car", "ice cream", "mildew", "xylophone"};
		assertEquals(test.search(stuff,"apple",0,stuff.length-1), 0);
	}
	
	@Test
	public void successSearch4()
	{
        String[] stuff = {"apple", "car", "ice cream", "mildew", "xylophone"};
		assertEquals(test.search(stuff,"xylophone",0,stuff.length-1), 4);
	}
	
	@Test
	public void failSearch1()
	{
        String[] stuff = {"apple", "car", "ice cream", "mildew", "xylophone"};
		assertEquals(test.search(stuff,"Mejwen",0,stuff.length-1), -1);
	}
	
	@Test
	public void failSearch2()
	{
        String[] stuff = {"apple", "car", "ice cream", "mildew", "xylophone"};
		assertEquals(test.search(stuff,"car apple NANANA Batman",0,stuff.length-1), -1);
	}
	
	@Test
	public void similarElements()
	{
        String[] stuff = {"A", "AA", "AAA", "AAAA"};
		assertEquals(test.search(stuff,"A",0,stuff.length-1), 0);
	}
	
	@Test
	public void similarElements2()
	{
        String[] stuff = {"A", "AA", "AAA", "AAAA"};
		assertEquals(test.search(stuff,"AAA",0,stuff.length-1), 2);
	}
	
	@After
	public void after()
	{
		test = null;
	}	
}
