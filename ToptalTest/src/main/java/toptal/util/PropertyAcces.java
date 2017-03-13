package toptal.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyAcces {
	
	public String getProperty(String propertyFileName, String propertyName){
		
		try{
			Properties properties = new Properties();
			InputStream inputStream = getClass().getClassLoader().getResourceAsStream(propertyFileName);
			
			if(inputStream != null){
				properties.load(inputStream);
			}
			
			return properties.getProperty(propertyName);
		}
		catch(IOException e){
			return "";
		}
	}

}
