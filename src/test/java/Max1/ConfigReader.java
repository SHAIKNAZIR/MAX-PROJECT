package Max1;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
	
	static Properties prop;
	public static String getProperty(String key) {
		if(prop==null) {
			try {
				prop=new Properties();
				FileInputStream fis=new FileInputStream("config.properties");
				prop.load(fis);
				
			}
			catch(IOException e) {
				e.printStackTrace();
			}
		}
		return prop.getProperty(key);
	}

}
