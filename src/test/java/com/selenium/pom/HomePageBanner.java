package com.selenium.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import com.selenium.config.TestConf;

public class HomePageBanner {

	private final WebDriver driver;
	private static final TestConf TEST_CONF = TestConf.get();
	
	@FindBy(css = "div.banner-item.active")
	WebElement banner_active_link;
	
	@FindBy(css = "div.banner-image.platBanner.banner-active.shown")
	WebElement top_banner;
	
	@FindBy(css = "div.banner-link.bar")
	WebElement banner_link_bar;
	
	
	public HomePageBanner(WebDriver driver) {
		this.driver = driver;
	    PageFactory.initElements(new AjaxElementLocatorFactory(driver, TEST_CONF.getAjaxWaitSeconds()), this);
	}
	
	public void clickOnActiveBanner() {
		top_banner.click();
	}
	
	public void clickOnBannerWithText(String text) {
		banner_link_bar.findElement(By.xpath("//div[contains(text(),\""+text+"\")]"));
	}
	
}
