package automationPractice;


import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
public class DropDown {

	
	public static void dropDown(WebDriver driver,String elementLocator,String visibleText) throws InterruptedException {
		
		WebElement drpdn=driver.findElement(By.xpath(elementLocator));
		Select alldropdwn = new Select(drpdn);
		
		
		
		List<WebElement> alloptions = alldropdwn.getOptions();
		
		alldropdwn.selectByVisibleText(visibleText);
		
		
		Thread.sleep(2000);
		
	}
	
	
	
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.tutorialspoint.com/selenium/practice/selenium_automation_practice.php");
		driver.manage().window().maximize();
		dropDown(driver, "//select[@id='state']","Haryana");
		dropDown(driver, "//select[@id='city']", "Agra");
		
		
		driver.quit();
		

	}

}
