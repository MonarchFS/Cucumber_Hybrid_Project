package automationPractice;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FileUpload {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		String filePath="E:\\DXD11\\abc.txt";
		driver.get("https://www.tutorialspoint.com/selenium/practice/selenium_automation_practice.php");
		driver.manage().window().maximize();

		uploadFile(driver, "input[name='picture']", filePath);
		Thread.sleep(2000);
		
		
		
		driver.quit();

		

	}
	
	
	public static void uploadFile(WebDriver driver,String fileWebElement ,String filePath) {
		
		WebElement upload= driver.findElement(By.cssSelector(fileWebElement));
		
		upload.sendKeys(filePath);
		
	}

	
}
