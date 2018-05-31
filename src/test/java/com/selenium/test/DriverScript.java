package com.selenium.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import com.selenium.utils.ExcelUtil;
import com.selenium.utils.ReportUtil;

public class DriverScript {

	static String testcase;
	static boolean check;
	static String result;
	static Map<String,String> excelData;

	
	public static void main(String[] args) {
		
		String projectDir=System.getProperty("user.dir");
		projectDir=projectDir.replaceAll("\\\\", "/");
		System.setProperty("automationDir", projectDir);
		excelData=new HashMap<String, String>();
		ReportUtil.batchSetup();
		try {
			//ExcelUtil.setExcelFile(Constant.Path_ExcelReport+Constant.File_ExcelReport, "Sheet1");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for (int i=0;i<=ExcelUtil.getRows();i++)
		{
			try {
				if((boolean)(ExcelUtil.getCellData(i, "ToRun").toLowerCase().equals("true")))
				{
					try
					{
						testcase=ExcelUtil.getCellData(i, "Testcase");
						result="FAIL";
						excelData.put(testcase, result);
						
					} catch (Exception e) 
					{
						e.printStackTrace();
					}
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		for (String key : excelData.keySet()) {
		    
			DriverScript.testcase=key;
			try {
				
				String junitPath=projectDir+"/lib/junit-4.12.jar";
				String classpath=junitPath+";"+projectDir+";"+projectDir+"/bin;"+projectDir+"/lib/*;"+projectDir+"/lib/ApachePOI/*";
				String command="java -cp "+classpath+" org.junit.runner.JUnitCore com.app.test."+DriverScript.testcase;
				command=command.replace("/", "\\");
				//System.out.println(command);
				Process process = Runtime.getRuntime().exec(command);
				InputStream stdout = process.getInputStream ();
				BufferedReader reader = new BufferedReader (new InputStreamReader(stdout));
				String line;
				while ((line = reader.readLine ()) != null) {
				    System.out.println (line);
				    if(line.contains("FAILURES")) {
				    	result="FAIL";
				    	excelData.put(testcase, result);
				    	break;
				    } else if(line.matches("(^OK)(\\s)(.)((\\d)|(\\d\\d)|(\\d\\d\\d))(\\s)(tests)(.$)")) {
				    	result="PASS";
				    	excelData.put(testcase, result);
				    	break;
				    }
				}
				
				try {
					process.waitFor();
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}  
	    
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		for (int i=0;i<=ExcelUtil.getRows();i++)
		{
			try {
				if(excelData.containsKey(ExcelUtil.getCellData(i, "Testcase")))
				{
					try
					{
						ExcelUtil.setCellData(excelData.get(ExcelUtil.getCellData(i, "Testcase")), i, "Result");
					} catch (Exception e) 
					{
						e.printStackTrace();
					}
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}

}
