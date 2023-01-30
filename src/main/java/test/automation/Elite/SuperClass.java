package test.automation.Elite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.ITestResult;
import test.automation.Models.Base;
import test.automation.helper.ScreenShot;

import java.util.Properties;

public class SuperClass  implements Base {

	public  WebDriver driver;
    public  Properties prop;
    public  static ExtentHtmlReporter htmlReporter;
	public  static ExtentReports extent;
	public ExtentTest logger;


	synchronized public void browserinitialization(String type)
	{
		type.toLowerCase();
		switch(type)
		{
		case "chrome":
			System.setProperty("webdriver.chrome.driver", "/absolute/path/to/binary/chromedriver");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("start-maximized");
			options.addArguments("enable-automation");
			options.addArguments("--no-sandbox");
			options.addArguments("--disable-infobars");
			options.addArguments("--disable-dev-shm-usage");
			options.addArguments("--disable-browser-side-navigation");
			options.addArguments("--disable-gpu");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		case "ie":
			break;
		case "firefox":
			System.setProperty("webdriver.gecko.driver", "/absolute/path/to/binary/geckodriver");
			WebDriverManager.firefoxdriver().setup();
			break;
		case "safari":
			 driver=new SafariDriver();
			break;
		}
	}



	public void reportResult(ITestResult result,ExtentTest logger)
	{
		  if(result.getStatus() == ITestResult.FAILURE)
			{
				//MarkupHelper is used to display the output in different colors
				logger.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " - Test Case Failed", ExtentColor.RED));
				logger.log(Status.FAIL, MarkupHelper.createLabel(result.getThrowable() + " - Test Case Failed", ExtentColor.RED));
                 ScreenShot shot=new ScreenShot();
				//String screenshotPath = shot.screenShot(prop.getProperty("scr_shot"));
				//To add it in the extent report

				//logger.fail("Test Case Failed Snapshot is below " + logger.addScreenCaptureFromPath(""));

			}
			else if(result.getStatus() == ITestResult.SKIP){
				//logger.log(Status.SKIP, "Test Case Skipped is "+result.getName());
				logger.log(Status.SKIP, MarkupHelper.createLabel(result.getName() + " - Test Case Skipped", ExtentColor.ORANGE));
			}
			else if(result.getStatus() == ITestResult.SUCCESS)
			{
				logger.log(Status.PASS, MarkupHelper.createLabel(result.getName()+" Test Case PASSED", ExtentColor.GREEN));
			}}

}
