package com.crm.qa.testcases;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.Contacts;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.AddNewContact;
public class AddNewContactPage extends TestBase{
	
	LoginPage LoginPage;
	HomePage HomePage;
	Contacts Contacts;
	AddNewContact AddNewContact;
	
	public AddNewContactPage() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		
		initialization();
		LoginPage LoginPage = new LoginPage();
		HomePage = LoginPage.login(prop.getProperty("email"),prop.getProperty("password"));
		Contacts = HomePage.ClickContactsMenu();
	}
	
	@Test
	public void saveContactWithNoValueAdded() {
		AddNewContact = Contacts.clickNewButton(); 
		AddNewContact = AddNewContact.saveContactNoValueAdded();
	}	
		
	//@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	
	

}
