package pageObjectDemo;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

public class PageFactorySearchEngineTest {

    private static WebDriver driver;
		
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.setProperty("webdriver.gecko.driver", "resources/geckodriver");
		driver = new FirefoxDriver();
	}
	
	@Test
	public void testGoogle() throws Exception {
		PageFactorySearchEngine googlePage = PageFactory.initElements(driver, PageFactorySearchEngine.class);
		googlePage.PageFactoryUseGoogle(driver);
		googlePage.search("Mateusz Miotk");
		assertTrue(googlePage.assertTitle());
	}
	
	@Test
	public void testDuckDuckGo() throws Exception {
		PageFactorySearchEngine duckPage = PageFactory.initElements(driver, PageFactorySearchEngine.class);
		duckPage.PageFactoryUseDuckDuckGo(driver);
		duckPage.search("Mateusz Miotk");
		assertTrue(duckPage.assertTitle());
	}
	
	@Test
	public void testBing() throws Exception {
		PageFactorySearchEngine bingPage = PageFactory.initElements(driver, PageFactorySearchEngine.class);
		bingPage.PageFactoryUseBing(driver);
		bingPage.search("Mateusz Miotk");
		assertTrue(bingPage.assertTitle());
	}
}
