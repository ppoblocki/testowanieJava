package test;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class NWDTest 
{
	private NWD test;

	@Before
	public void before()
	{
		test = new NWD();
	}
	
	@Test
	public void NWDTest1()
	{
		int result = test.nwd(8, 4);
		assertThat(result, equalTo(4));
	}
	
	@Test
	public void NWDTest2()
	{
		int result = test.nwd(4, 4);
		assertThat(result, equalTo(4));
	}
	
	@Test
	public void NWDTest3()
	{
		int result = test.nwd(4, 4);
		assertThat(result, is(4));
	}
	
	@Test
	public void NWDTest4()
	{
		int result = test.nwd(5, 2);
		assertThat(result, is(1));
	}
		
	@After
	public void after()
	{
		test = null;
	}
	
}
