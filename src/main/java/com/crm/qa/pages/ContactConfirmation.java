package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class ContactConfirmation extends TestBase{
	
	@FindBy(xpath="//div[@class='ui header item mb5 light-black']")
	WebElement SavedContactName;
	
	@FindBy(xpath="//*[text()='Contacts']")
	WebElement ContactsMenu;
//+++++++++++++++++++++++++++++++++++++++++++++
	
	public ContactConfirmation() {
		
	   PageFactory.initElements(driver, this);
	}
//+++++++++++++++++++++++++++++++++++++++++++++

	public Contacts verifyContactNameSaved() {
		String savedname = SavedContactName.getText();
		System.out.println(savedname);		
		ContactsMenu.click();
		return new Contacts();		
		
	}
	
}
