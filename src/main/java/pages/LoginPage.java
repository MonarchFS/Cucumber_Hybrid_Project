package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.ElementUtils;

public class LoginPage {
	WebDriver driver;
	private ElementUtils eleutils;
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		eleutils = new ElementUtils(driver);
	}
	
	//@FindBy(id="input-email")
	//private WebElement emailField;
	
	/*
	 * instead of using FindBy method which stores the reference of element 
	 * due to which if dom structure changes then we may get stale element exception
	 * 
	 * so use By method like below so that even if dom change
	 * the locator always locates fresh element
	 * */
	private By emailField = By.id("input-email");
	
	public void enterEmailAddress(String valemail) {
		//By method used as here we using By field
		eleutils.typeTextIntoElementBy(emailField, valemail, 0);
		//driver.findElement(emailField).sendKeys(valemail);
	}
	
	@FindBy(id="input-password")
	private WebElement passField;
	public void enterPassword(String valpwd) {
		eleutils.typeTextIntoElement(passField, valpwd, 20);
		//passField.sendKeys(valpwd);
	}
	
	@FindBy(xpath="//input[@value='Login']")
	private WebElement loginBttn;
	
	public AccountPage clickOnLoginBttn() {
		eleutils.clickOnElement(loginBttn, 20);
		//loginBttn.click();
		return new AccountPage(driver);
	}
	
	
	@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']")
	private WebElement warnMessage;
	
	public String getWarningMessage() {
		return eleutils.getTextFromElement(warnMessage, 20);
		//return warnMessage.getText();
	}

}
