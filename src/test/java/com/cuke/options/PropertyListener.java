package com.cuke.options;

import java.io.InputStream;
import java.util.Properties;

public class PropertyListener {
	
	
	private static volatile PropertyListener propInstance;
	
	
	private PropertyListener() {
		
	}
	
	public static synchronized PropertyListener getInstance() {
		
		if(propInstance==null) {
			
			propInstance = new PropertyListener();
		}	
		return propInstance;	
	}
	
	
	/**
	 * 
	 * @param propertyName
	 * @return
	 */
	public String getProperty( String propertyName) {
		
		Properties prop = new Properties();
		
		try {
			
			InputStream inputStream = getClass()
					.getClassLoader().getResourceAsStream("application.properties");
			
			prop.load(inputStream);
			
			if(prop.getProperty(propertyName) != null) {
				
				return prop.getProperty(propertyName);
			}
			
			
		}catch (Exception e) {
			
			System.out.println("Property not found");
		}
		
		return null;
	}

}
