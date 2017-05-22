package pageObjectDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PageFactoryGoogle2 {
  
  //Nie uzywamy FindByElement !!!
	
  private WebElement user_email;
  private WebElement user_password;
  public WebDriver driver;
  
  public PageFactoryGoogle2(WebDriver driver){
	  this.driver = driver;
	  driver.get("https://fast-shore-79390.herokuapp.com/");
  }
  
  public void typeEmail(String text) throws Exception{
	  user_email.sendKeys(text);
  }
  
  public void typePassword(String text) throws Exception{
	  user_password.sendKeys(text);
  }
  
  public void enter() throws Exception{
	  user_password.submit();
  }
  
  public boolean assertTitle() throws Exception{
	  WebElement n = driver.findElement(By.className("alert"));
	  if (n != null)
		  return true;
	  else
		  return false;
	}
  
}
