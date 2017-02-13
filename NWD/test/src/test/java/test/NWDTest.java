package test;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class NWDTest {
	
	private NWD test;

	@Before
	public void before(){
		test = new NWD();
	}
	
	@Test
	public void NWDShouldReturnValidOutput() {
		int result = test.nwd(15, 12);
		assertNotNull(result);
		assertEquals(3 , result);
	}
	
	@Test
	public void NWDForTwoSameArguments() {
		int result = test.nwd(4, 4);
		assertNotNull(result);
		assertEquals(4 , result);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void NWDForTwoNegativeArguments() {
		test.nwd(-2, -10);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void NWDForNegativeArgumentAndZero() {
		test.nwd(-2, 0);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void NWDForZeroAndNegativeArgument() {
		test.nwd(0, -10);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void NWDForZeroAndZero() {
		test.nwd(0, 0);
	}
	
	@After
	public void after(){
		test = null;
	}
}
