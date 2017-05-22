package pageObjectDemo;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageFactoryGoogleTest2 {

    private static WebDriver driver;
		
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.setProperty("webdriver.gecko.driver", "resources/geckodriver");
		driver = new FirefoxDriver();
	}
	
	@Test
	public void test() throws Exception {
		
		PageFactoryGoogle2 googlePage = PageFactory.initElements(driver, PageFactoryGoogle2.class);
		googlePage.typeEmail("ala@makota.pl");
		googlePage.typePassword("abc123");
		googlePage.enter();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.className("alert")));
		assertTrue(googlePage.assertTitle());
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		driver.quit();
	}
}
