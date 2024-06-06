package com.comcast.crm.propertyfileutility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class propertyFileUtilizationClass {
	
	public String getDataFromPropertyFile(String key) throws IOException {
		FileInputStream fis = new FileInputStream("C:\\Users\\HP\\OneDrive\\Desktop\\Data\\data1.properties");
		Properties pro = new Properties();
		pro.load(fis);
		String p =pro.getProperty(key);
		return p;
	}
}
