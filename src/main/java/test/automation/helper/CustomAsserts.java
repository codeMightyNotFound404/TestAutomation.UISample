package test.automation.helper;

import com.aventstack.extentreports.Status;
import test.automation.Elite.SuperClass;

import java.util.List;

public class CustomAsserts extends SuperClass{

	
	public boolean isPass(List<String> actual,List<String> expected,String message)
	{
		if(expected.containsAll(actual))
		{  logger.info("expected data:"+expected);
		    logger.info("actual data:"+actual);
			logger.log(Status.PASS, message);
			return true;
		}
		else
		{
			 logger.info("expected data:"+expected);
			 logger.info("actual data:"+actual);
		     logger.log(Status.FAIL, message);
		return false;
		}
	}
	
	public boolean isPass(String actual,String expected,String message)
	{
		if(expected.equalsIgnoreCase(actual))
		{   logger.info("expected String:"+expected);
		    logger.info("actual String:"+actual);
			logger.log(Status.PASS, message);
			return true;
		}
		else
		{
			 logger.info("expected String:"+expected);
			 logger.info("actual String:"+actual);
		     logger.log(Status.FAIL, message);
		return false;
		}
	}
	
	public boolean isPass(int actual,int expected,String message)
	{
		if(expected==actual)
		{   logger.info("expected value:"+expected);
		    logger.info("actual vaule:"+actual);
			logger.log(Status.PASS, message);
			return true;
		}
		else
		{
			 logger.info("expected value:"+expected);
			 logger.info("actual value:"+actual);
		     logger.log(Status.FAIL, message);
		return false;
		}
	}

	
	public boolean isPass( boolean actual,boolean expected,String message)
	{
		if(expected==actual)
		{   logger.info("expected :"+expected);
		    logger.info("actual :"+actual);
			logger.log(Status.PASS, message);
			return true;
		}
		else
		{
			 logger.info("expected :"+expected);
			 logger.info("actual :"+actual);
		     logger.log(Status.FAIL, message);
		return false;
		}
	}
	
	

	public boolean isPass( char actual,char expected,String message)
	{
		if(String.valueOf(expected).equalsIgnoreCase(String.valueOf(actual)))
		{   logger.info("expected char:"+expected);
		    logger.info("actual char:"+actual);
			logger.log(Status.PASS, message);
			return true;
		}
		else
		{
			 logger.info("expected char:"+expected);
			 logger.info("actual char:"+actual);
		     logger.log(Status.FAIL, message);
		return false;
		}
	}
	
}
