package PowerToTwo.Power;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.jbehave.core.annotations.*;
import org.jbehave.core.model.ExamplesTable;

public class TabularSteps{
	
	ExamplesTable table;
	ArrayList<String> numbers;
	
	@Given("the numbers: $ranksTable")
	public void givenTheNumbersnumber(ExamplesTable ranksTable){
		  this.table = ranksTable;
		  this.numbers = toNumbers(ranksTable);
		  System.out.println(numbers);
	}
	
	private ArrayList<String> toNumbers(ExamplesTable table){
		ArrayList<String> result = new ArrayList<String>();
		for (Map<String, String> row: table.getRows()){
			result.add(row.get("left"));
			result.add(row.get("right"));
		}
		return result;
	}
	
	@Then("powers are: $table")
	public void thenPowersAndSizeIssizepowers(ExamplesTable table){
		Power test = new Power();
		List<Integer> result = test.powers(Integer.parseInt(this.numbers.get(0)), Integer.parseInt(this.numbers.get(1)));
		System.out.println("=== O U T P U T ===");
		System.out.println(result);
		System.out.println("===================");
	}
	
}
