

import static org.junit.Assert.assertEquals;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.gargoylesoftware.htmlunit.BrowserVersion;

public class GoogleHtmlUnitTest {
	
	private static HtmlUnitDriver driver;
	
	boolean isElelmentPresent(By by)
	{
		boolean result = false;
		
		try
		{
			driver.findElement(by);
			result = true;
		}catch(Exception e)
		{
			result = false;
		}
		
		return result;
	}

	@BeforeClass
	public static void setUp() throws Exception {
		driver = new HtmlUnitDriver(BrowserVersion.FIREFOX_52);
	}

	@Test
	public void testTitlePage() {
		driver.get("https://google.com/");
    	assertEquals("Google", driver.getTitle());
	}
	
	@Test
	public void testClick(){
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.name("q")));

		assertEquals(isElelmentPresent(By.name("qqqqq")), false);
	}
	
	@AfterClass
	public static void tearDown() throws Exception {
		driver.quit();
	}

}
