package com.selenium.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import com.selenium.config.TestConf;

public class AppLandingPage {
	
	private final WebDriver driver;
	private static final TestConf TEST_CONF = TestConf.get();

	@FindBy(xpath = "//*[@id='u_0_4']/div[1]/div[1]/div/a/span")
	WebElement txt_user_name;

	@FindBy(xpath = "//*[@id='u_0_4']/div[1]/div[1]/div/a")
	WebElement lnk_user_name;

	@FindBy(linkText = "Account Settings")
	WebElement lnk_account_setting;

	@FindBy(linkText = "Log out")
	WebElement btn_sign_out;

	public AppLandingPage(WebDriver driver) {
		this.driver = driver;
	    PageFactory.initElements(new AjaxElementLocatorFactory(driver, TEST_CONF.getAjaxWaitSeconds()), this);
	}

	public AppLoginPage sign_out() {
		lnk_account_setting.click();
		btn_sign_out.click();
		return new AppLoginPage(driver);
	}

}


