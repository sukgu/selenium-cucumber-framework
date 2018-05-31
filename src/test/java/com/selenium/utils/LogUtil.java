package com.selenium.utils;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;



public class LogUtil {
	
	private static Logger Log = Logger.getLogger(LogUtil.class.getName());
	

	// This is to print log for the beginning of the test case, as we usually run so many test cases as a test suite
	 
	 public static void startTestCase(String sTestCaseName)
	 {
		Double randomNumber=Math.random();
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yy");
		Date date = new Date();
		Integer i=(int)(10000*randomNumber);
		String batch=null;
		String s=(sTestCaseName.replaceAll("\\s","") +"_"+ i.toString().trim() +"_"+ dateFormat.format(date)+"/"+sTestCaseName.replaceAll("\\s",""));
		PropertyUtil property=new PropertyUtil();
		String file="src/config/config.properties";
		System.out.println(file);
		try {
			batch=property.readFile(file, "batch");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.setProperty("batch", batch);
		System.setProperty("logfile", s);
		DOMConfigurator.configure("src/config/log4j.xml");
		Log.info("****************************************************************************************");
		Log.info("$$$$$$$$$$$$$$$$$$$$$                "+"-S-T--A--R-T-"+"       $$$$$$$$$$$$$$$$$$$$$$$$$$$");
		Log.info("****************************************************************************************");
	 
	 }
	 
		//This is to print log for the ending of the test case
	 
	 public static void endTestCase(String sTestCaseName)
	 {
		 
		Log.info("****************************************************************************************");
		Log.info("$$$$$$$$$$$$$$$$$$$$$             "+"-E---N---D-"+"             $$$$$$$$$$$$$$$$$$$$$$$$$");
		Log.info("****************************************************************************************");
	 
	 }
	 
		// Need to create these methods, so that they can be called  
	 
	 public static void info(String message) {
	 
			Log.info(message);
	 
			}
	 
	 public static void warn(String message) {
	 
	    Log.warn(message);
	 
		}
	 
	 public static void error(String message) {
	 
	    Log.error(message);
	 
		}
	 
	 public static void fatal(String message) {
	 
	    Log.fatal(message);
	 
		}
	 
	 public static void debug(String message) {
	 
	    Log.debug(message);
	 
		}
	 
	
}
