package com.ESS.generic.fileutility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FileUtility {
	public String propertyFile(String key) throws IOException
	{
	
	FileInputStream fis=new FileInputStream("./src/test/resources/EssCommondata.properties");
	Properties pobj=new Properties();
	pobj.load(fis);
	String data = pobj.getProperty(key);
	return data;
	}

}
