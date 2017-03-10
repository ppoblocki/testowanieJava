package lab4.statek;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class StatekTest
{
	private Statek test;
	
	public enum Zwrot {
		N, S, E, W
	}
	
	@Before
	public void before()
	{
		test = new Statek();
	}
	
	@After
	public void after()
	{
		test = null;
	}
	
	@Test
	public void StatekTest_check_start_X()
	{
		assertEquals(3, test.x);
	}
	@Test
	public void StatekTest_check_start_Y()
	{
		assertEquals(6, test.y);
	}
	@Test
	public void StatekTest_check_start_zwrot()
	{
		Zwrot zwrot = Zwrot.N;
		assertEquals(zwrot, test.zwrot);
	}
}