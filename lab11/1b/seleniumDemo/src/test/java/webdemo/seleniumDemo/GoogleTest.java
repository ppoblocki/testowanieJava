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
		driver.get("http://www.google.pl/");
	}
	
	@Test
	public void gotoAllLinks()
	{
		// Pobierz linki
		List<WebElement> linki = new ArrayList<WebElement>();
		linki = driver.findElements(By.tagName("a"));
		
		int liczba = linki.size();
		int i = 0;
		
		System.out.println(linki.size());
		
		// Przejdz do każdego linku
		try{
			for(i = 0; i < liczba; i++){
				linki = driver.findElements(By.tagName("a"));
				if (linki.get(i).getAttribute("href").contains("google"))
					driver.navigate().to(linki.get(i).getAttribute("href"));
				else
					continue;

			}
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
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
