package com.selenium.modules;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

import com.selenium.pom.AppHomeRightWidget;

public class HomePageRightWidgetAction {
	
	public static void Execute(WebDriver driver,List<String> list) throws Exception{

		AppHomeRightWidget widget = new AppHomeRightWidget(driver);
		
		widget.clickOnNext();
		widget.clickOnNext();
		widget.clickOnNext();
		
		/*WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(widget.getLoginFrame()));
		
		driver.switchTo().frame(widget.getLoginFrame());
		
		widget.setEmail(map.get("username"));
		LogUtil.info(" is entered in username text box" );
		
		widget.clickOnContinue();
		LogUtil.info("Click action is performed on Continue button");
		
		wait.until(ExpectedConditions.elementToBeClickable(widget.getInputPassword()));
		
		widget.setPassword(map.get("password"));
		LogUtil.info(" is entered in Password text box" );
		
		wait.until(ExpectedConditions.elementToBeClickable(loginPage.getLoginButton()));

		widget.clickOnLogin();
		LogUtil.info("Click action is performed on Submit button");*/

		Reporter.log("SignIn Action is successfully perfomred");

	}

}
