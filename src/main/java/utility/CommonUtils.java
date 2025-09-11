package utility;

import java.util.Date;

public class CommonUtils {
	
	//creating an const for implicit wait time in driver factoiry
	public static final int IMPLICT_WAIT_TIME = 10;
	public static final int PAGE_LOAD_TIME = 15;
	public static final int EXPLICIT_WAIT_BASIC_TIME = 30;

	public String emailWithTimeStamp() {
		Date date= new Date();
		return "donald"+date.toString().replace(" ", "_").replace(":", "_")+"@gmail.com";
	}
}
