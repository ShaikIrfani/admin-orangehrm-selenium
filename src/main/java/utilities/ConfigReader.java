package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


public class ConfigReader {

	Properties  prop;
	
	public ConfigReader() {
		prop =new Properties();
		
			 
		try {
			FileInputStream fis =new FileInputStream("src/test/resources/config.properties");
			 prop.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public String getBrowser() {
		return prop.getProperty("browser");
	}	
	
	public String getUATUrl() {
		return prop.getProperty("uat.url") ;
	}
		public String getSITUrl() {
			return prop.getProperty("sit.url") ;
	}
		public boolean isHeadless() {
			return Boolean.parseBoolean(prop.getProperty("headless"));
		
	}
		public int implicitWait() {
			return Integer.parseInt(prop.getProperty("implicit.wait"));
			
}
		
		public int explictWait() {
			return Integer.parseInt(prop.getProperty("explicit.wait"));
			
		}
		
		public int pageLoadWait() {
			return Integer.parseInt(prop.getProperty("page.Load.timeout"));
			
		}
}



