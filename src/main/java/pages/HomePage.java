package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.ElementUtils;

public class HomePage {
	WebDriver driver;
	private ElementUtils eleutils;
	//constructor no return type
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);//this line will automatically
		//call all the methods of class homepage
		eleutils = new ElementUtils(driver);
		//above we pass driver so that we can use it in eleutils object
		
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
		//myAccountDropMenu.click();
		eleutils.clickOnElement(myAccountDropMenu, 15);
	}
	
	public LoginPage clickOnLogin() {
		//loginOption.click();
		eleutils.clickOnElement(loginOption, 20);
		return new LoginPage(driver);
	}
	
	public RegisterPage selectRegisterOption() {
		//registerOption.click();
		eleutils.clickOnElement(registerOption, 15);
		return new RegisterPage(driver);
	}
	
	public void enterProductIntoSearchBox(String ProductText) {
		//searchBoxField.sendKeys(ProductText);
		eleutils.typeTextIntoElement(searchBoxField, ProductText, 20);
	}
	
	public SearchResultPage clickOnSearchButton() {
		//searchButton.click();
		eleutils.clickOnElement(searchButton, 20);
		return new SearchResultPage(driver);
	}
	
	
	
}
