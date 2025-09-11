package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.CommonUtils;
import utility.ElementUtils;

public class AccountPage {
	WebDriver driver;
	private ElementUtils eleutils;

	public AccountPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements( driver,this);
		eleutils = new ElementUtils(driver);
	}
	
	@FindBy(xpath="//span[text()='My Account']")
	private WebElement editAccInfo;
	public boolean displayStausMyAccount() {
		//return editAccInfo.isDisplayed();
		return eleutils.displayStatusOfElement(editAccInfo, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}

}
