package test.automation.helper;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import test.automation.SuperClass;

public class JSExecutor extends SuperClass {

	public JSExecutor() {
	PageFactory.initElements(driver, this);	
	}

	JavascriptExecutor jsexecutor= (JavascriptExecutor) driver;
	
	public void windowScrollBy(int x ,int y)
	{
		jsexecutor.executeScript("window.scrollBy("+x+","+y+")");
	}
	
	public void windowScrollBy()
	{
		jsexecutor.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	}
	
	public void windowScrollBy(WebElement element)
	{
		jsexecutor.executeScript("arguments[0].scrollIntoView();",element );	
	}
	
	public void clickOnLink(WebElement link)
	{
		jsexecutor.executeScript("arguments[0].click();", link);
	}
	
	public void clickOnElement(WebElement element)
	{
		jsexecutor.executeScript("arguments[0].click();", element);
	}
}
