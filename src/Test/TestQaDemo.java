package Test;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import com.google.common.base.Function;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.By.ByCssSelector;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

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

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import java.io.File;
import java.io.IOException;

public class TestQaDemo {

	private WebDriver webDriver;
	private RegPage RegPage;
	private LoginPage LoginPage;

	private Wait<WebDriver> wait;

	private ExtentReports report;
	private ExtentTest test;
	private String reportFilePath = "user.dir";

	@BeforeClass
	public static void init() {

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

		wait = new FluentWait<WebDriver>(webDriver).withTimeout(30, SECONDS).pollingEvery(5, SECONDS)
				.ignoring(NoSuchElementException.class);

	}

	@Ignore
	public void Test1() throws InterruptedException {

		webDriver.navigate().to("http://demoqa.com/draggable/");

		webDriver.manage().window().maximize();

		WebElement foo = wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				return driver.findElement(By.cssSelector("#post-22 > header > h1"));
			}
		});

		assertEquals("Draggable", foo.getText());

		Actions builder = new Actions(webDriver);

		builder.moveToElement((webDriver.findElement(By.cssSelector("#draggable")))).clickAndHold()
				.moveByOffset(500, 200).build().perform();

		TimeUnit.SECONDS.sleep(5);
	}

	@Ignore
	public void Test2() throws InterruptedException {

		Actions builder = new Actions(webDriver);

		webDriver.navigate().to("http://demoqa.com/droppable/");

		webDriver.manage().window().maximize();

		builder.dragAndDrop((webDriver.findElement(By.cssSelector("#draggableview > p"))),
				(webDriver.findElement(By.cssSelector("#droppableview")))).build().perform();

		TimeUnit.SECONDS.sleep(5);
	}

	@Ignore
	public void Test3() throws InterruptedException {

		Actions builder = new Actions(webDriver);

		webDriver.navigate().to("http://demoqa.com/resizable/");

		webDriver.manage().window().maximize();

		builder.moveToElement((webDriver.findElement(By.cssSelector(
				"#resizable > div.ui-resizable-handle.ui-resizable-se.ui-icon.ui-icon-gripsmall-diagonal-se"))))
				.clickAndHold().moveByOffset(50, 50).release();
		
		builder.build();
		builder.perform();

		TimeUnit.SECONDS.sleep(5);

	}

	@Test
	public void Test4() throws InterruptedException {

		Actions builder = new Actions(webDriver);

		webDriver.navigate().to("http://demoqa.com/selectable/");

		webDriver.manage().window().maximize();
		
		
		webDriver.findElement(By.cssSelector("#ui-id-2")).click();
//		
		TimeUnit.SECONDS.sleep(5);		

		webDriver.manage().window().maximize();
		
		
		webDriver.findElement(By.cssSelector("#selectable_grid > li:nth-child(11)")).click();
//		builder.moveToElement((webDriver.findElement(By.cssSelector("#selectable_grid > li:nth-child(11)")))).clickAndHold().moveByOffset(50, 50).release();
//		builder.build();
//		builder.perform();

		TimeUnit.SECONDS.sleep(5);

	}

	// webDriver.findElement(By.cssSelector("body small
	// a:nth-child(6)")).click();
	//
	//
	// RegPage.usernameInput("TestUser");
	//
	//
	// RegPage.setpassWordInput("TestPass");
	//
	//
	// //saving password
	// webDriver.findElement(By.cssSelector("table tbody tr:nth-child(3)
	// td:nth-child(2) p input")).click();
	//
	//
	// WebElement foo = wait.until(new Function<WebDriver, WebElement>()
	// {
	// public WebElement apply(WebDriver driver) {
	// return driver.findElement(By.cssSelector("#menu-item-64 > a"));
	// }
	// });
	//
	// assertEquals("The username:",foo.getText());
	//
	//
	// webDriver.findElement(By.cssSelector("div table tbody tr td:nth-child(2)
	// p small a:nth-child(7)")).click();
	//
	//
	// LoginPage.usernameInput("TestUser");
	//
	// LoginPage.passWordInput("TestPass");
	//
	//
	//
	//

	@After
	public void aTest() {

		report.flush();
		webDriver.quit();
	}

}
