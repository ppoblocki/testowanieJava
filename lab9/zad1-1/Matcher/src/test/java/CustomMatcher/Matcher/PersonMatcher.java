package CustomMatcher.Matcher;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

public class PersonMatcher {
  public static Matcher<Person> firstLetterUppercase(final String name){
	  return new TypeSafeMatcher<Person>(){

		public void describeTo(final Description description) {
			description.appendText("expected result from getFirstName() -> first Letter Uppercase: true");
		}

		@Override
		public boolean matchesSafely(Person person) {
			
			return Character.isUpperCase(person.getFirstName().charAt(0));			
		}
		
		public void describeMismatchSafely(final Person person, final Description mismatchDescription) {
			mismatchDescription.appendText("was ").appendValue(Character.isUpperCase(person.getFirstName().charAt(0)));
		}
	  };
  }
}
