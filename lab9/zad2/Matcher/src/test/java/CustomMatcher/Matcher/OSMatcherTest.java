package CustomMatcher.Matcher;

import static org.hamcrest.MatcherAssert.*;

import static org.hamcrest.Matchers.*;

import static CustomMatcher.Matcher.OSMatcher.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class OSMatcherTest {
	
	OperatingSystem test;

	@Before
	public void setUp() throws Exception {
		test = new OperatingSystem();
	}

	@After
	public void tearDown() throws Exception {
		test = null;
	}

	@Test
	public void is128() {
		test.setNbOfBits(128);
		assertThat(test, is128bit(128));
	}
	
	@Test
	public void year() {
		test.setReleaseYear(2015);
		assertThat(test, wasReleasedIn(2015));
	}
	
	@Test
	public void version() {
		test.setVersion("beta");
		assertThat(test, hasVersion("beta"));
	}
	
	@Test
	public void allof() {
		test.setNbOfBits(128);
		test.setReleaseYear(2015);
		test.setVersion("beta");
		
		
		assertThat(test, allOf(is128bit(128), wasReleasedIn(2015), hasVersion("beta")));
	}
	
	@Test
	public void anyof() {
		test.setNbOfBits(129);
		test.setReleaseYear(2015);
		test.setVersion("beta");
		
		assertThat(test, anyOf(is128bit(129), wasReleasedIn(2015), hasVersion("beta")));
	}
}
