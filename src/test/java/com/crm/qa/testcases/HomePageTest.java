package com.crm.qa.testcases;

import org.junit.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.Contacts;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

	

public class HomePageTest extends TestBase{
	
	LoginPage LoginPage;
	HomePage HomePage;
	Contacts Conacts;
	
	
	public HomePageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
	
	  initialization();
	  LoginPage=new LoginPage();
	  HomePage = LoginPage.login(prop.getProperty("email"),prop.getProperty("password"));
	}
				
	@Test
	public void verifyLoggedInUserTest() {	  
	  String username = HomePage.VerifyLoggedInUser();
	  System.out.println(username);
	  //with assertions we can enter a message that will be displayed in report if assertion fails
	   Assert.assertEquals(username, "Savita Kadekodi", "Incorrect username");
	}
	
	//@Test
	public void LogOut() {
		LoginPage= HomePage.LogOut();
		
	}
	
		
	//@AfterMethod
	public void tearDownMenu() {
		driver.quit();
	}
	

}
