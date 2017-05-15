package webdemo.seleniumDemo;

import static org.junit.Assert.*;

import java.util.List;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoogleTest {
	
	private static WebDriver driver;

	@BeforeClass
	public static void setUp() throws Exception {
		//Od wersji selenium 3.0 samo FirefoxDriver nie wystarcza
		//Należy dodać sterownik geckodriver
		//Do pobrania tutaj: https://github.com/mozilla/geckodriver/releases
		System.setProperty("webdriver.gecko.driver", "resources/geckodriver");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void testTitlePage() {
		driver.get("https://www.google.pl");
	}
	
	@Test
	public void registrationTest()
	{
		String password = "ppap123123";
		String login = "ppap";
		String email = "ppap@ppap.pl"; 
		
		// REJESTRACJA
		driver.navigate().to("https://www.imdb.com/ap/register?clientContext=133-0158968-2597124&openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.imdb.com%2Fap-signin-handler&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.assoc_handle=imdb_us&openid.mode=checkid_setup&siteState=eyJyZWRpcmVjdFRvIjoiaHR0cHM6Ly93d3cuaW1kYi5jb20vP3JlZl89bG9naW4ifQ&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0&&tag=imdbtag_reg-20");
		
		driver.findElement(By.id("ap_customer_name")).sendKeys(login);
		driver.findElement(By.id("ap_email")).sendKeys(email);
		driver.findElement(By.id("ap_password")).sendKeys(password);
		driver.findElement(By.id("ap_password_check")).sendKeys(password);
		driver.findElement(By.id("continue")).click();
		
		// WYLOGOWANIE
		driver.findElement(By.id("nblogout")).click();
		
		// LOGOWANIE
		driver.navigate().to("https://www.imdb.com/ap/signin?clientContext=133-0158968-2597124&openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.imdb.com%2Fap-signin-handler&prevRID=EFXR2BPFYB8AS2C119EF&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.assoc_handle=imdb_us&openid.mode=checkid_setup&siteState=eyJyZWRpcmVjdFRvIjoiaHR0cDovL3d3dy5pbWRiLmNvbS9pbWRicGlja3MvYnVkZHktY29wLWR1b3MvcmcxMDcwOTYzNDU2P2ltYWdlaWQ9cm0xMTIzNTk2Mjg4JnBmX3JkX209QTJGR0VMVVVOT1FKTkwmcGZfcmRfcD0yOTk4NTYxNzgyJnBmX3JkX3I9MURYNlc1UUYyUzFBUUI4TkY1QkgmcGZfcmRfcz1jZW50ZXItMiZwZl9yZF90PTE1MDYxJnBmX3JkX2k9aG9tZXBhZ2UmcmVmXz1sb2dpbiJ9&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&pageId=imdb_us&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0");
		driver.findElement(By.id("ap_email")).sendKeys(email);
		driver.findElement(By.id("ap_password")).sendKeys(password);
		driver.findElement(By.id("signInSubmit")).click();
	}
	
	//@Test
	/*public void testClick(){
		WebDriverWait wait = new WebDriverWait(driver, 10);
		driver.findElement(By.id("search_form_input_homepage")).sendKeys("Mateusz Miotk");
		driver.findElement(By.id("search_button_homepage")).click();
		wait.until(ExpectedConditions.titleIs("Mateusz Miotk na DuckDuckGo"));
		assertEquals(driver.getTitle(), "Mateusz Miotk na DuckDuckGo");
	}*/
	
	
	@AfterClass
	public static void tearDown() throws Exception {
		driver.quit();
	}

}
