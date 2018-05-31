package com.selenium.modules;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import com.selenium.pom.ProductListGrid;

public class ProductListAction {

	public static void Execute(WebDriver driver,List<String> list) throws Exception{

		ProductListGrid banner = new ProductListGrid(driver);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		
		
		banner.clickOnProduct();
		wait.withTimeout(10, TimeUnit.SECONDS);
		
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
