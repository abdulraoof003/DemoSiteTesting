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
		
//		webDriver.findElement(By.cssSelector("#menu > div.navigation-links-hugescreen.visible-f > ul > li:nth-child(2) > div > a > span")).click();
		
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
