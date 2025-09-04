package automationPractice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.sun.tools.javac.util.Assert;

public class Waits {

public static void wait(WebDriver driver,String locator)  {
		WebDriverWait mywait= new WebDriverWait(driver, Duration.ofSeconds(6));
		WebElement message= mywait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(locator))));
		message.click();
		//div[text()='Autocloseable info message. Hide in 5 seconds.']
		By messageLocator = By.xpath("//div[text()='Autocloseable info message. Hide in 5 seconds.']");

		WebElement display = mywait.until(ExpectedConditions.visibilityOfElementLocated(messageLocator));
		String text = driver.findElement(messageLocator).getText();
		System.out.println(display.isDisplayed()+"\n"+ text);
		
		try {
			mywait.until(ExpectedConditions.invisibilityOfElementLocated(messageLocator));
			System.out.println("Element disapeared.");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Message didnt disapear within time limit"+e);
		}
		
		}
		
		
		
	
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver= new ChromeDriver();
		driver.get("https://www.lambdatest.com/selenium-playground/bootstrap-alert-messages-demo");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		wait(driver,"//button[text()='Autoclosable Info Message']");
		
		driver.close();
		driver.quit();

	}
}
