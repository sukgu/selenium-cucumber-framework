package com.selenium.steps;

import java.util.HashMap;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.selenium.modules.SignInAction;
import com.selenium.modules.SignOutAction;
import com.selenium.pom.AppLoginPage;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class TestLoginLogout {
	
	public WebDriver driver;
	public static List<String> datamap = null;
	HashMap<String,String> sampleData = null;
	
	public TestLoginLogout()
    {
    	driver = Hooks.driver;
    	
    	/*datamap = new ArrayList<HashMap<String,String>>();
    	HashMap<String,String> sampleData = new HashMap<String,String>();
    	sampleData.put("username","disha.pathak2792@gmail.com");
    	sampleData.put("password","bhend@2chod");
    	System.out.println("Current data" +sampleData);
    	datamap.add(sampleData);*/
    }
	
	@When("^I open snapdeal website$")
    public void i_open_snapdeal_website() throws Throwable {
    	driver.get("https://www.snapdeal.com");
    }

    @When("^I sign in with \"([^\"]*)\" and \"([^\"]*)\"$")
    public void i_sign_in(String username, String password) throws Throwable {
    	sampleData = new HashMap<String,String>();
    	sampleData.put("username", username);
    	sampleData.put("password", password);
    	PageFactory.initElements(driver, AppLoginPage.class);
		SignInAction.Execute(driver,sampleData);
    }

    @Then("^I sign out$")
    public void i_sign_out() throws Throwable {
    	SignOutAction.Execute(driver);
    }

}
