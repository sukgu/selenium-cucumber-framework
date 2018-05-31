package com.selenium.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import com.selenium.config.TestConf;

public class AppLoginPage {
	
	private final WebDriver driver;
	private static final TestConf TEST_CONF = TestConf.get();
	
	@FindBy(xpath = "//*[contains(text(),'Sign In')]")
	WebElement txt_sign_in;
	
	@FindBy(linkText = "LOGIN")
	WebElement txt_login;
	
	@FindBy(xpath = "//input[@id='userName']")
	WebElement input_username;
	
	@FindBy(id = "loginIframe")
	WebElement frame_login;
	
	@FindBy(id = "j_password_login_uc")
	WebElement input_password;
	
	@FindBy(xpath = "//button[contains(., 'continue')]")
	WebElement button_continue;
	
	@FindBy(xpath = "//button[@id='submitLoginUC']")
	WebElement button_login;
	
	public WebElement getInputPassword() {
		return input_password;
	}
	
	public WebElement getLoginButton() {
		return button_login;
	}
	
	public AppLoginPage(WebDriver driver) {
		this.driver = driver;
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, TEST_CONF.getAjaxWaitSeconds()), this);
	}
	
	public WebElement getLoginFrame() {
		return frame_login;
	}
	
	public AppLoginPage setEmail(String email) {
		input_username.click();
		input_username.sendKeys(email);
		return this;
	}
	
	public AppLoginPage setPassword(String password) {
		input_password.click();
		input_password.sendKeys(password);
		return this;
	}
	
	public void clickOnContinue() {
		button_continue.click();
	}
	
	public void hoverOnSignInText() {
		Actions actions = new Actions(driver);
		actions.moveToElement(txt_sign_in).perform();
	}
	
	public void clickOnLoginText() {
		txt_login.click();
	}
	
	public AppHomePage clickOnLogin() {
		button_login.click();
		return new AppHomePage(driver);
	}
	
	
	/*public FBHomePage loginToFBAsValidUser(String username, String password) {
	    driver.findElement(By.ById.id(email)).sendKeys(username);
	    driver.findElement(By.ById.id(pass)).sendKeys(password);
	    driver.findElement(By.ByCssSelector.cssSelector(loginButton)).click();
	    
	    try{
	           File f = new File("browser.data");
	           FileReader fr = new FileReader(f);
	           BufferedReader br = new BufferedReader(fr);
	           String line;
	           while((line=br.readLine())!=null){
	               StringTokenizer str = new StringTokenizer(line,";");
	               while(str.hasMoreTokens()){
	                   String name = str.nextToken();
	                   String value = str.nextToken();
	                   String domain = str.nextToken();
	                   String path = str.nextToken();
	                   Date expiry = null;
	                   String dt;
	                   if(!(dt=str.nextToken()).equals("null")){
	                	   SimpleDateFormat formatter = new SimpleDateFormat("E MMM dd HH:mm:ss z yyyy");
	                       expiry = formatter.parse(dt);
	                   }
	                   boolean isSecure = new Boolean(str.nextToken()).booleanValue();
	                   Cookie ck = new Cookie(name,value,domain,path,expiry,isSecure);
	                   driver.manage().addCookie(ck);
	               }
	           }
	      }catch(Exception ex){
	           ex.printStackTrace();
	      }
	      driver.get("http://www.facebook.com");
	    
	    return new FBHomePage(driver);
	  }*/
	
	/*public FBLoginPage loginToFBAsInvalidUser(String username, String password) {
		driver.findElement(By.ById.id(email)).sendKeys(username);
		driver.findElement(By.ById.id(pass)).sendKeys(password);
		driver.findElement(By.ByCssSelector.cssSelector(loginButton)).click();
		
	    return this;
	  }*/
	
}
