package JBehaveExample.ExampleJBehave;

import org.jbehave.core.annotations.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class CalculatorStepsRunner2{
	
	private Calculator test;
	
	@Given("a value x by 5")
	public void given(){
		test = new Calculator();
		test.setLeft(5);
	}
	@Given("a value y by 10")
	public void givenAValueYBy10(){
		test.setRight(10);
	}
	@Then("sum of value x and y is 15")
	@Alias("sum of value x and y becomes 15")
	public void thenOutput(){
		 assertEquals(15, test.add(test.getLeft(), test.getRight()));
	}
}