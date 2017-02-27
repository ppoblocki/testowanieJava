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
	
	@Test
	public void showTest()
	{
		test.setXforAll();
		String plansza = "1 1 1 1 1 \n1 1 1 1 1 \n1 1 1 1 1 \n1 1 1 1 1 \n1 1 1 1 1 \n";
		assertEquals(test.show(), plansza);
	}
	
	@Test
	public void showClear()
	{
		test.setXforAll();
		test.clear();
		String plansza = "0 0 0 0 0 \n0 0 0 0 0 \n0 0 0 0 0 \n0 0 0 0 0 \n0 0 0 0 0 \n";
		assertEquals(test.show(), plansza);
	}
	
	@After
	public void after()
	{
		test = null;
	}	
}
