package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;
	
	//constructor no return type
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);//this line will automatically
		//call all the methods of class homepage
		
		
	}
	
	//cr8 webelement for register cick
	@FindBy(linkText = "Register")
	private WebElement registerOption;
	
	//cr8 webelements for homepage, find by is pagefactory design model for pom model
	@FindBy(xpath="//span[text()='My Account']")
	private WebElement myAccountDropMenu;
	
	@FindBy(linkText="Login")
	private WebElement loginOption;
	
	@FindBy(name="search")
	private WebElement searchBoxField;
	
	@FindBy(xpath="//button[contains(@class,'btn-default')]")
	private WebElement searchButton;
	
	
	//so above is private so cannot be called outside Homepoage class
	//so below method will be used by other class to indirectly access above element
	public void clickOnMyAccount() {
		myAccountDropMenu.click();
	}
	
	public LoginPage clickOnLogin() {
		loginOption.click();
		return new LoginPage(driver);
	}
	
	public RegisterPage selectRegisterOption() {
		registerOption.click();
		return new RegisterPage(driver);
	}
	
	public void enterProductIntoSearchBox(String ProductText) {
		searchBoxField.sendKeys(ProductText);
	}
	
	public SearchResultPage clickOnSearchButton() {
		searchButton.click();
		return new SearchResultPage(driver);
	}
	
	
	
}
