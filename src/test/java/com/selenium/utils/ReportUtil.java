package com.selenium.utils;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;

public class ReportUtil {

	public static void batchSetup() {
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yy");
		Date date = new Date();
		String batch="Batch_"+ dateFormat.format(date)+"/";
		createFolder(batch);
		PropertyUtil property=new PropertyUtil();
		String file="src/config/config.properties";
		try {
			property.writeFile(file, "batch", batch);
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.setProperty("batch", batch);
		File source=new File("src/testdata/TestData.xlsx");
		File dest=new File("src/reports/"+batch+"/TestReport.xlsx");
		try {
			FileUtils.copyFile(source, dest);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void createFolder(String fileName) {
		
		File files = new File(System.getProperty("automationDir")+"/src/results/"+fileName);
		if (!files.exists()) {
			if (files.mkdirs()) {
				System.out.println("Multiple directories are created!");
			} else {
				System.out.println("Failed to create multiple directories!");
			}
		}
	}
}
