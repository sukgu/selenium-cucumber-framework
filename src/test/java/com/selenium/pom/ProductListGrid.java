package com.selenium.pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import com.selenium.config.TestConf;

public class ProductListGrid {
	
	private final WebDriver driver;
	private static final TestConf TEST_CONF = TestConf.get();
	
	@FindBy(id = "products")
	WebElement products_section;
	
	@FindBy(xpath = "//div[@id='products']/section/div")
	List<WebElement> product_list;
	
	
	public ProductListGrid(WebDriver driver) {
		this.driver = driver;
	    PageFactory.initElements(new AjaxElementLocatorFactory(driver, TEST_CONF.getAjaxWaitSeconds()), this);
	}
	
	public void clickOnProduct() {
		product_list.get(0).findElement(By.linkText("United Colors of Benetton Blue Round T-Shirt")).click();
	}

}
