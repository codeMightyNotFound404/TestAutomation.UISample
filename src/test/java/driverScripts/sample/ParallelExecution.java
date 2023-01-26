package driverScripts.sample;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import test.automation.rare.SuperClass;
import test.automation.helper.ExternalReporter;

import org.openqa.selenium.By;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.AfterSuite;

public class ParallelExecution extends SuperClass{

	// To be Implement
	ExternalReporter report;
 

  @BeforeSuite
  public void beforeSuite() {
	  try {
	  loadProperty("src//main//resource//Config.properties");
	  report=new ExternalReporter("src//Reports", "parallel_Execution", "demo");
	  }
	  catch(Exception e)
	  {
		  
	  }
  }
  
  
  @DataProvider(name="execution",parallel=true)
	public String [][] dp() {
	
		String[][] test=new String[4][2];
		test[0][0]="firefox";
		test[0][1]="chrome";
		test[1][0]="edge";
		test[1][1]="safari";
		test[2][0]="ie";
		return test;
	}
  
  
  @Test(dataProvider="execution",invocationCount=4,threadPoolSize=4)
   public void test(String testname,String browser) {
	  
	  logger=extent.createTest(testname);
	  browserinitialization(browser);
	  driver.get("https://www.google.com/");
	  logger.info("Navigate to google.com");
	  driver.findElement(By.className("gLFyf gsfi")).sendKeys("this is user");
	  logger.info("search result");
	 if( driver.findElements(By.xpath("//h1[text()='Search Results']/following-sibling::div/div")).size()<=1)
	 {
		 logger.log(Status.PASS, "Test-Pass");
	 }
	 else
	 {
		 logger.log(Status.FAIL, "Test-Fail");
	 }
   
  }
  
  @AfterMethod
  public void afterMethod(ITestResult result) {
	  
	  reportResult(result, logger);
	  driver.close();
  }
  @AfterSuite
  public void afterSuite() {
	  extent.flush();
	  extent.close();
	  driver.quit();
    }

}
