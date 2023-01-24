package test.automation.helper;

import java.io.File;
import java.io.IOException;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.PageFactory;


import test.automation.SuperClass;

public class ScreenShot extends SuperClass  {

	//To Be Implement
	public ScreenShot()
	{
		PageFactory.initElements(driver , this);
	}

	//To Be Implement
	public void screenShot(String filepath,String testcasename,String featurefile) throws IOException
	{
		File targetfile=null,sourceFile,targetDir;
		TakesScreenshot shot=(TakesScreenshot) driver;
		 sourceFile=shot.getScreenshotAs(OutputType.FILE);
         targetDir=new File(filepath+"//"+featurefile);
        if(!targetDir.exists())
        {
        targetDir.mkdir();
        }
        targetfile=new File(filepath+"//"+featurefile+"//"+testcasename);
        FileUtils.copyFile(sourceFile, targetfile);
	}

}
