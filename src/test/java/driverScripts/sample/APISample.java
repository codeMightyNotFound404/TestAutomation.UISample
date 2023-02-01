package driverScripts.sample;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import org.testng.annotations.AfterMethod;
import org.json.simple.JSONObject;

import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeSuite;

import static io.restassured.RestAssured.*;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedHashMap;
import java.util.Map;

public class APISample {

	//To Be Implement

    String id=null;
	ExtentHtmlReporter htmlReporter;
	ExtentReports extent;
	ExtentTest logger;

    
	@BeforeSuite
	public void beforeSuite() {
		// To Be Imp By User

	}

	@Test(enabled=true)
	public void get() {
		// To Be Imp By User
	}


	@Test(priority=2,enabled=true)
	public void post() {
    // To Be Imp By User
	}



	@Test(priority=3,enabled=false)
	public void put() {
      // To Be Imp By User
	}

	@Test(priority=4,enabled=false)
	public void delete() {
		// To Be Imp By User
	}

	
	@AfterClass
	  public void afterClass() {
		  extent.flush();
		  extent.close();
	  }  

  
 
  
  @AfterMethod
  public void setup(ITestResult result) throws Exception
  {

	 //To Be Imp By User
  }
	

}
