package com.crm.qa.testcases;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.LoginPage;

public class LoginTest extends TestBase {
	
	LoginPage LoginPage;
	com.crm.qa.pages.HomePage HomePage;
	
	public LoginTest(){
		//calling super class which is TestBase class that has prop and other methods
		super();		
	}
	
	@BeforeMethod	
	public void setUp(){		
		initialization();
		LoginPage = new LoginPage(); 
		 
	}
	
	//@Test(priority=1)
	public void loginTest() {
		
		HomePage=LoginPage.login(prop.getProperty("email"),prop.getProperty("password"));
		
	}	
	
	//@Test(priority=2)
	public void loginPageTitleTest() {		
		String title = LoginPage.validateLoginPageTitle();
		//in assertEquls select the one from testNG not from junit
		Assert.assertEquals(title, "#1 Free CRM customer relationship management software cloud");	
		
	}
	
	
	//@Test(priority=3)
	public void crmLogoImageTest() {
		boolean flag= LoginPage.validateCRMImage();
		Assert.assertTrue(flag);			
	}	
	
	
	//@Test(priority=4)
	public void VerifyLoginButtoncolor() {
	
		String C= LoginPage.chkLoginButtonColor(prop.getProperty("email"),prop.getProperty("password"));
		System.out.println("color is "+ C);
		
		//Convert the color to hex to get the readable value	
		String hex = Color.fromString(C).asHex(); 	
		if(hex.contains("#ffffff")) {	 		
	 		System.out.println("login button color is white");	 		
	 	} else System.out.println("some error");
	 
	}
	
	
	//@Test(priority=5)
	public void VerifyLoginButton_Backgrdcolor() {
	
		String C1= LoginPage.chkLoginBtn_BackGroundColor(prop.getProperty("email"),prop.getProperty("password"));
		System.out.println("color is "+ C1);
		
		//Convert the color to hex to get the readable value	
		String hex1= Color.fromString(C1).asHex();
		 
	 	if(hex1.contains("2185d0")){	 		
	 		System.out.println("Login btn background color is Strong blue" );	
	 	}else {
	 		System.out.println("some error");
	 	}	 
	 
	}
	
	@Test(priority=6)
	public void verifyLoginButtinText() {
		
		//get the login button text
		 String loginBtnText = LoginPage.getLoginButtonText(prop.getProperty("email"),prop.getProperty("password"));
			 
		 	if(loginBtnText.contains("Login")) {
		 		System.out.println("Login button text verified");
		 	}		 
	}
	
	
	
	//@Test
	public void validateWelcomePopUptest() throws InterruptedException {	
		String WelcomePopUPText=LoginPage.WelcomePopUpMessage();
		 if (WelcomePopUPText.contains("We have a powerful Free CRM platform that is multi-user and has unlimited data.  It's a fully-featured CRM that's free and easy to use for your whole company or organization.  Sign up now, no credit card required.")) {
			 System.out.println("Welcome text verified");
		 }
	}
	
	
	//@DataProvider
	public void getTestData() {
		
		
	}
	
	
	
	
	
	
	//@AfterMethod	
	public void tearDown() {
		driver.quit();
	}
	

}
