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
	
	@After
	public void after(){
		test = null;
	}
}
