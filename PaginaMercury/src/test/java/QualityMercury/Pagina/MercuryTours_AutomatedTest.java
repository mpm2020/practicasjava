package QualityMercury.Pagina;



import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;



public class MercuryTours_AutomatedTest {
	
	private WebDriver driver;

	

	By registerLinkLocator = By.linkText("REGISTER");
	By registerPageLocator = By.xpath("//img[@src='images/mast_register.gif']");
	

	By usernameLocator = By.id("email");
	By passwordLocator = By.name("password");
	By confirmPasswordLocator = By.cssSelector("input[name='confirmPassword']");
	
	By registerBtnLocator = By.name("submit");
	
	By userLocator = By.name("userName");
	By passLocator = By.name("password");
	
	By singInBtnLocator = By.name("submit");
	
	By homePageLocator = By.xpath("//img[@src='images/mast_flightfinder.gif']");

	@Before
	public void setUp() throws Exception {
	
		System.setProperty("webdriver.chrome.driver", "..\\PaginaMercury\\Drivers\\chromedriver.exe");

		driver = new ChromeDriver();

		driver.manage().window().maximize(); 
	
		driver.get("https://demo.guru99.com/test/newtours/");	
		
		
		
	}
	

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}
	
	
	@Test
	public void registerUser() throws InterruptedException {
	

		
		driver.findElement(registerLinkLocator).click();

		
		Thread.sleep(2000); 
		
		
		if(driver.findElement(registerPageLocator).isDisplayed()) {
			driver.findElement(usernameLocator).sendKeys("yas1");
			driver.findElement(passwordLocator).sendKeys("123");
			driver.findElement(confirmPasswordLocator).sendKeys("123");
			
			driver.findElement(registerBtnLocator).click();
		}
		else 
		{
			System.out.println("Register pages was not found");
		}
		
		
		List<WebElement> fonts = driver.findElements(By.tagName("font"));
		
		assertEquals("Note: Your user name is yas1.",fonts.get(5).getText());

	}
	
	
	@Test
	public void singIn() throws InterruptedException {
		
		if(driver.findElement(userLocator).isDisplayed()) {
			driver.findElement(userLocator).sendKeys("yas1");
			driver.findElement(passLocator).sendKeys("123");
			driver.findElement(singInBtnLocator).click();
			Thread.sleep(2000);
			
			assertTrue(driver.findElement(homePageLocator).isDisplayed());
		}
		else
		{
			System.out.println("username textbox was not present");
		}
			
		
	}
	

}
