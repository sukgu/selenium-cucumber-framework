package com.selenium.steps;

import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebDriver;

import com.selenium.modules.HomePageRightWidgetAction;

import cucumber.api.java.en.Then;

public class ProductList {

	public WebDriver driver;
	public static List<String> datamap = null;
	HashMap<String,String> sampleData = null;
	
	public ProductList()
    {
    	driver = Hooks.driver;
    }
	
	@Then("^I click on item$")
    public void i_test_home_page_cards() throws Throwable {
        HomePageRightWidgetAction.Execute(driver, null);
    }
}
