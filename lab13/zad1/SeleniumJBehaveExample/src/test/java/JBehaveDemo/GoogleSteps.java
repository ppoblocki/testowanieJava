package JBehaveDemo;


import static org.junit.Assert.*;
import org.jbehave.core.annotations.*;
import org.jbehave.web.selenium.WebDriverProvider;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
public class GoogleSteps{
	
	private WebDriverProvider driver;
	private WebElement q;
	private Wait<WebDriver> wait;
	
	public GoogleSteps(WebDriverProvider driver){
		super();
		this.driver = driver;
	}
	
	@Given("google test site")
	public void givenGoogleTestSite(){
		 driver.get().get("https://fast-shore-79390.herokuapp.com/users/sign_in");
		 wait = new WebDriverWait(driver.get(), 10);
	}
	
	@When("I send email and password")
	public void whenISendKeysMateuszMiotk(){
		 q = driver.get().findElement(By.id("user_email"));
		 q.sendKeys("radek@wp.pl");
		 q = driver.get().findElement(By.id("user_password"));
		 q.sendKeys("abc123");
		 q.submit();
		 wait.until(ExpectedConditions.titleContains("PinTab!"));
	}
	
	@Then("title of page is equal PinTab!")
	public void thenTitleOfPageIsEqualMateuszMiotkSzukajWGoogle(){
		 assertEquals(driver.get().getTitle(), "PinTab!"); 
		 driver.get().close();
	}
}