package test.automation.helper;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

import test.automation.SuperClass;

public class ExternalReporter extends SuperClass {
	    
	 
	 
	public ExternalReporter(String reportPath,String reportName,String reportfolder) throws FileNotFoundException {
		File file=new File(reportPath+"//"+reportfolder);
		if(!file.exists())
		{
			file.mkdir();
		}
		  htmlReporter = new ExtentHtmlReporter(reportPath+"//"+reportfolder+"//"+reportName+"_"+DateTimeFormatter.ofPattern("hh-MM").format(LocalDateTime.now())+".html");
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        extent.setSystemInfo("OS", System.getProperty("os"));
        extent.setSystemInfo("Browser", System.getProperty("browser"));
        htmlReporter.config().setChartVisibilityOnOpen(true);
        htmlReporter.config().setDocumentTitle("Test API Automation");
        htmlReporter.config().setReportName(reportName);
        htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
        htmlReporter.config().setTheme(Theme.STANDARD);
	}
	
	public void reportflush()
	{
		extent.flush();
		extent.close();
	}

	
}
