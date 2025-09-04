package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
	WebDriver driver;
	
	public RegisterPage(WebDriver driver) { //Constructor
		this.driver = driver;
		PageFactory.initElements(driver,this);
		
	}
	
	@FindBy(id="input-firstname")
	private WebElement firstNameField;
	
	public void enterFirstName(String firstNameText) {
		firstNameField.sendKeys(firstNameText);
	}
	
	
	@FindBy(id="input-lastname")
	private WebElement lastNameField;
	
	public void enterLastName(String lastNameText) {
		lastNameField.sendKeys(lastNameText);
	}
	
	@FindBy(id="input-email")
	private WebElement emailField;
	
	public void enterEmail(String emailText) {
		emailField.sendKeys(emailText);
	}
	
	
	@FindBy(id="input-telephone")
	private WebElement telephoneField;
	
	public void enterTelephone(String teleText) {
		telephoneField.sendKeys(teleText);
	}
	
	
	@FindBy(id="input-password")
	private WebElement passwordField;
	
	public void enterPass(String passText) {
		passwordField.sendKeys(passText);
	}
	
	@FindBy(id="input-confirm")
	private WebElement passwordConfirmFiled;
	public void enterConfirmPass(String passText) {
		passwordConfirmFiled.sendKeys(passText);
	}
	
	@FindBy(xpath="//input[@name='agree']")
	private WebElement privacyPolicyOption;
	
	public void selectPrivacyPolicy() {
		privacyPolicyOption.click();
	}
	
	@FindBy(xpath="//input[@value='Continue']")
	private WebElement continueButton;
	
	public AccountSuccessPage continueOption() {
		continueButton.click();
		return new AccountSuccessPage(driver);
	}
	
	@FindBy(xpath="//input[@name='newsletter' and @value='1']")
	private WebElement yesNewsLetterOption;
	
	public void yesNewsLetter() {
		yesNewsLetterOption.click();
	}
	
	@FindBy(xpath="//div[contains(@class,'alert-dismissible')]")
	private WebElement warningMessage;
	public String getWarningMessageText() {
		return warningMessage.getText();
	}
	
	@FindBy(xpath="//input[@id='input-firstname']/following-sibling::div")
	private WebElement firstNameWarning;
	public String getfirstNameWarningMessageText() {
		return firstNameWarning.getText();
	}
	
	
	@FindBy(xpath="//input[@id='input-lastname']/following-sibling::div")
	private WebElement lastNameWarning;
	public String getlastNameWarningMessageText() {
		return lastNameWarning.getText();
	}
	
	
	@FindBy(xpath="//input[@id='input-email']/following-sibling::div")
	private WebElement emailWarning;
	public String getemailWarningMessageText() {
		return emailWarning.getText();
	}
	
	
	@FindBy(xpath="//input[@id='input-telephone']/following-sibling::div")
	private WebElement telephoneWarning;
	public String gettelephoneWarningMessageText() {
		return telephoneWarning.getText();
	}
	
	
	@FindBy(xpath="//input[@id='input-password']/following-sibling::div")
	private WebElement passwordWarning;
	public String getpasswordWarningMessageText() {
		return passwordWarning.getText();
	}
	

}
