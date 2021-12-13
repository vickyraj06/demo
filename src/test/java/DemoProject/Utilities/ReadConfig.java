package DemoProject.Utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {

	Properties properties;

	public ReadConfig() {

		FileInputStream file;
		try {
			file = new FileInputStream("./Configuration/Config.properties");
			properties = new Properties();
			properties.load(file);

		} catch (Exception e1) {

			e1.printStackTrace();
		}


	}

	public String GetBaseurl() {
		String Baseurl =  (String) properties.get("baseurl");
		return Baseurl;


	}
	public String GetUsername() {

		String username = (String) properties.get("username");
		return username;

	}

	public String GetPassword() {

		String password = (String) properties.get("password");
		return password;

	}

	public String GetLocation() {

		String location = (String) properties.get("chromelocation");
		return location;

	}
	public String GetLocationfirefox() {

		String location1 = (String) properties.get("firefoxlocation");
		return location1;

	}
	public String GetTitle() {

		String Title = (String) properties.get("Expected_Title");
		return Title;

	}
	
	
	

}
