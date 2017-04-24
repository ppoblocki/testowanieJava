package CustomMatcher.Matcher;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

public class PersonMatcher {
  public static Matcher<Person> lastLetterLowercase(final String name){
	  return new TypeSafeMatcher<Person>(){

		public void describeTo(final Description description) {
			description.appendText("expected result from getFirstName() -> last Letter Lowercase: true");
		}

		@Override
		public boolean matchesSafely(Person person) {
			
			return Character.isLowerCase(person.getFirstName().charAt(person.getFirstName().length() - 1));			
		}
		
		public void describeMismatchSafely(final Person person, final Description mismatchDescription) {
			mismatchDescription.appendText("was ").appendValue(Character.isLowerCase(person.getFirstName().charAt(person.getFirstName().length() - 1)));
		}
	  };
  }
}
