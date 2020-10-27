package com.crm.qa.pages;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase {
	
	//Page Factory - OR(object repo)
	
 @FindBy(xpath="//span[text()='Log In']")
 WebElement Login;
 
 @FindBy(name="email")
 WebElement email;
 
 @FindBy(name ="password")
 WebElement password;
 
 @FindBy(xpath="//div[contains(text(),'Login')]")
 WebElement LoginBtn;
 
 @FindBy(xpath="//img[contains(@class,'img-responsive')]")
 WebElement crmlogo; 
 
 @FindBy(xpath="//div[@class='intercom-block-paragraph e19rsvrm0 intercom-1d3znxz']")
 WebElement WelcomePopup;
 
 @FindBy(xpath="//iframe[@name='intercom-borderless-frame']")
 WebElement welcomeIframe;
 
 @FindBy(xpath="//div[@id='st-2']")
 WebElement leftPane;
 
 
 
 //initalize elements in the class using pagefactory.initElements method 
 //'this' initializes all the elements within this class
 
 public LoginPage(){
	 PageFactory.initElements(driver, this);
	 
 }
 
 //Actions
 //Below action creation is also called creating object and we use this in the test pages.
 public String validateLoginPageTitle() {	 
	 return driver.getTitle();
 }
 
 public boolean validateCRMImage() {	 
	 return crmlogo.isDisplayed();
 }
 
 public String WelcomePopUpMessage() throws InterruptedException {
	
	 synchronized (driver) {
        WaitForObject(welcomeIframe);
            driver.wait();       
     } 
	
	driver.switchTo().frame("intercom-borderless-frame");
	wait(2000);	
	
	return WelcomePopup.getText();
 }
 
 public String chkLoginButtonColor(String em, String Pwd) {
	 WaitForObject(Login);
	 Login.click();	
	 WaitForObject(email);
	 
	// return the login btn color
	 return LoginBtn.getCssValue("color");
 }
 
 public String chkLoginBtn_BackGroundColor(String em, String Pwd) {
	 WaitForObject(Login);
	 Login.click();	
	 WaitForObject(email);
	 
 	 //return the login btn background color 	 
	 return LoginBtn.getCssValue("background-color");
 }
 
 public String getLoginButtonText(String em, String Pwd) {
	 WaitForObject(Login);
	 Login.click();	
	 WaitForObject(email);
	 
	 //return the login button text value
	 return LoginBtn.getText();
 }
  
 
 public LoginPage chkLoginBtn_CSSValues(String em, String Pwd) {
	 WaitForObject(Login);
	 Login.click();	
	 WaitForObject(email);
	 
 	 //return theFont size of LoginButton text 
	 String fontSize= LoginBtn.getCssValue("font-size");
	 System.out.println("Font size is "+ fontSize);
	 
	 String fontWeight = LoginBtn.getCssValue("font-Weight");
	 System.out.println("Font weight is "+ fontWeight);
	
	 String fontStyle = LoginBtn.getCssValue("font-Style");
	 System.out.println("Font style is "+ fontStyle);
	 
	 String textAlign = LoginBtn.getCssValue("text-align");
	 System.out.println("Text align is "+ textAlign);	 
	 
	 String margin = LoginBtn.getCssValue("margin");
	 System.out.println("Margin added is "+ margin);	 
	 
	 String padding = LoginBtn.getCssValue("padding");
	 System.out.println("Padding added "+ padding);
	 
	 return new LoginPage();
 }
 
 
 
 
 
 
 
 
  
 public HomePage login( String em, String Pwd) {
	 WaitForObject(Login);
	 Login.click();	
	 WaitForObject(email);	
	 
	 //Enter email address set in config file
	 email.sendKeys(em);	 
	 
	 // Enter Password and hit keyboard Enter key to login
	 password.sendKeys(Pwd + Keys.ENTER); 	 
	 
	 return new HomePage();
	 
 }
 
 public LoginPage clickFBShareButton() {
	 
	 List<WebElement> nameList= leftPane.findElements(By.tagName("div"));
	 
	 //Total number of share buttons available
	 
	 int shareButtonCount =  nameList.size();
	 System.out.println("Total no of share buttons in left panel " + shareButtonCount);
	 
	 //Click FB share button
			   
	 //nameList.get(1).click();
	 
	 //or we can use the svg image info added in xpath like this: 
	 
	 leftPane.findElement(By.xpath("//img[@src='https://platform-cdn.sharethis.com/img/facebook.svg']")).click();  
	 	
	 return new LoginPage();
 }
 
  
 
}