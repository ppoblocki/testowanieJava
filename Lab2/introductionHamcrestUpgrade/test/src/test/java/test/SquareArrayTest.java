package test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import java.util.Arrays;
import java.util.List;

import org.hamcrest.core.IsEqual;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SquareArrayTest {
	
	private SquareArray array; 

	@Before
	public void setUp() throws Exception {
		array = new SquareArray();
	}
	
	@Test
	public void getArray(){
		array.setList(Arrays.asList(1,2,3));
		List <Integer> tempList = array.getList();
		assertThat(tempList,contains(1,2,3));
	}
	
	@Test
	public void increseArray() {
		array.setList(Arrays.asList(1,2,3));
		array.increaseListByOne(array.getList());
		assertThat(array.getList(), contains(2,3,4));
	}
	
	@Test(expected=NullPointerException.class)
	public void increaseArrayForEmpty() {
		array.setList(null);
		array.increaseListByOne(array.getList());
	}
	
	@Test
	public void findVal() {
		array.setList(Arrays.asList(1,2,3));
		array.increaseListByOne(array.getList());
		assertThat(array.findValue(2), is(true));
	}
	
	@Test
	public void findValFail() {
		array.setList(Arrays.asList(1,2,3));
		array.increaseListByOne(array.getList());
		assertThat(array.findValue(0), is(false));
	}
	
	
	@Test(expected=NullPointerException.class)
	public void findValForEmptyArray() {
		array.setList(null);
		array.increaseListByOne(array.getList());
	}

	@After
	public void tearDown() throws Exception {
		array = null;
	}
	
}
