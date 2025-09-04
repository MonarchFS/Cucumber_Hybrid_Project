package utility;

import java.util.Date;

public class CommonUtils {

	public String emailWithTimeStamp() {
		Date date= new Date();
		return "donald"+date.toString().replace(" ", "_").replace(":", "_")+"@gmail.com";
	}
}
