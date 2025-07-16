package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

	static Properties prop;
	public static String getConfigData(String key) {
		
		try(FileInputStream file = new FileInputStream("./configFile/config.properties")){
			prop = new Properties();
			prop.load(file);
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		
		
		return prop.getProperty(key);
	}
}
