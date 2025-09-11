package factory;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import utility.CommonUtils;
import utility.ConfigReader;

public class DriverFactory {	
	static WebDriver driver= null; 
	public static WebDriver initializeBrowser(String browserName) {
		
		
		
		if(browserName.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}
		else if(browserName.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		}
		
		else {
			System.out.println("Invalid Browser Name");
		}
		
		//Fresh new browser opens up
		driver.manage().deleteAllCookies();  
		driver.manage().window().maximize();
		//below will wait for page to load , otherwise selenium will keep waiting
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(CommonUtils.PAGE_LOAD_TIME));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(CommonUtils.IMPLICT_WAIT_TIME));
		
		return driver;
	}
	
	
	public static WebDriver getDriver() {
		
		return driver;
	}
}
