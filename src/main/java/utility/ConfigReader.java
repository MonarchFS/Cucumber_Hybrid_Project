package utility;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {
	//this method will be used to get the properties file details like browser name or url etc , to reduce set up method code
	public Properties initializeProperties() {
		//Setting a propeties object
		Properties prop = new Properties();
		//giving path of the prop file
		File propFile = new File(System.getProperty("user.dir")+"\\src\\test\\resources\\config\\config.properties");
		
		try {
			//getting the prop file and load it
			FileInputStream fis= new FileInputStream(propFile);
			prop.load(fis);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		//need to return the prop file when the method is called
		return prop;
	}

}
