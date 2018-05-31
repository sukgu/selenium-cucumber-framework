package com.selenium.modules;

import com.selenium.pom.AppLoginPage;
import com.selenium.utils.LogUtil;

import java.util.HashMap;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public class SignInAction {

	public static void Execute(WebDriver driver,HashMap<String,String> map) throws Exception{

		AppLoginPage loginPage = new AppLoginPage(driver);
		
		loginPage.hoverOnSignInText();
		LogUtil.info(" is hoverd on Sign In text" );
		
		/*loginPage.hoverOnSignInText();
		LogUtil.info(" is hoverd on Sign In text" );*/
		
		
		loginPage.clickOnLoginText();
		LogUtil.info(" is clicked on Login text" );
		
		//driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(loginPage.getLoginFrame()));
		
		driver.switchTo().frame(loginPage.getLoginFrame());
		
		loginPage.setEmail(map.get("username"));
		LogUtil.info(" is entered in username text box" );
		
		loginPage.clickOnContinue();
		LogUtil.info("Click action is performed on Continue button");
		
		wait.until(ExpectedConditions.elementToBeClickable(loginPage.getInputPassword()));
		
		loginPage.setPassword(map.get("password"));
		LogUtil.info(" is entered in Password text box" );
		
		wait.until(ExpectedConditions.elementToBeClickable(loginPage.getLoginButton()));

		loginPage.clickOnLogin();
		LogUtil.info("Click action is performed on Submit button");

		Reporter.log("SignIn Action is successfully perfomred");

	}
}