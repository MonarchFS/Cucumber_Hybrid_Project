package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.CommonUtils;
import utility.ElementUtils;

public class SearchResultPage {

	WebDriver driver;
	private ElementUtils eleUtils;
	
	public SearchResultPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		eleUtils = new ElementUtils(driver);
	}
	
	@FindBy(linkText = "HP LP3065")
	private WebElement validHpProduct;
	
	public boolean displayStatusOfValidProduct() {
		//return validHpProduct.isDisplayed();
		return eleUtils.displayStatusOfElement(validHpProduct, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}
	
	
	@FindBy(xpath="//input[@id='button-search']/following-sibling::p")
	private WebElement messageText;
	
	public String getMessageText() {
		//return messageText.getText();
		return eleUtils.getTextFromElement(messageText, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}
	
	
}
