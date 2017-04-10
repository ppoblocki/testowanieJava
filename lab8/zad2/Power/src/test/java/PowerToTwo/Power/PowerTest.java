package PowerToTwo.Power;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

public class PowerTest {
	
	private Power power;

	@Before
	public void setUp() throws Exception {
		power = new Power();
	}
	
	@Test
	public void testPowerOne() {
		assertThat(power.powers(0,1),hasItems(1,2));
	}
	
	@Test
	public void testPowerOneContains() {
		assertThat(power.powers(0,1),contains(2,1));
	}
	
	
	@Test
	public void testPowerOneSize() {
		assertThat(power.powers(0,1),hasSize(2));
	}

	@After
	public void tearDown() throws Exception {
		power = null;
	}


}
