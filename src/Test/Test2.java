package Test;

import java.util.concurrent.TimeUnit;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test2 {


	private WebDriver webDriver;
	
//	@BeforeClass
//	public static void bClass(){
//		System.out.println("BeforeClass");
//	}
//	
	@Before
	public void bTest(){

	webDriver = new ChromeDriver();
		
	}

	@Test
	public void Test() throws InterruptedException{

		webDriver.navigate().to("http://TheDemoSite.co.uk");
		
		webDriver.manage().window().maximize();
		
		webDriver.findElement(By.cssSelector("body small a:nth-child(6)")).click();
		
		TimeUnit.SECONDS.sleep(3);


		webDriver.findElement(By.cssSelector(" table  tbody  tr:nth-child(1)  td:nth-child(2)  p  input")).sendKeys("testuser");

		TimeUnit.SECONDS.sleep(3);
		
		

		
		
		webDriver.findElement(By.cssSelector(" table  tbody tr:nth-child(2) td:nth-child(2) p  input")).sendKeys("testpass");

		TimeUnit.SECONDS.sleep(3);

		

		
		
		
		//saving password
		webDriver.findElement(By.cssSelector("table  tbody  tr:nth-child(3) td:nth-child(2) p input")).click();
		
		TimeUnit.SECONDS.sleep(3);



		
		
		
		//clicking login

		webDriver.findElement(By.cssSelector("div table  tbody  tr  td:nth-child(2)  p  small a:nth-child(7)")).click();
		
		TimeUnit.SECONDS.sleep(3);	

		

		
		
		// Username		
		webDriver.findElement(By.cssSelector("table  tbody  tr  td:nth-child(1)  table  tbody  tr:nth-child(1)  td:nth-child(2)  p  input")).sendKeys("testuser");

		TimeUnit.SECONDS.sleep(3);
		
		

		
		
		// User password
		webDriver.findElement(By.cssSelector("table  tbody tr:nth-child(2)  td:nth-child(2)  p  input")).sendKeys("testpass");

		TimeUnit.SECONDS.sleep(3);
		

		
		//saving password
		webDriver.findElement(By.cssSelector("td.auto-style1  form  div  center  table tbody  tr  td:nth-child(1)  table  tbody  tr:nth-child(3)  td:nth-child(2)  p  input")).click();
		
		TimeUnit.SECONDS.sleep(3);
		

	}
	
	
	@After
	public void aTest(){

		webDriver.quit();
	}
	
//	@After
//	public void aTest(){
//
//		System.out.println("AfterTest");
//	}
	
//	@AfterClass
//	public static void aClass(){
//	
//		System.out.println("AfterClass");	
//		
//	}
//	
	
}
