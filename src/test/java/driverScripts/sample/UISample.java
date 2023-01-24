package driverScripts.sample;

import org.testng.annotations.Test;

import test.automation.helper.ReadExcel;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class UISample {

  // To be Implement
	ReadExcel readExcel=new ReadExcel();
	
  @Test(dataProvider = "TestAutomationData")
  public void f(Integer n, String s) {
	  
  }
  @BeforeMethod
  public void beforeMethod() {
	
  }

  @AfterMethod
  public void afterMethod() {
  }


  @DataProvider(name="empLogin")
	public Object[][] loginData() {
		Object[][] arrayObject = readExcel.getExcel2D("D://sampledoc.xls","Sheet1");
		return arrayObject;
	}

	
  @BeforeClass
  public void beforeClass() {
  }

  @AfterClass
  public void afterClass() {
  }

  @BeforeTest
  public void beforeTest() {
	  
  }

  @AfterTest
  public void afterTest() {
  }

  @BeforeSuite
  public void beforeSuite() {
  }

  @AfterSuite
  public void afterSuite() {
  }

}
