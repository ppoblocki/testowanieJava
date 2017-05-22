package pageObjectDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageFactorySearchEngine {
  
  //Nie uzywamy FindByElement !!!
	
  private WebElement q;
  public WebDriver driver;
  
  private String[] errorText = {"Nie znaleziono wyników dotyczących zapytania", 
		  "nie została odnaleziona", "No"};
  
  public PageFactorySearchEngine(){
	  
  }
  
  public void PageFactoryUseGoogle(WebDriver driver){
	  this.driver = driver;
	  driver.get("http://www.google.com/");
  }
  
  public void PageFactoryUseDuckDuckGo(WebDriver driver){
	  this.driver = driver;
	  driver.get("http://duckduckgo.com/");
  }
  
  public void PageFactoryUseBing(WebDriver driver){
	  this.driver = driver;
	  driver.get("http://bing.com/");
  }
  
  public void search(String text) throws Exception{
	  q.sendKeys(text);
	  q.submit();
	  WebDriverWait wait = new WebDriverWait(driver, 10);
	  wait.until(ExpectedConditions.presenceOfElementLocated(By.name("q")));
  }
  
  public boolean assertTitle() throws Exception{
		Boolean result;
		
		if (driver.getPageSource().contains(errorText[0]) || driver.getPageSource().contains(errorText[1]) || driver.getPageSource().contains(errorText[2]))
			result = true;
		else
			result = false;
		
		System.out.println(driver.getTitle());
		return(result);
	}
  
  
}
