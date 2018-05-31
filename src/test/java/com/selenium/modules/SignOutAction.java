package com.selenium.modules;

import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

import com.selenium.pom.AppHomePage;
import com.selenium.utils.LogUtil;



public class SignOutAction {

	public static void Execute(WebDriver driver) throws Exception{
		AppHomePage homePage = new AppHomePage(driver);
		homePage.hoverOnProfilePic();
		
		homePage.clickOnSignOut();
		LogUtil.info("Sign out is performed");
		Reporter.log("Sign out is performed");
	}
}