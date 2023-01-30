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

  //To Be Imp By User
	ReadExcel readExcel=new ReadExcel();
	
  @Test(dataProvider = "TestAutomationData")
  public void f(Integer n, String s) {
	  //To Be Imp By User
  }
  @BeforeMethod
  public void beforeMethod() {
    //To Be Imp By User
  }

  @AfterMethod
  public void afterMethod() {
    //To Be Imp By User
  }


  @DataProvider(name="empLogin")
	public Object[][] loginData(String filepath,String sheetName) {
		Object[][] arrayObject = readExcel.getExcel2D(filepath,sheetName);
		return arrayObject;
	}

	
  @BeforeClass
  public void beforeClass() {
    //To Be Imp By User
  }

  @AfterClass
  public void afterClass() {
    //To Be Imp By User
  }

  @BeforeTest
  public void beforeTest() {
    //To Be Imp By User
  }

  @AfterTest
  public void afterTest() {
    //To Be Imp By User
  }

  @BeforeSuite
  public void beforeSuite() {
    //To Be Imp By User
  }

  @AfterSuite
  public void afterSuite() {
    //To Be Imp By User
  }

}
