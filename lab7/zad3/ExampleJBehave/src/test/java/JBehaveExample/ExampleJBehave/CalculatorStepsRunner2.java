package JBehaveExample.ExampleJBehave;

import org.jbehave.core.annotations.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class CalculatorStepsRunner2{
	
	private Calculator test;
	private int inputA;
	private int inputB;
	private int output;
	
	@Given("I have got created calculator")
	public void givenNewCalculator(){
		test = new Calculator();
	}
	@When("I will add number <inputA> and num <inputB>")
	public void whenMultyplying(@Named("inputA") int number, @Named("inputB") int num){
		 test.setLeft(number);
		 test.setRight(num);
	}
	@Then("after adding I will get output <output>")
	public void thenOutput(@Named("output") int output){
		 assertEquals(output, test.add(test.getLeft(), test.getRight()));
	}
	
	@AfterScenario(uponType=ScenarioType.EXAMPLE, uponOutcome=AfterScenario.Outcome.SUCCESS)
	public void afterEachExampleScenario() {
	    System.out.println("DONE!");
	}
	
	@AfterScenario(uponType=ScenarioType.EXAMPLE, uponOutcome=AfterScenario.Outcome.FAILURE)
	public void afterFailedScenario() {
	    System.out.println("FAIL!");
	}
}