package com.selenium.utils;

import java.io.IOException;

public class Constant {

	static String batch;
	static {
		PropertyUtil property=new PropertyUtil();
		String file="src/config/config.properties";
		try {
			batch=property.readFile(file, "batch");
			} catch (IOException e) {
				e.printStackTrace();
				}
		}
	public static final String URL = "http://www.facebook.com";
	public static final String Username = "testuser_1";
	public static final String Password = "Test@123";
	public static final String Path_TestData = "src/testData/";
	public static final String File_TestData = "TestData.xlsx";
	public static final String Path_ExcelReport = "src/reports/"+batch;
	public static final String File_ExcelReport = "TestReport.xlsx";

}