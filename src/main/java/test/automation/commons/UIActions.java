package test.automation.commons;

import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import test.automation.Elite.SuperClass;

import java.time.Duration;
import java.util.Set;

public class UIActions extends SuperClass {

    public UIActions() {
        PageFactory.initElements(driver, this);
    }

    WebDriverWait wait;
    Alert alert;
    Select select;

    /**
     * @return string
     */
    public String getAlertData()
    {
        try {
            WebDriverWait wait=expilictWait();
            wait.until(ExpectedConditions.alertIsPresent());
            alert =driver.switchTo().alert();
            return alert.getText();
        }
        catch(NoAlertPresentException e)
        {
            return null;
        }
    }

    /**
     * @param testdata
     * @return boolean
     */
    public boolean setAlertData(String testdata)
    {
        try {
            wait=expilictWait();
            wait.until(ExpectedConditions.alertIsPresent());
            alert =driver.switchTo().alert();
            alert.sendKeys(testdata);
            return true;
        }
        catch(NoAlertPresentException e)
        {
            return false;
        }
    }

    /**
     * @param action
     * @return boolean
     */
    public boolean setActiononAlert(String action)
    {
        try {

            wait=expilictWait();
            wait.until(ExpectedConditions.alertIsPresent());
            alert =driver.switchTo().alert();
            if(action.equalsIgnoreCase("dismiss"))
            {
                alert.dismiss();
                return true;
            }
            else if(action.equalsIgnoreCase("accept"))
            {
                alert.accept();
                return true;
            }
            else
            {
                throw new NoAlertPresentException();
            }

        } catch(NoAlertPresentException e)
        {
            return false;
        }

    }

    /**
     * @param element
     * @return
     */
    public boolean isElementExist(WebElement element)
    {
        try {

            return element.isDisplayed();
        }
        catch(NoSuchElementException e)
        {
            return false;
        }
    }

    /**
     * @param element
     * @param filepath
     */
    public void uploadFile(WebElement element,String filepath)
    {
        element.sendKeys(filepath);

    }

    /**
     * @param element
     * @param Opration
     * @param testdata
     * @return
     * @throws NoSuchElementException
     */
    public boolean selectDropdown(WebElement element,String Opration,String testdata) throws NoSuchElementException
    {

        select =new Select(element);

        if(Opration.equalsIgnoreCase("value"))
        {
            select.selectByValue(testdata);
            return true;
        }
        else if(Opration.equalsIgnoreCase("index"))
        {
            select.selectByIndex(Integer.parseInt(testdata));
            return true;
        }
        else if(Opration.equalsIgnoreCase("visibleText"))
        {
            select.selectByVisibleText(testdata);
            return true;
        }
        else
        {
            return false;
        }

    }

    /**
     *
     * @param element
     * @param Opration
     * @param testdata
     * @return
     * @throws NoSuchElementException
     */
    public boolean deselectDropdown(WebElement element,String Opration,String testdata) throws NoSuchElementException
    {

        select =new Select(element);

        if(Opration.equalsIgnoreCase("value"))
        {
            select.deselectByValue(testdata);
            return true;
        }
        else if(Opration.equalsIgnoreCase("index"))
        {
            select.deselectByIndex(Integer.parseInt(testdata));
            return true;
        }
        else if(Opration.equalsIgnoreCase("visibleText"))
        {
            select.deselectByVisibleText(testdata);
            return true;
        }
        else
        {
            return false;
        }

    }

    /**
     *
     * @return
     */
    public boolean isdriverAlive()
    {
        try {
            driver.getTitle();
            return true;
        }
        catch(NullPointerException e)
        {
            return false;
        }
    }

    /**
     * @return
     */
    public boolean switchToWindow()
    {
        String currentWindowName=driver.getWindowHandle();
        Set<String> windowsname=driver.getWindowHandles();
        try {
            windowsname.forEach(window->{
                if(!window.equalsIgnoreCase(currentWindowName)&&windowsname.size()==2)
                {
                    driver.switchTo().window(window);

                }
            });
            return true;
        }
        catch(NoSuchWindowException e)
        {
            return false;
        }

    }

    /**
     * @param windowType
     * @return
     */
    public String switchToNewWindow(String windowType)
    {
        if(windowType.equalsIgnoreCase("window")) {
            driver.switchTo().newWindow(WindowType.WINDOW);
            return driver.getWindowHandle();
        }
        else if(windowType.equalsIgnoreCase("Tab")) {
            driver.switchTo().newWindow(WindowType.TAB);
            return driver.getWindowHandle();
        }
        return null;
    }



    /**
     * @param windowname
     * @return
     */
    public boolean switchToWindow(String windowname)
    {

        Set<String> windowsname=driver.getWindowHandles();
        try {
            windowsname.forEach(window->{
                if(window.equalsIgnoreCase(windowname))
                {
                    driver.switchTo().window(window);

                }
            });
            return true;
        }
        catch(NoSuchWindowException e)
        {
            return false;
        }

    }

    /**
     * @return
     * @throws NoSuchWindowException
     */
    public int getCurrentWindowsCount() throws NoSuchWindowException
    {
        Set<String> windowsname=driver.getWindowHandles();
        return windowsname.size();

    }

    /**
     * @return
     */
    public boolean isFrameExist()
    {
        try {
            driver.findElement(By.xpath("//./iframe"));
            return true;
        }
        catch(NoSuchElementException e)
        {
            return false;
        }
    }

    /**
     * @return
     */
    public int frameCount()
    {
        return driver.findElements(By.xpath("//./iframe")).size();
    }

    /**
     *
     * @return
     */
    public WebDriverWait expilictWait()
    {
        wait =new WebDriverWait(driver, Duration.ofSeconds(30));
        return wait;
    }

    /**
     *
     * @param element
     * @param attributeName
     * @return
     */
    public String getAttributeValue(WebElement element,String attributeName)
    {
        return element.getAttribute(attributeName);
    }

    /**
     *
     * @param element
     * @return
     */
    public boolean clickAction(WebElement element)
    {
        //To Be imp
        return false;
    }

}
