package com.selenium.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestAutomation {

	public static void main(String[] args) {
		String line="OK (444 tests)";
		String pattern = "(.*)(\\d+)(.*)";//"(.*)(OK (4 tests))(.*)";
		Pattern r = Pattern.compile(pattern);
		Matcher m = r.matcher(line);
		if(line.matches("(^OK)(\\s)(.)((\\d)|(\\d\\d)|(\\d\\d\\d))(\\s)(tests)(.$)")) {
			System.out.println("mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm");
		}
		if(m.find()) {
			System.out.println(m.group(0));
			System.out.println(m.group(1));
			System.out.println(m.group(2));
		}
	
	}
	/*WebDriver driver;
	String username="";
	String password="";
	
	@BeforeTest
	public void startDriver()
	{
		driver=new FirefoxDriver();
	}
	
	@AfterTest
	public void stopDriver()
	{
		driver.close();
	}
	
	@Test
	public void loginCheck()
	{
		//open web page
		driver.get("http://www.facebook.com");
		
		if(driver.findElement(By.ById.id("email"))!=null)
		{
			driver.findElement(By.ById.id("email")).sendKeys(username);
		}
		
		if(driver.findElement(By.ById.id("pass"))!=null)
		{
			driver.findElement(By.ById.id("pass")).sendKeys(password);
		}
		
		if(driver.findElement(By.ByCssSelector.cssSelector("input[id=u_0_n]"))!=null)
		{
			driver.findElement(By.ByCssSelector.cssSelector("input[id=u_0_n]")).click();
		}
	}
*/
}
