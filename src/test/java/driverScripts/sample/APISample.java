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
		 File file=new File("src//Reports"+"//"+"User");
			if(!file.exists())
			{
				file.mkdir();
			}
		 htmlReporter = new ExtentHtmlReporter("src//Reports"+"//"+"User"+"//"+"RestAPI"+"_"+DateTimeFormatter.ofPattern("hh-mm").format(LocalDateTime.now())+".html");
	      extent = new ExtentReports();
	     extent.attachReporter(htmlReporter);
	     extent.setSystemInfo("OS", System.getProperty("os"));
	     extent.setSystemInfo("Browser", System.getProperty("browser"));
	     htmlReporter.config().setChartVisibilityOnOpen(true);
	     htmlReporter.config().setDocumentTitle("Test API Automation");
	     htmlReporter.config().setReportName("test");
	     htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
	     htmlReporter.config().setTheme(Theme.STANDARD);
		RestAssured.baseURI="https://restful-booker.herokuapp.com";

	}

//	@Test(enabled=true)
//	public void get() {
//		logger=extent.createTest("Get Method Execution");
//		SoftAssert softassert =new SoftAssert();
//		Response response = RestAssured.given().header("content-type", "application/json").header("charset","utf-8")
//				.when().get("/booking/1").
//				then().contentType(ContentType.JSON).
//        extract().response();
//		JsonPath jsonPathEvaluator = response.jsonPath();
//		softassert.assertEquals(response.getStatusLine(), "HTTP/1.1 200 OK","Status code displayed as: "+response.getStatusLine());
//		logger.pass("Get status code as : "+response.getStatusLine());
//		softassert.assertEquals(jsonPathEvaluator.get("firstname")+" "+jsonPathEvaluator.get("lastname"), "Sally Brown","Name Displayed as: "+jsonPathEvaluator.get("firstname")+" "+jsonPathEvaluator.get("lastname"));
//		logger.pass("Booking customer name : "+jsonPathEvaluator.get("firstname")+" "+jsonPathEvaluator.get("lastname"));
//		logger.info("Booking check-in and check-out : "+jsonPathEvaluator.get("bookingdates").toString());
//	}
//
//
//	@Test(priority=2,enabled=true)
//	public void post() {
//		logger=extent.createTest("Post Method Execution");
//		JSONObject object1=new JSONObject();
//		object1.put("username","admin");
//		object1.put("password","password123");
//
//		System.out.println(object1);
//
//		Response response=given().
//				auth().preemptive()
//				.oauth2("8b958eedfad2d531d91ff9cd7297316487a819deb5218b342d1393921983df74")
//				.body(object1.toJSONString())
//				.when().post("/auth").
//				then().statusCode(200).statusLine("HTTP/1.1 200 OK").contentType(ContentType.JSON).extract().response();
//
//		JsonPath jsonPathEvaluator = response.jsonPath();
//	    id=jsonPathEvaluator.get("token");
//	    System.out.println(id);
//
//
//
//	}
//
//
//
//	@Test(priority=3,enabled=false)
//	public void put() {
//		Map<String,String> headermap=new LinkedHashMap<String,String>();
//		headermap.put("content-type", "application/json");
//		headermap.put("accept","application/json");
//		headermap.put("accept-encoding", "gzip,deflate");
//		headermap.put("accept-language","en-US,en;q=0.8");
//		headermap.put("user-agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_5) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/85.0.4183.102 Safari/537.36");
//
//				Map<String,Object> data=new LinkedHashMap<String,Object>();
//				data.put("id", "500");
//				data.put("name","Demo Tiwari");
//				data.put("email","Robo_tiwari@gmail.com");
//				data.put("gender","Male");
//				data.put("status","Active");
//		JSONObject obj1=new JSONObject();
//		JSONObject obj2=new JSONObject();
//		JSONObject obj3=new JSONObject();
//		JSONObject obj4=new JSONObject();
//		given().
//		auth().preemptive()
//		.oauth2("44fc272943317368cdbda078653679a739aed769dcd50a356247f28cfd0e8232")
//		.body(obj1.toJSONString()).body(obj2.toJSONString())
//		.body(obj3.toJSONString()).body(obj4.toJSONString())
//		.when().post("/users?id="+id).
//		then().statusCode(201)
//		.log()
//		.all();
//	}
//
//	@Test(priority=4,enabled=false)
//	public void delete() {
//		given()
//		.auth().preemptive()
//			.oauth2("44fc272943317368cdbda078653679a739aed769dcd50a356247f28cfd0e8232")
//		.delete("/users?name= tiwari").
//		then().
//		statusCode(204).
//		statusLine("HTTP/1.1 204 No Content").
//		log().all();
//	}

	
	@AfterClass
	  public void afterClass() {
		  extent.flush();
		  extent.close();
	  }  

  
 
  
  @AfterMethod
  public void setup(ITestResult result) throws Exception
  {

	  if(result.getStatus() == ITestResult.FAILURE)
		{
			//MarkupHelper is used to display the output in different colors
			logger.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " - Test Case Failed", ExtentColor.RED));
			logger.log(Status.FAIL, MarkupHelper.createLabel(result.getThrowable() + " - Test Case Failed", ExtentColor.RED));

			//To add it in the extent report 

			//logger.fail("Test Case Failed Snapshot is below " + logger.addScreenCaptureFromPath(""));


		}
		else if(result.getStatus() == ITestResult.SKIP){
			logger.log(Status.SKIP, "Test Case Skipped is "+result.getName());
			logger.log(Status.SKIP, MarkupHelper.createLabel(result.getName() + " - Test Case Skipped", ExtentColor.ORANGE)); 
		} 
		else if(result.getStatus() == ITestResult.SUCCESS)
		{
			logger.log(Status.PASS, MarkupHelper.createLabel(result.getName()+" Test Case PASSED", ExtentColor.GREEN));
		}
  }
	

}
