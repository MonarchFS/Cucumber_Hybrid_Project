package hooks;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import factory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utility.ConfigReader;

public class MyHooks {

	WebDriver driver;
	private ConfigReader cfg;
		//Create webdriver set up , will execute before every scenario		//Before and After hook will be applicable for all the step def files
		@Before
		public void setUp() {
			
			//will load the prop file first
			 cfg= new ConfigReader();
			Properties prop = cfg.initializeProperties();
			
			//will send the key broswer and will get the value
			
			driver= DriverFactory.initializeBrowser(prop.getProperty("browser"));
			driver.get(prop.getProperty("url"));
			
		}
		
		//After every scenario of feature file
		//Scenario class used to get screenshot if any scenario fails
		@After
		public void tearDown(Scenario scenario) {
			
			String scenarioName = scenario.getName().replaceAll(" ", "");
			
			if(scenario.isFailed()) {
				//typecast takescrrenshot
				
				byte[] srcScreenShot= ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
				//below to attach the above byte screenshot in report attach method will attach to report
				scenario.attach(srcScreenShot, "image/png", scenarioName);
				
			}
			
			driver.close();
			driver.quit();
			
		}
}
