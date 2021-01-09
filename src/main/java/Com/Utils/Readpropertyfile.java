package Com.Utils;

import java.io.FileInputStream;
import java.util.Properties;

public class Readpropertyfile {

	static Properties property;
	
public static String get(String propertyname) {
		
	// reads the details from TestRun property file in configuration folder
	
		String returnproperty=null;
		 property = new Properties();
		try {
			FileInputStream file = new FileInputStream("./Configuration/TestRun.properties");
			property.load(file);
			returnproperty = property.getProperty(propertyname);
			if(returnproperty==null) {
				throw new Exception("Property named "+propertyname+ "not found");
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return returnproperty;
		
	}
public String ApplicationUrl() {
	String url = property.getProperty("url");
	return url;
}

public String Appusername() {
	String user = property.getProperty("username");
	return user;
}
public String AppPassword() {
	String pwd = property.getProperty("password");
	return pwd;
}
	
}
