package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.CommonUtils;
import utility.ElementUtils;

public class AccountSuccessPage {

	WebDriver driver;
	private ElementUtils eleutils;
	
	public AccountSuccessPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		eleutils = new ElementUtils(driver);
	}
	
	@FindBy(xpath="//h1[text()='Your Account Has Been Created!']")
	private WebElement pageHeading;
	public String getPageHeading() {
		//return pageHeading.getText();
		return eleutils.getTextFromElement(pageHeading, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}
}
