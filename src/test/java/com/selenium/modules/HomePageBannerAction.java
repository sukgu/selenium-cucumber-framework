package com.selenium.modules;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import com.selenium.pom.HomePageBanner;

public class HomePageBannerAction {

	public static void Execute(WebDriver driver,List<String> list) throws Exception{

		HomePageBanner banner = new HomePageBanner(driver);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		
		
		banner.clickOnBannerWithText("Samsung J3");
		wait.withTimeout(10, TimeUnit.SECONDS);
		banner.clickOnBannerWithText("Juicers");wait.withTimeout(10, TimeUnit.SECONDS);
		banner.clickOnBannerWithText("Women's Fashion");wait.withTimeout(10, TimeUnit.SECONDS);
		banner.clickOnBannerWithText("Japan Store");wait.withTimeout(10, TimeUnit.SECONDS);
		banner.clickOnActiveBanner();
		
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
