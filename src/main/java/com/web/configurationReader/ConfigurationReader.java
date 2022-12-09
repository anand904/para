package com.web.configurationReader;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


public class ConfigurationReader {

	Properties p;
	public ConfigurationReader() throws IOException {
		
		File f = new File("C:\\Users\\anand\\eclipse-workspace\\paraBank_Project\\src\\main\\java\\com\\web\\properties\\paraBank.properties");
		
		FileInputStream fi = new FileInputStream(f);
		p=new Properties();
		p.load(fi);
		
	}
	
	public String getBrowser() {
		String browser = p.getProperty("browser");
		return browser;
		}
	
	public String getUrl() {
		String Url = p.getProperty("url");
		return Url;
		}
	public String getSheet() {
		String sheet = p.getProperty("sheet");
		return sheet;
		}
	
}
