package test;

import java.util.List;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class FriendshipsTest
{
	private Friendships test;
	
	@Before
	public void bafore()
	{
		test = new Friendships();
	}
	
	@After
	public void after()
	{
		test = null;
	}
	
	@Test
	public void test1()
	{
		test.makeFriends("Jarek", "Tomek");
		System.out.println(test.getFriendsList("Jarek"));
		//System.out.println(test.areFriends("Jarek", "Tomek"));
	}
	
}
