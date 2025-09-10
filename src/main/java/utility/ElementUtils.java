package utility;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtils {
	
	//constructor to get the driver
	WebDriver driver;
	public ElementUtils(WebDriver driver) {
		this.driver = driver;
	}

	//click on Element method
	
	public void clickOnElement(WebElement element, long durationInSeconds) {
		
		//Wait for element to be clickable
		//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationInSeconds));
		WebElement webElement= waitForElement(element, durationInSeconds);
		webElement.click();
	}
	
	//type text element
	
	
	/*    ******************************** IMPORTANT****************************************
	 * Here we are passing WebElement element which is for FindBy element, if we need for By locator use below
	 * 
	 * */
	
	public void typeTextIntoElementBy(By locator, String textToBeTyped, long durationInSeconds) {
	    WebElement webElement = waitForElementBy(locator, durationInSeconds);
	    webElement.click();
	    webElement.clear();
	    webElement.sendKeys(textToBeTyped);
	}
	
	
	public WebElement waitForElementBy(By locator, long durationInSeconds) {
	    WebElement webElement = null;
	    try {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationInSeconds));
	        webElement = wait.until(ExpectedConditions.elementToBeClickable(locator));
	    } catch (Throwable e) {
	        e.printStackTrace();
	    }
	    return webElement;
	}
	
	public void typeTextIntoElement(WebElement element, String textToBeTyped, long durationInSeconds) {
		//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationInSeconds));
		
		WebElement webElement= waitForElement(element, durationInSeconds);
		webElement.click();
		webElement.clear();
		webElement.sendKeys(textToBeTyped);
		
		
	}
	
	public WebElement waitForElement(WebElement element, long durationInSeconds) {
		WebElement webElement = null;;
		
		try {	
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationInSeconds));
		webElement= wait.until(ExpectedConditions.elementToBeClickable(element));
		}
		catch(Throwable e) {
			e.printStackTrace();
		}
		return webElement;
	}
	
	public void selectOptionInDropdown(WebElement element,String dropDownOption, long durationInSeconds) {
		WebElement webelement = waitForElement(element, durationInSeconds);
		Select select = new Select(element);
		select.deselectByVisibleText(dropDownOption);
		
	}
	
	public void acceptAlert(long durationOfSeconds) {
		Alert alert = waitForAlert(durationOfSeconds);
		alert.accept();
	}
	
	public void dismissAlert(long durationOfSeconds) {
		Alert alert = waitForAlert(durationOfSeconds);
		alert.dismiss();
	}
	
	public Alert waitForAlert(long durationInSeconds) {
		
		Alert alert = null;
		try {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationInSeconds));
		alert =  wait.until(ExpectedConditions.alertIsPresent());
		}
		catch(Throwable e){
			e.printStackTrace();
		}
		return alert;
	}
	
	public void mouseHoverAndClick(WebElement element,long durationInSeconds) {
		
		//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationInSeconds));
		WebElement webElement = waitForVisibilityOfElement(element, durationInSeconds);
		
		Actions action = new Actions(driver);
		action.moveToElement(webElement).click().build().perform();
	}
	
	//to separate waits for different actions
	public WebElement waitForVisibilityOfElement(WebElement element,long durationInSeconds) {
		
		WebElement webElement = null;  // if null not given then issue as its not initialized yet
		
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationInSeconds));
			webElement = wait.until(ExpectedConditions.visibilityOf(element));
		} catch (Throwable e) {
			
			e.printStackTrace();
		}
		
		return webElement;
	}
	
	
	//javascript click method if normal click donot work
	
	public void javascriptClick(WebElement element,long durationOfSeconds) {
		
		WebElement webElement = waitForVisibilityOfElement(element, durationOfSeconds);
		//typecast driver to use javascript
		
		JavascriptExecutor jse= ((JavascriptExecutor)driver );
		jse.executeScript("argument[0].click();", webElement);
		
	}
	
	//javascript sendkey type method if normal sendkeys donot work
	public void javascriptType(WebElement element,long durationOfSeconds,String textToBeTyped) {
		WebElement webElement = waitForVisibilityOfElement(element, durationOfSeconds);
		JavascriptExecutor jse = ((JavascriptExecutor)driver);
		jse.executeScript("arguments[0].value='"+textToBeTyped+"'", webElement);
		
	}
	
	public String getTextFromElement(WebElement element, long durationOfSeconds) {
		WebElement webElement = waitForElement(element, durationOfSeconds);
		return webElement.getText();
	}
	
	public boolean displayStatusOfElement(WebElement element, long durationOfInSeconds) {
		try {
			WebElement webElement = waitForVisibilityOfElement(element, durationOfInSeconds);
			return webElement.isDisplayed();
		} catch (Throwable e) {
			
			return false;
		}
		
		
	}
	
	
}
