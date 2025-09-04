package automationPractice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FramesDemo {
	
	public static void iframe(WebDriver driver,String locator) {
		WebDriverWait mywait= new WebDriverWait(driver, Duration.ofSeconds(8));
		List<WebElement> frs= driver.findElements(By.xpath(locator));
		//Below was just to get fids in console 
		/*for(WebElement fr:frs) {
			String fids=fr.getDomAttribute("id");
			System.out.println("Frame ID: "+fids);
		}*/
		
		
		//Now we fetch the ids for example 1st one 
		if(!frs.isEmpty()) {
			String fIDs=frs.get(0).getDomAttribute("id");// Fetch the id 
			//of the first frame
			
			driver.switchTo().frame(fIDs);
			WebElement cont= driver.findElement(By.xpath("//div[@class='rsw-ce']"));
			System.out.println(cont.getText());
			cont.clear();
			cont.sendKeys("tftfvefvefd");
			System.out.println(cont.getText());
		}
		
		
		
	}

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.lambdatest.com/selenium-playground/iframe-demo/");
		driver.manage().window().maximize();
		iframe(driver, "//iFrame[@loading='eager']");
		
		driver.close();
		driver.quit();
		

	}

}
