package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/features" , 
				glue= {"stepDefinations","hooks"}, 	
				//publish=true, use if want to create a 24 hr url for anyone to access report
				plugin = {"pretty","html:target/cucumber-reports.html"})
public class MyRunner {
	

}
