package pageObjectDemo;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

public class PageObjectFindByGoogleTest {

    private static WebDriver driver;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.setProperty("webdriver.gecko.driver", "resources/geckodriver");
		driver = new FirefoxDriver();
	}
	
	@Test
	public void test() throws Exception {
		PageFactorySearchEngine googlePage = PageFactory.initElements(driver, PageFactorySearchEngine.class);
		googlePage.search("Mateusz Miotk");
		assertTrue(googlePage.assertTitle());
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		driver.quit();
	}

}
