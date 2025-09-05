package stepDefinations;

import java.time.Duration;
import java.util.Date;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import factory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AccountPage;
import pages.HomePage;
import pages.LoginPage;
import utility.CommonUtils;

public class Login {			

	WebDriver driver;
	private LoginPage lp;
	private AccountPage ap;
	private CommonUtils cu;
	
	
	@Given("User navigates to login page")
	public void the_user_is_on_the_ecommerce_login_page() {
		
		driver = DriverFactory.getDriver();
		HomePage hp = new HomePage(driver);
		//Below locators are in same home page so we use page object model in srcmainjava and create
		//pages pkg with homepage class to have common locator
		
		//driver.findElement(By.xpath("//span[text()='My Account']")).click();
		hp.clickOnMyAccount();
		lp= hp.clickOnLogin();

	}

	
	/*
	 * The annotation uses a regex: ^User enters valid email (.+) into email field$

		The (.+) captures any text and passes it to the method parameter valemail.

		This regex matches the step in the feature file where you have something like:
	  */
	@When("^User enters valid email (.+) into email field$")
	public void the_user_enter_valid_credentials_email(String valemail) {
		
		//Using LoginPage class
		//lp = new LoginPage(driver);
		lp.enterEmailAddress(valemail);
		//driver.findElement(By.id("input-email")).sendKeys(valemail);
	}

	@And("^User enters valid password (.+) into password field$")
	public void the_user_enter_valid_credentials_password(String valpwd) {
		//lp = new LoginPage(driver);
		lp.enterPassword(valpwd);
		//driver.findElement(By.id("input-password")).sendKeys(valpwd);
	}

	@And("User clicks on login button")
	public void the_user_click_on_login_button() {
		//lp = new LoginPage(driver);
		ap=lp.clickOnLoginBttn();
		//driver.findElement(By.xpath("//input[@value='Login']")).click();

	}

	@Then("User should get succeffully logged in")
	public void user_should_get_succeffully_logged_in() {
		//instead of declaring the account page object here
		//will declare iut in global level and have an object in account page with driver just like did for login page
		//ap = new AccountPage(driver);
		Assert.assertTrue(ap.displayStausMyAccount());

	}

	@When("User enters invalid email into email field")
	public void the_user_enter_invalid_credentials_email() {
		
		//cr8 onject again as we will be in login page after homepage
		//LoginPage lp = new LoginPage(driver);
		cu= new CommonUtils();
		lp.enterEmailAddress(cu.emailWithTimeStamp());
		//driver.findElement(By.id("input-email")).sendKeys(emailWithTimeStamp());
	}

	@And("User enters invalid password {string} into password field")
	public void the_user_enter_invalid_credentials_password(String invalpwd) {
		//lp = new LoginPage(driver);
		lp.enterPassword(invalpwd);
		//driver.findElement(By.id("input-password")).sendKeys(invalpwd);
	}

	@Then("User should get Invalid credentials message")
	public void user_should_get_Invalid_credentials_message() {
		//Will get all text and check if it contains the warning message
		Assert.assertTrue(lp.getWarningMessage().contains("Warning: No match for E-Mail Address and/or Password."));

	}

	@When("User dont enter any email in email field")
	public void user_dont_enter_any_email_in_email_field() {
		//lp = new LoginPage(driver);
		lp.enterEmailAddress("");
		//driver.findElement(By.id("input-email")).sendKeys("");
	}

	@And("User dont enter any password in password field")
	public void user_dont_enter_any_password_in_password_field() {
		//lp = new LoginPage(driver);
		lp.enterPassword("");
		//driver.findElement(By.id("input-password")).sendKeys("");
	}

	@Then("User should get an required message in credentials field")
	public void user_should_get_an_required_message_in_credentials_field() {
		Assert.assertTrue(driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).getText().contains("Warning: No match for E-Mail Address and/or Password."));
	}
	
	

}
