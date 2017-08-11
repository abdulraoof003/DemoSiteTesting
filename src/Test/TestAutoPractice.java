package Test;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

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

public class TestAutoPractice {

	private WebDriver webDriver;
	private RegPage RegPage;
	private LoginPage LoginPage;

	private Wait<WebDriver> wait;

	private ExtentReports report;
	private ExtentTest test;
	private String reportFilePath = "test.html";

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

	@Test
	public void spreadSheet() {

		SpreadSheetReader sheetReader = new SpreadSheetReader(
				System.getProperty("user.dir") + "/Shopping_Spreadsheet.xlsx");

		int noRows = sheetReader.getLastRowNum("Input Data");
		System.out.println(noRows);

		int index = 1;

		while (index <= noRows) {
			List<String> row = sheetReader.readRow(index, "Input Data");
			System.out.println(row);
			Test(row.get(0), row.get(1), row.get(2), row.get(3), row.get(4), row.get(5), row.get(6), row.get(7),
					row.get(8), row.get(9));
			index++;
		}
	}

	public void Test(String testID, String email, String first_name, String last_name, String Password, String address,
			String City, String zip_Code, String phone, String mobile_phone) {

		webDriver.navigate().to("http://automationpractice.com/index.php?");

		webDriver.manage().window().maximize();

		webDriver.findElement(By.cssSelector("#header > div.nav > div > div > nav > div.header_user_info > a")).click();
		
		RegPage2.setemailInput(email);
		
		
		
		webDriver.findElement(By.cssSelector("#SubmitCreate > span")).click();


		// RegPage.usernameInput(un);
		//
		// RegPage.setpassWordInput(pas);
		//
		// // saving password
		// webDriver.findElement(By.cssSelector("table tbody tr:nth-child(3)
		// td:nth-child(2) p input")).click();
		//
		// WebElement foo = wait.until(new Function<WebDriver, WebElement>() {
		// public WebElement apply(WebDriver driver) {
		// return driver.findElement(By.cssSelector(
		// "body > table > tbody > tr > td.auto-style1 > blockquote >
		// blockquote:nth-child(2) > blockquote > b:nth-child(1)"));
		// }
		// });
		//
		// assertEquals("The username:", foo.getText());
		//
		// webDriver.findElement(By.cssSelector("div table tbody tr
		// td:nth-child(2) p small a:nth-child(7)")).click();
		//
		// LoginPage.usernameInput(un_2);
		//
		// LoginPage.passWordInput(pas_2);
		//
		//
		// webDriver.findElement(By.cssSelector("table tbody tr td:nth-child(1)
		// div center table tbody tr:nth-child(3) td:nth-child(2) p")).click();
		//
		//
		// WebElement foo2 = wait.until(new Function<WebDriver, WebElement>() {
		// public WebElement apply(WebDriver driver) {
		// return driver.findElement(By.cssSelector(
		// "body > table > tbody > tr > td.auto-style1 > big > blockquote >
		// blockquote > font > center > b"));
		// }
		// });
		//
		// assertEquals("**Successful Login**", foo2.getText());
		//
		//
		// try {
		// test.log(Status.INFO, "Info level" +
		// test.addScreenCaptureFromPath(ScreenShot.take(webDriver, "gnsg")));
		// } catch (IOException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }

	}

	@After
	public void aTest() {

		report.flush();
		webDriver.quit();
	}

}
