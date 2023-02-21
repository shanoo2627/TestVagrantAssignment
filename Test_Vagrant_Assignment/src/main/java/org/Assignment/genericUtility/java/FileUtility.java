package org.Assignment.genericUtility.java;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;




public final class FileUtility {
	private Properties properties;

	/**
	 * This method is used to initialize the property file
	 * 
	 * @param filePath
	 */
	public void initiallizePropertyFile(String propertyfilePath) {
		FileInputStream fis = null;

		try {
			fis = new FileInputStream(propertyfilePath);
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}
		properties = new Properties();
		try {
			properties.load(fis);
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	/**
	 * This method is used to fetch the data from property file
	 * 
	 * @param key
	 * @return
	 */
	public String getDataFromProperty(String key) {

		return properties.getProperty(key).trim();
	}

	

	public static void copyFile(File src, File dst) {
		// TODO Auto-generated method stub
		
	}

	

	


  
  
  
 
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
