package Test;

import java.util.List;
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

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import java.io.File;
import java.io.IOException;




public class TestPom {

	private WebDriver webDriver;
	private RegPage RegPage;
	private LoginPage LoginPage;
	
	private Wait<WebDriver> wait;


	private ExtentReports report;
    private ExtentTest test;
    private String reportFilePath = "test.html";
	
    @BeforeClass
    public static void init(){

    }
   
    
	
	@Before
	public void before() {

        report = new ExtentReports();
        ExtentHtmlReporter extentHtmlReporter = new ExtentHtmlReporter(reportFilePath);
        extentHtmlReporter.config().setReportName("ReportName");
        extentHtmlReporter.config().setDocumentTitle("DocumentTitle");
        report.attachReporter(extentHtmlReporter);
        test = report.createTest("TestName");
				
        
       
        
		webDriver = new ChromeDriver();
		RegPage = PageFactory.initElements(webDriver, RegPage.class);
		
		LoginPage = PageFactory.initElements(webDriver, LoginPage.class);

		wait = new FluentWait<WebDriver>(webDriver)
				 .withTimeout(30, SECONDS)
				 .pollingEvery(5, SECONDS)
				 .ignoring(NoSuchElementException.class);
		
	}

	@Test
	
	 public void spreadSheet(){
 

		SpreadSheetReader sheetReader = new SpreadSheetReader(System.getProperty("user.dir") + "/Example_Spreadsheet.xlsx");
        List<String> row = sheetReader.readRow(1, "Input Data");

        
        for(String cell : row){
            System.out.println(cell);
        }
	}
	
		
	
	
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

	try {
		test.log(Status.INFO,"Info level"+test.addScreenCaptureFromPath(ScreenShot.take(webDriver, "gnsg")));
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    test.fail("Failed  " );

	}

	@After
	public void aTest() {


		report.flush();
		webDriver.quit();
	}

}
