package driverScripts.sample;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import test.automation.SuperClass;
import test.automation.helper.ExternalReporter;
import test.automation.helper.ReadExcel;
import test.automation.helper.WriteExcel;

import org.testng.annotations.DataProvider;

import static io.restassured.RestAssured.given;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import org.json.simple.JSONObject;
import org.testng.annotations.BeforeSuite;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;

public class BulkDataCreation extends SuperClass{

	//To Be Implement
	String id=null;
	ReadExcel readExcel;
	WriteExcel writeExcel;
	ExternalReporter report;
	ArrayList<String> list;
	//ExtentTest extentTest=null;
	@BeforeSuite
	public void beforeSuite() {
		loadProperty("src//main//resource//Config.properties");
		RestAssured.baseURI=prop.getProperty("base_url");
		//RestAssured.basePath=prop.getProperty("base_path");
		try {
			report=new ExternalReporter("src//Reports", "BulkDataUpload", "Rest-API");
			readExcel=new ReadExcel();
			writeExcel=new WriteExcel();
			list=new ArrayList<String>();
			logger=extent.createTest("SampleTest");
			} catch (FileNotFoundException e) {
			System.out.println("Failed"+e.getLocalizedMessage());
			
		}
	}
	
	
	
	
	@Test(dataProvider = "APIdata",priority=0,enabled=true)
	public void post(String name, String job,String qvoid1,String avoid2) {
		JSONObject object1=new JSONObject();
		object1.put("name",name);
		object1.put("job",job);
        logger.info("Test Data:-"+name+"\t"+job);
		Response response=given()
				.body(object1.toJSONString())
				.when().post("/users").
				then().statusCode(201).statusLine("HTTP/1.1 201 Created").contentType(ContentType.JSON).extract().response();
	     logger.info("Response \n"+response.toString());
		JsonPath jsonPathEvaluator = response.jsonPath();
		id=jsonPathEvaluator.get("id"); 
		list.add(id);
		logger.log(Status.PASS, "Passed");
	}

	@DataProvider(name="APIdata")
	public Object[][] dp() {
		return  readExcel.getExcel2D("src//test//resource//UIDataTemplate.xlsx","TestDemo");
	}

	@AfterMethod
	public void afterMethod(ITestResult testResult)
	{
		reportResult(testResult, logger);
	}
	@AfterSuite
	public void afterSuite() {
		try {
		writeExcel.setExcelColumn("src//test//resource//UIDataTemplate.xlsx","TestDemo",2,list);
		}
		catch(Exception e)
		{
			System.err.println(e.getMessage());
		}
		finally {
	
		report.reportflush();
		}
	}

}
