package JBehaveExample.ExampleJBehave;

import org.jbehave.core.annotations.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class CalculatorStepsRunnerTest{
	
	private Calculator test;
	private int inputA;
	private int inputB;
	private int output;
	
	@Parameters
    public static Collection<Object[]> data() {
        Object[][] c = {
        		{1,2,3}, {0,0,0}
   		};
        return  Arrays.asList(c);
    }
    
    @Before
    public void setup()
    {
    	test = new Calculator();
    }
    
	public CalculatorStepsRunnerTest(int a, int b, int c){
		inputA = a;
		inputB = b;
		output = c;
	}
      	
	@Test
	public void calcTest(){
		assertEquals(output, test.add(inputA, inputB));
	}
	
	@After
	public void cleanup()
	{
		test = null;
	}
}