package CustomMatcher.Matcher;

import static org.hamcrest.MatcherAssert.*;
import static CustomMatcher.Matcher.PersonMatcher.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PersonMatcherTest {
	
	Person test;

	@Before
	public void setUp() throws Exception {
		test = new Person();
	}

	@After
	public void tearDown() throws Exception {
		test = null;
	}

	@Test
	public void testMatcherCorrect() {
		test.setFirstName("Justin");
		assertThat(test, lastLetterLowercase("Justin"));
	}
	
	@Test
	public void testMatcherInCorrect() {
		test.setFirstName("alA");
		assertThat(test, lastLetterLowercase("alA"));
	}
}
