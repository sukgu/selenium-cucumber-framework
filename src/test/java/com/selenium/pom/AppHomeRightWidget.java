package com.selenium.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import com.selenium.config.TestConf;

public class AppHomeRightWidget {
	
	private final WebDriver driver;
	private static final TestConf TEST_CONF = TestConf.get();
	
	@FindBy(css = "div.next-Best-Action-Widget")
	WebElement cards_section;
	
	@FindBy(xpath = "//span[contains(text(),'NEXT')]")
	WebElement btn_next;
	
	@FindBy(linkText = "View Details")
	WebElement btn_view_details;
	
	@FindBy(linkText = "Change Pincode")
	WebElement btn_change_pincode;
	
	@FindBy(xpath = "//div[contains(text(),'Pincode:')]")
	WebElement txt_change_pincode;
	
	@FindBy(id = "pincode-check-nba")
	WebElement input_pincode;

	@FindBy(css = ".superDealText")
	WebElement txt_superdeal;
	
	@FindBy(css = ".pincodeActnWidget")
	WebElement widget_pincode;
	
	@FindBy(css = ".superDealOfTheDayWidget")
	WebElement widget_superdeal;
	
	@FindBy(css = ".nbaGenericWidget")
	WebElement widget_generic;
	
	@FindBy(css = ".nbaDonationWidget")
	WebElement widget_donation;
	
	@FindBy(xpath = "//div[@class='next-Best-Action-Widget']/div/ul/li[@class='nbaGenericWidget']/div[@class='nextBestActionControls']/a")
	WebElement btn_generic_first;
	
	@FindBy(css = "//div[@class='next-Best-Action-Widget']/div/ul/li[@class='superDealOfTheDayWidget']/div[@class='nextBestActionControls']/a")
	WebElement btn_superdeal_first;
	
	@FindBy(css = "//div[@class='next-Best-Action-Widget']/div/ul/li[@class='pincodeActnWidget']/div[@class='nextBestActionControls']/a")
	WebElement btn_pincode_first;
	
	@FindBy(css = "//div[@class='next-Best-Action-Widget']/div/ul/li[@class='nbaDonationWidget']/div[@class='nextBestActionControls']/a")
	WebElement btn_donation_first;
	
	public AppHomeRightWidget(WebDriver driver) {
		this.driver = driver;
	    PageFactory.initElements(new AjaxElementLocatorFactory(driver, TEST_CONF.getAjaxWaitSeconds()), this);
	}
	
	public void clickOnNext() {
		btn_next.click();
	}
	
	public void clickOnButton(WebElement element) {
		element.click();
	}
	
	public void clickOnPincodeText() {
		txt_change_pincode.click();
	}
	
	public void enterPincode(String pincode) {
		input_pincode.sendKeys(pincode);
	}
	
	public String getPincode() {
		return txt_change_pincode.getText().replace("Pincode:", "");
	}
	

}
