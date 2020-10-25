package com.crm.qa.testcases;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.Contacts;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.EditNewContact;

public class EditNewContactTest extends TestBase{
	LoginPage LoginPage;
	HomePage HomePage;
	Contacts Contacts;
	EditNewContact EditNewContact;
	
	public EditNewContactTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {		
	  initialization();
	  LoginPage=new LoginPage();
	  HomePage = LoginPage.login(prop.getProperty("email"),prop.getProperty("password"));
	  Contacts = HomePage.ClickContactsMenu();		
	}	
	
	@Test
	public void EditUserContactinfo() throws InterruptedException{
	  Contacts=Contacts.TableTitle();
	  EditNewContact=Contacts.EditContact();	
	  EditNewContact=EditNewContact.editChannelType();
	}

}
