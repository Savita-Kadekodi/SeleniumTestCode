package com.crm.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.Contacts;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.AddNewContact;
import com.crm.qa.pages.EditNewContact;


public class ContactsPageTest extends TestBase{
	
		LoginPage LoginPage;
		HomePage HomePage;
		Contacts Contacts;
		AddNewContact AddNewContact;
		EditNewContact EditNewContact;
		
		
		public ContactsPageTest() {
			super();
		}
		
		@BeforeMethod
		public void setUp() {
		
		  initialization();
		  LoginPage=new LoginPage();
		  HomePage = LoginPage.login(prop.getProperty("email"),prop.getProperty("password"));
		  Contacts = HomePage.ClickContactsMenu();		 
		}
		

		//@Test
		public void goToContactsPageTest() {
			Contacts= Contacts.TableTitle();
		}
		
		//@Test
		public void verifyContactsPageTitleNorecordMsg() {
			Contacts = Contacts.TableTitle();
			Contacts = Contacts.noRecordsMessage();					
		}
		
		//@Test
		public void DeleteContactTest() {
			Contacts = Contacts.TableTitle();
			Contacts = Contacts.DeleteContact();					
		}
		
		@Test
		public void editContactTest() {
			Contacts = Contacts.TableTitle();
			Contacts = Contacts.DeleteContact();
			EditNewContact = Contacts.EditContact();		
		}		
			
		//@AfterMethod
		public void tearDownMenu() {
			driver.quit();
		}
		
	

}
