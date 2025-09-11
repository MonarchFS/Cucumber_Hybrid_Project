package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.CommonUtils;
import utility.ElementUtils;

public class RegisterPage {
	WebDriver driver;
	private ElementUtils eleutils;
	
	public RegisterPage(WebDriver driver) { //Constructor
		this.driver = driver;
		PageFactory.initElements(driver,this);
		eleutils = new ElementUtils(driver);
		
	}
	
	@FindBy(id="input-firstname")
	private WebElement firstNameField;
	
	public void enterFirstName(String firstNameText) {
		//firstNameField.sendKeys(firstNameText);
		eleutils.typeTextIntoElement(firstNameField, firstNameText, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}
	
	
	@FindBy(id="input-lastname")
	private WebElement lastNameField;
	
	public void enterLastName(String lastNameText) {
		//lastNameField.sendKeys(lastNameText);
		eleutils.typeTextIntoElement(lastNameField, lastNameText, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}
	
	@FindBy(id="input-email")
	private WebElement emailField;
	
	public void enterEmail(String emailText) {
		//emailField.sendKeys(emailText);
		eleutils.typeTextIntoElement(emailField, emailText, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}
	
	
	@FindBy(id="input-telephone")
	private WebElement telephoneField;
	
	public void enterTelephone(String teleText) {
		//telephoneField.sendKeys(teleText);
		eleutils.typeTextIntoElement(telephoneField, teleText, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}
	
	
	@FindBy(id="input-password")
	private WebElement passwordField;
	
	public void enterPass(String passText) {
		//passwordField.sendKeys(passText);
		eleutils.typeTextIntoElement(passwordField, passText, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}
	
	@FindBy(id="input-confirm")
	private WebElement passwordConfirmFiled;
	public void enterConfirmPass(String passText) {
		//passwordConfirmFiled.sendKeys(passText);
		eleutils.typeTextIntoElement(passwordConfirmFiled, passText, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}
	
	@FindBy(xpath="//input[@name='agree']")
	private WebElement privacyPolicyOption;
	
	public void selectPrivacyPolicy() {
		//privacyPolicyOption.click();
		eleutils.clickOnElement(privacyPolicyOption, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}
	
	@FindBy(xpath="//input[@value='Continue']")
	private WebElement continueButton;
	
	public AccountSuccessPage continueOption() {
		eleutils.clickOnElement(continueButton, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		//continueButton.click();
		return new AccountSuccessPage(driver);
	}
	
	@FindBy(xpath="//input[@name='newsletter' and @value='1']")
	private WebElement yesNewsLetterOption;
	
	public void yesNewsLetter() {
		//yesNewsLetterOption.click();
		eleutils.clickOnElement(yesNewsLetterOption, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}
	
	@FindBy(xpath="//div[contains(@class,'alert-dismissible')]")
	private WebElement warningMessage;
	public String getWarningMessageText() {
		//return warningMessage.getText();
		return eleutils.getTextFromElement(warningMessage, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}
	
	@FindBy(xpath="//input[@id='input-firstname']/following-sibling::div")
	private WebElement firstNameWarning;
	public String getfirstNameWarningMessageText() {
		//return firstNameWarning.getText();
		return eleutils.getTextFromElement(firstNameWarning, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}
	
	
	@FindBy(xpath="//input[@id='input-lastname']/following-sibling::div")
	private WebElement lastNameWarning;
	public String getlastNameWarningMessageText() {
		//return lastNameWarning.getText();
		return eleutils.getTextFromElement(lastNameWarning, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}
	
	
	@FindBy(xpath="//input[@id='input-email']/following-sibling::div")
	private WebElement emailWarning;
	public String getemailWarningMessageText() {
		//return emailWarning.getText();
		return eleutils.getTextFromElement(emailWarning, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}
	
	
	@FindBy(xpath="//input[@id='input-telephone']/following-sibling::div")
	private WebElement telephoneWarning;
	public String gettelephoneWarningMessageText() {
		//return telephoneWarning.getText();
		return eleutils.getTextFromElement(telephoneWarning, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}
	
	
	@FindBy(xpath="//input[@id='input-password']/following-sibling::div")
	private WebElement passwordWarning;
	public String getpasswordWarningMessageText() {
		//return passwordWarning.getText();
		return eleutils.getTextFromElement(passwordWarning, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}
	

}
