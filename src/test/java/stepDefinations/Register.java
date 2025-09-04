package stepDefinations;

import java.util.Date;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AccountSuccessPage;
import pages.HomePage;
import pages.RegisterPage;
import utility.CommonUtils;

public class Register {

	WebDriver driver;
	private RegisterPage rp;
	private AccountSuccessPage asp;
	private CommonUtils cu;
	
	
	@Given("User navigates to Register Account page")
	public void user_navigates_to_register_account_page() {
		
		driver = DriverFactory.getDriver();
		HomePage hp = new HomePage(driver);
		hp.clickOnMyAccount();
		//driver.findElement(By.xpath("//span[text()='My Account']")).click();
		rp = hp.selectRegisterOption();
		//driver.findElement(By.linkText("Register")).click();

	}
	
	@When("User enters the below fields")
	public void user_enters_the_below_fields(DataTable dataTable) {

		Map<String, String> dataMap = dataTable.asMap(String.class,String.class);
		
		//rp = new RegisterPage(driver);
		cu = new CommonUtils();
		//driver.findElement(By.id("input-firstname")).sendKeys(dataMap.get("firstname"));
		rp.enterFirstName(dataMap.get("firstname"));
		//driver.findElement(By.id("input-lastname")).sendKeys(dataMap.get("lastname"));
		rp.enterLastName(dataMap.get("lastname"));
		//driver.findElement(By.id("input-email")).sendKeys(emailWithTimeStamp());
		
		rp.enterEmail(cu.emailWithTimeStamp());
		//driver.findElement(By.id("input-telephone")).sendKeys(dataMap.get("telephone"));
		rp.enterTelephone(dataMap.get("telephone"));
		//driver.findElement(By.id("input-password")).sendKeys(dataMap.get("password"));
		rp.enterPass(dataMap.get("password"));
		//driver.findElement(By.id("input-confirm")).sendKeys(dataMap.get("password"));
		rp.enterConfirmPass(dataMap.get("password"));
	}

	@When("User enters the below fields with duplicate email")
	public void user_enters_the_below_fields_with_duplicate_email(DataTable dataTable) {

		Map<String, String> dataMap = dataTable.asMap(String.class,String.class);
		
		//rp = new RegisterPage(driver);
				
		rp.enterFirstName(dataMap.get("firstname"));		
		rp.enterLastName(dataMap.get("lastname"));		
		rp.enterEmail(dataMap.get("email"));		
		rp.enterTelephone(dataMap.get("telephone"));		
		rp.enterPass(dataMap.get("password"));		
		rp.enterConfirmPass(dataMap.get("password"));
		
//		driver.findElement(By.id("input-firstname")).sendKeys(dataMap.get("firstname"));
//		driver.findElement(By.id("input-lastname")).sendKeys(dataMap.get("lastname"));
//		driver.findElement(By.id("input-email")).sendKeys(dataMap.get("email"));
//		driver.findElement(By.id("input-telephone")).sendKeys(dataMap.get("telephone"));
//		driver.findElement(By.id("input-password")).sendKeys(dataMap.get("password"));
//		driver.findElement(By.id("input-confirm")).sendKeys(dataMap.get("password"));
	}

	@And("User selects privacy policy checkbox")
	public void user_selects_privacy_policy_checkbox() {
		rp.selectPrivacyPolicy();
		//driver.findElement(By.xpath("//input[@name='agree']")).click();
	}

	@And("User clicks on continue button")
	public void user_clicks_on_continue_button() {
		
		asp= rp.continueOption();
		//driver.findElement(By.xpath("//input[@value='Continue']")).click();
		
	}

	@Then("User account should get created successfully")
	public void user_account_should_get_created_successfully() {
	   //AccountSuccessPage asp = new AccountSuccessPage(driver);
	    
	    Assert.assertEquals("Your Account Has Been Created!", asp.getPageHeading());
	}

	@And("User selects Yes for Newsletter")
	public void user_selects_yes_for_newsletter() {
		rp.yesNewsLetter();
		//driver.findElement(By.xpath("//input[@name='newsletter' and @value='1']")).click();
	}

	@Then("User get a proper warning about exisiting email")
	public void user_get_a_proper_warning_about_exisiting_email() {
	    
		Assert.assertTrue(rp.getWarningMessageText().contains("Warning: E-Mail Address is already registered!"));
	}

	@When("User do not enter any credentials")
	public void user_do_not_enter_any_credentials() {
		rp.enterFirstName("");		
		rp.enterLastName("");		
		rp.enterEmail("");		
		rp.enterTelephone("");		
		rp.enterPass("");		
		rp.enterConfirmPass("");
		
	}


	@Then("User should get proper warning messages for every mandatory field")
	public void user_should_get_proper_warning_messages_for_every_mandatory_field() {
	   		
		
		Assert.assertTrue(rp.getWarningMessageText().contains("Warning: You must agree to the Privacy Policy!"));
		Assert.assertEquals("First Name must be between 1 and 32 characters!", rp.getfirstNameWarningMessageText());
		Assert.assertEquals("Last Name must be between 1 and 32 characters!", rp.getlastNameWarningMessageText());
		Assert.assertEquals("E-Mail Address does not appear to be valid!", rp.getemailWarningMessageText());
		Assert.assertEquals("Telephone must be between 3 and 32 characters!", rp.gettelephoneWarningMessageText());
		Assert.assertEquals("Password must be between 4 and 20 characters!", rp.getpasswordWarningMessageText());
		
	}
	
	private String emailWithTimeStamp() {
		Date date= new Date();
		return "donald"+date.toString().replace(" ", "_").replace(":", "_")+"@gmail.com";
	}

}
