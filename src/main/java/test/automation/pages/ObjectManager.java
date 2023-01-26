package test.automation.pages;

import org.openqa.selenium.support.PageFactory;
import test.automation.rare.SuperClass;

public class ObjectManager extends SuperClass {
	
	public ObjectManager() {
		
			PageFactory.initElements(driver, this);		
	}

	public ObjectManager getIntance(String objType)
	{
		if(objType.equalsIgnoreCase(""))
			return new Google();
		else
			return null;
	}
}
