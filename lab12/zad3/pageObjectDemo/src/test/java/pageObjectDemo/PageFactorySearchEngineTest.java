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
    private String errorString = "123123___123131kldklsfjdklsfjldjsfkldjsflkdjsflkdjsf;;;dsklfjdklsfjdklsjfkldskldklsfjdklsfjldjsfkldjsflkdjsflkdjsf;;;dsklfjdklsfjdklsjfklds";
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.setProperty("webdriver.gecko.driver", "resources/geckodriver");
		driver = new FirefoxDriver();
	}
	
	@Test
	public void testGoogle() throws Exception {
		PageFactorySearchEngine googlePage = PageFactory.initElements(driver, PageFactorySearchEngine.class);
		googlePage.PageFactoryUseGoogle(driver);
		googlePage.search(errorString);
		assertTrue(googlePage.assertTitle());
	}
	
	@Test
	public void testDuckDuckGo() throws Exception {
		PageFactorySearchEngine duckPage = PageFactory.initElements(driver, PageFactorySearchEngine.class);
		duckPage.PageFactoryUseDuckDuckGo(driver);
		duckPage.search(errorString);
		System.out.println(duckPage.assertTitle());
		assertTrue(duckPage.assertTitle());
	}
	
	@Test
	public void testBing() throws Exception {
		PageFactorySearchEngine bingPage = PageFactory.initElements(driver, PageFactorySearchEngine.class);
		bingPage.PageFactoryUseBing(driver);
		bingPage.search(errorString);
		assertTrue(bingPage.assertTitle());
	}
}
