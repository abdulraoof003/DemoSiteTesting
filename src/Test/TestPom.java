package Test;

import java.util.NoSuchElementException;
import com.google.common.base.Function;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static java.util.concurrent.TimeUnit.SECONDS;
import static org.junit.Assert.*;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class TestPom {

	private WebDriver webDriver;
	private RegPage RegPage;
	private LoginPage LoginPage;
	
	private Wait<WebDriver> wait;


	@Before

	public void before() {

		webDriver = new ChromeDriver();
		RegPage = PageFactory.initElements(webDriver, RegPage.class);
		
		LoginPage = PageFactory.initElements(webDriver, LoginPage.class);

		wait = new FluentWait<WebDriver>(webDriver)
				 .withTimeout(30, SECONDS)
				 .pollingEvery(5, SECONDS)
				 .ignoring(NoSuchElementException.class);
		
	}

	@Test
	public void Test() throws InterruptedException{

	webDriver.navigate().to("http://TheDemoSite.co.uk");
		
	webDriver.manage().window().maximize();	
	
	webDriver.findElement(By.cssSelector("body small a:nth-child(6)")).click();
	

	RegPage.usernameInput("TestUser");
	
	
	RegPage.setpassWordInput("TestPass");
		

	//saving password
	webDriver.findElement(By.cssSelector("table  tbody  tr:nth-child(3) td:nth-child(2) p input")).click();
	

	WebElement foo = wait.until(new Function<WebDriver, WebElement>() 
	{ 
		public WebElement apply(WebDriver driver) {
			return driver.findElement(By.cssSelector("body > table > tbody > tr > td.auto-style1 > blockquote > blockquote:nth-child(2) > blockquote > b:nth-child(1)"));
	 	}
	 }); 
	
	 assertEquals("The username:",foo.getText());
	 
	 
	webDriver.findElement(By.cssSelector("div table  tbody  tr  td:nth-child(2)  p  small a:nth-child(7)")).click();
	
	
	LoginPage.usernameInput("TestUser");
	
	LoginPage.passWordInput("TestPass");
	
	
	
//		webDriver.navigate().to("http://TheDemoSite.co.uk");
//		
//		webDriver.manage().window().maximize();
//		
//		webDriver.findElement(By.cssSelector("body small a:nth-child(6)")).click();
//		
//		TimeUnit.SECONDS.sleep(3);
//
//
//		webDriver.findElement(By.cssSelector(" table  tbody  tr:nth-child(1)  td:nth-child(2)  p  input")).sendKeys("testuser");
//
//		TimeUnit.SECONDS.sleep(3);
//		
//		
//
//		
//		
//		webDriver.findElement(By.cssSelector(" table  tbody tr:nth-child(2) td:nth-child(2) p  input")).sendKeys("testpass");
//
//		TimeUnit.SECONDS.sleep(3);
//
//		
//
//		
//		
//		
//		//saving password
//		webDriver.findElement(By.cssSelector("table  tbody  tr:nth-child(3) td:nth-child(2) p input")).click();
//		
//		TimeUnit.SECONDS.sleep(3);
//
//
//
//		
//		
//		
//		//clicking login
//
//		webDriver.findElement(By.cssSelector("div table  tbody  tr  td:nth-child(2)  p  small a:nth-child(7)")).click();
//		
//		TimeUnit.SECONDS.sleep(3);	
//
//		
//
//		
//		
//		// Username		
//		webDriver.findElement(By.cssSelector("table  tbody  tr  td:nth-child(1)  table  tbody  tr:nth-child(1)  td:nth-child(2)  p  input")).sendKeys("testuser");
//
//		TimeUnit.SECONDS.sleep(3);
//		
//		
//
//		
//		
//		// User password
//		webDriver.findElement(By.cssSelector("table  tbody tr:nth-child(2)  td:nth-child(2)  p  input")).sendKeys("testpass");
//
//		TimeUnit.SECONDS.sleep(3);
//		
//
//		
//		//saving password
//		webDriver.findElement(By.cssSelector("td.auto-style1  form  div  center  table tbody  tr  td:nth-child(1)  table  tbody  tr:nth-child(3)  td:nth-child(2)  p  input")).click();
//		
//		TimeUnit.SECONDS.sleep(3);
		

	}

	@After
	public void aTest() {

		webDriver.quit();
	}

}
