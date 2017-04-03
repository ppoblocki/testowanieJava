package JBehaveExample.ExampleJBehave;

import org.jbehave.core.annotations.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class CalculatorStepsRunner2{
	
	private Calculator test;
	
	@When("the number {one|two|three} is $val")
	public void when(int val){
		test = new Calculator();
		test.setLeft(val);
	}
	@Then("the value is lower than 5")
	public void then()
	{
		assertTrue(test.getLeft() < 5);
	}
}