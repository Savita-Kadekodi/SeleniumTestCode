package com.crm.qa.testcases;


import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.AddNewContact;
import com.crm.qa.pages.Contacts;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.ContactConfirmation;

public class ContactConfirmationPage extends TestBase {
	
	LoginPage LoginPage;
	HomePage HomePage;
	Contacts Contacts;
	AddNewContact AddNewContact;
	ContactConfirmation ContactConfirmation;
		
	public ContactConfirmationPage() {
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
	public void createNewContacts() {
		
		AddNewContact = Contacts.clickNewButton(); 
		ContactConfirmation = AddNewContact.createNewContact();
		Contacts= ContactConfirmation.verifyContactNameSaved();				
	}
		
	//@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	

}
