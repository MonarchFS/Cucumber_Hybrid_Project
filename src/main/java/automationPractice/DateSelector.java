package automationPractice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DateSelector {
	
	public static void datePicker(WebDriver driver,String datePath) {
		
		WebElement dt = driver.findElement(By.xpath(datePath));
		dt.sendKeys("19102005");
		
	}
	
	
	

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver= new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.tutorialspoint.com/selenium/practice/selenium_automation_practice.php");
		driver.manage().window().maximize();
		
		datePicker(driver, "//input[@type='date']");
		
		
		Thread.sleep(2000);
		driver.quit();
		
		

	}

}
