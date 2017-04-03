package JBehaveExample.ExampleJBehave;

import org.jbehave.core.annotations.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class CalculatorStepsRunner2{
	
	private Calculator test;
	
	@When("the {apple|tomato|desk} cost $price")
	public void when(int price){
		test = new Calculator();
		test.setLeft(price);
	}
	@Then("total price is greater than 0.0")
	public void then()
	{
		assertTrue(test.getLeft() > 0.0);
	}
}