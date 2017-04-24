package CustomMatcher.Matcher;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

public class OSMatcher 
{
	
  public static Matcher<OperatingSystem> is128bit(final int bits){
	  return new TypeSafeMatcher<OperatingSystem>(){

		public void describeTo(final Description description) {
			
			description.appendText("expected result from getNbOfBits() -> is128bit: true");
		}

		@Override
		public boolean matchesSafely(OperatingSystem os) {
			boolean result;
			
			if (os.getNbOfBits() == 128)
				result = true;
			else
				result = false;
			
			return result;
		}
		
		public void describeMismatchSafely(final OperatingSystem os, final Description mismatchDescription) {
			mismatchDescription.appendText("was ").appendValue(this.matchesSafely(os));
		}
	  };
  }
  
  public static Matcher<OperatingSystem> wasReleasedIn(final int year){
	  return new TypeSafeMatcher<OperatingSystem>(){

		public void describeTo(final Description description) {
			
			description.appendText("expected result from getReleaseYear() -> wasReleasedIn: true");
		}

		@Override
		public boolean matchesSafely(OperatingSystem os) {
			boolean result;
			
			if (os.getReleaseYear() == year)
				result = true;
			else
				result = false;
			
			return result;
		}
		
		public void describeMismatchSafely(final OperatingSystem os, final Description mismatchDescription) {
			mismatchDescription.appendText("was ").appendValue(this.matchesSafely(os));
		}
	  };
  }
  
  public static Matcher<OperatingSystem> hasVersion(final String version){
	  return new TypeSafeMatcher<OperatingSystem>(){

		public void describeTo(final Description description) {
			
			description.appendText("expected result from getVersion() -> hasVersion(): true");
		}

		@Override
		public boolean matchesSafely(OperatingSystem os) {
			boolean result;
			
			if (os.getVersion() == version)
				result = true;
			else
				result = false;
			
			return result;
		}
		
		public void describeMismatchSafely(final OperatingSystem os, final Description mismatchDescription) {
			mismatchDescription.appendText("was ").appendValue(this.matchesSafely(os));
		}
	  };
  }
  
  
}
