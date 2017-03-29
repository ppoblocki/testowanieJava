package JBehaveExample.ExampleJBehave;

import org.jbehave.core.annotations.*;
import static org.junit.Assert.*;
public class CalculatorStepsRunner2{
	
	private Calculator test;
	
	@Given("I have got created calculator")
	public void givenNewCalculator(){
		test = new Calculator();
	}
	@When("I will multiply number $2 and num $2")
	public void whenMultyplying(int number, int num){
		 test.setLeft(number);
		 test.setRight(num);
	}
	@Then("after multiplying I will get output $4")
	public void thenOutput(int output){
		 assertEquals(output, test.multiply(test.getLeft(), test.getRight()));
	}
}