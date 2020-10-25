package com.crm.qa.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class ContactSavedPage extends TestBase{
	
	
	@FindBy(xpath ="//div[@class='field']")
	WebElement SegmentForm;
	
	@FindBy(xpath="//div[text()='Middle Name(s)']")
	WebElement MiddleName;
	
	@FindBy(xpath="//div[@class='ui header item mb5 light-black']")
	WebElement ContactFullName;
	
	
	
	
	//++++++++++++++++++++++++++
	
	public ContactSavedPage() {
		
		PageFactory.initElements(driver, this);
	}
	
	//+++++++++++++++++++++++++++++++
		
	//Actions
		
	public ContactSavedPage ContactSavedValues() {		
				
		/*WaitForObject(MiddleName);
		
			if (MiddleName.isDisplayed()) {
				System.out.println("middle name displayed");
			}
		*/
	String contname= ContactFullName.getText();
			System.out.println(contname);
		return new ContactSavedPage();
	}
	
	
}
