package com.selenium.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

public class PropertyUtil {

	/*private File file;
	private String strfile;*/
	private Properties properties=new Properties();
	private OutputStream output=null;
	private InputStream input=null;
	
	/*public PropertyUtil(File file) {
		this.file=file; 
	}
	
	public PropertyUtil(String strfile) {
		this.strfile=strfile;
	}*/
	
	public String readFile(File file,String property) throws IOException
	{
		input=new FileInputStream(file);
		properties.load(input);
		return properties.getProperty(property);
	}
	
	public boolean writeFile(File file,String property) throws IOException
	{
		output=new FileOutputStream(file);
		properties.getProperty(property);
		properties.store(output,null);
		return true;
	}
	
	public String readFile(String file,String property) throws IOException
	{
		input=new FileInputStream(file);
		properties.load(input);
		return properties.getProperty(property);
	}
	
	public boolean writeFile(String file,String property,String value) throws IOException
	{
		output=new FileOutputStream(file);
		properties.setProperty(property,value);
		properties.store(output,null);
		return true;
	}
}
