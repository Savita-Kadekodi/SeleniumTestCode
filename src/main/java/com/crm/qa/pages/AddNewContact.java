package com.crm.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class AddNewContact extends TestBase{
	
	
	@FindBy(xpath="//input[@name='first_name']")
	WebElement firstname;
	
	@FindBy(xpath="//input[@name='last_name']")
	WebElement last_name;
	
	@FindBy(xpath="//div[@name='company']")
	WebElement company;
	
	@FindBy(xpath="//button[@class='ui linkedin button']")
	WebElement btnSave;

	@FindBy(xpath="//div[text()='Error']")
	WebElement Error;
	
	@FindBy(xpath="//p[text()='The field First Name is required']")
	WebElement firstNameError;
	
	@FindBy(xpath="//p[text()='The field Last Name is required']")
	WebElement lastNameError;
		
	@FindBy(xpath="//button[@class='ui red button']")
	WebElement btnOK; 
	
	@FindBy(xpath="//div[@name='category'] //i[@class='dropdown icon']")
	WebElement CategoryDropDownIcon;
	
	@FindBy(xpath="//div[@class='visible menu transition']")
	WebElement CategoryDropDown;
	
	@FindBy(xpath="//span[text()='Lead']")
	WebElement CategoryLead;
	
	@FindBy(xpath="//div[@class='ui header item mb5 light-black']")
	WebElement SavedContactName;	
		
	@FindBy(xpath="//button[text()='New']")
	WebElement BtnNew;
	
	
		
	//The field First Name is required The field Last Name is required
//+++++++++++++++++++++++++++++++++++++++++++++
	
	public  AddNewContact() {
		
		PageFactory.initElements(driver, this);
	}
//+++++++++++++++++++++++++++++++++++++++++++++
	
	//Actions
	
	public AddNewContact saveContactNoValueAdded(){
		 WaitForObject(firstname);	
		 btnSave.click();	
		 WaitForObject(Error);
		 String ErrMsgFN= firstNameError.getText();
		 String ErrMsgLN= lastNameError.getText();
		 
		 if (ErrMsgFN.contains("The field First Name is required") && ErrMsgLN.contains("The field Last Name is required")) {
			 System.out.println("Displays expected FirstName and LastName required message");
			 
			 WaitForClickableObject(btnOK);
			 
			 if(btnOK.isDisplayed()) {				 
				 btnOK.click();
				 WaitForObject(btnSave);
			 }else {
				 System.out.println("Error: OK button not displayed");
			 }
			 
		 }else {
			 System.out.println("Error: Expected error message NOT displayed");
		 }
		 
		return new AddNewContact();
	}
	
	public ContactConfirmation createNewContact(){		
		
		/*
		int i= CategoryDropDown.findElements(By.tagName("span")).size();
		System.out.println(i);*/
		
			 
			 CategoryDropDownIcon.click();
			 CategoryDropDown.findElements(By.tagName("span")).get(1).click();
			 firstname.sendKeys("test" + fnGenerateRandomNum(100,300));
			 //String fnSaved = firstname.getText();
			 			 
			 last_name.sendKeys("Hegde "+ fnGenerateRandomNum(100,300));
			// String lnSaved = last_name.getText();			 			 
			 	 			 
			 btnSave.click();
			 			 		
		return new ContactConfirmation();
	}
	
	
}
