package test.automation.helper;
/**
 * @Author : Viren Tiwari
 */

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import test.automation.Elite.SuperClass;

public class JSExecutor extends SuperClass {

	private JSExecutor executor;

	private JavascriptExecutor jsexecutor;

	public JSExecutor getInstance()
	{
	   if(executor==null)
		   executor=new JSExecutor();
	   return executor;
	}

	public JSExecutor() {
	PageFactory.initElements(driver, this);
		jsexecutor= (JavascriptExecutor) driver;
	}

	/**
	 *
	 * @param xCord
	 * @param yCord
	 */
	public void windowScrollBy(int xCord ,int yCord)
	{
		jsexecutor.executeScript("window.scrollBy("+xCord+","+yCord+")");
	}
	
	public void windowScrollBy()
	{
		jsexecutor.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	}

	/**
	 *
	 * @param element
	 */
	public void windowScrollBy(WebElement element)
	{
		jsexecutor.executeScript("arguments[0].scrollIntoView();",element );	
	}

	/**
	 *
	 * @param link
	 */
	public void clickOnLink(WebElement link)
	{
		jsexecutor.executeScript("arguments[0].click();", link);
	}

	/**
	 *
	 * @param element
	 */
	public void clickOnElement(WebElement element)
	{
		jsexecutor.executeScript("arguments[0].click();", element);
	}
}
