package pages;

import org.openqa.selenium.By;
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
	
//	@FindBy(xpath="//span[text()='My Account']")//dontusebczavoidstaleelementexception
//	private WebElement editAccInfo;
	private By editAccInfo = By.xpath("//span[text()='My Account']");
	
	public boolean displayStausMyAccount() {
		//return editAccInfo.isDisplayed();
		return eleutils.displayStatusOfElementBy(editAccInfo, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}

}
