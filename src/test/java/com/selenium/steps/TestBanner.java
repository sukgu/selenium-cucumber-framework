package com.selenium.steps;

import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebDriver;

import com.selenium.modules.HomePageBannerAction;
import cucumber.api.java.en.Then;

public class TestBanner {
	
	public WebDriver driver;
	public static List<String> datamap = null;
	HashMap<String,String> sampleData = null;
	
	public TestBanner()
    {
    	driver = Hooks.driver;
    }
	
	@Then("^I click on active banner link$")
    public void i_click_on_active_banner_link() throws Throwable {
        HomePageBannerAction.Execute(driver, null);
    }

}
