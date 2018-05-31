package com.selenium.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import com.selenium.config.TestConf;

public class AppHomePage {
	
	private final WebDriver driver;
	private static final TestConf TEST_CONF = TestConf.get();
	
	@FindBy(xpath = "//*[@id='u_0_4']/div[1]/div[1]/div/a/span")
	WebElement txt_user_name;
	
	@FindBy(xpath = "//*[@id='u_0_4']/div[1]/div[1]/div/a")
	WebElement lnk_user_name;
	
	@FindBy(css = ".sd-icon-user")
	WebElement link_profile_pic;
	
	@FindBy(linkText = "LOGOUT")
	WebElement btn_sign_out;
	
	public AppHomePage loadUsing( WebDriver driver) {
        driver.get(TEST_CONF.getBaseUrl());
        return new AppHomePage(driver);
    }
	
	public AppHomePage(WebDriver driver) {
		this.driver = driver;
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, TEST_CONF.getAjaxWaitSeconds()), this);
	}
	
	public void hoverOnProfilePic() {
		Actions actions = new Actions(driver);
		actions.moveToElement(link_profile_pic).perform();
	}
	
	public AppLoginPage clickOnSignOut() {
		btn_sign_out.click();
		return new AppLoginPage(driver);
	}
	
}
