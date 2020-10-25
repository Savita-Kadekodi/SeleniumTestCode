package com.crm.qa.pages;



import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase{
	
	@FindBy(xpath="//span[text()='Savita Kadekodi']")
	WebElement LoggedUser;
	
	@FindBy(xpath="//span[text()='Contacts']")
	WebElement ContactsMenu;
	
	@FindBy(xpath="//i[@class='settings icon']")
	WebElement SettingIcon;
	
	@FindBy(xpath="//span[text()='Log Out']")
	WebElement LogOut;
	
//++++++++++++++++++++++++++++++++++		

	public HomePage() {
		
		PageFactory.initElements(driver, this);
	}
//+++++++++++++++++++++++++++++++++++
	
	//Actions
	
	public String VerifyLoggedInUser() {
		return LoggedUser.getText();
	}
		
	public Contacts ClickContactsMenu() {
		
		WaitForObject(ContactsMenu);
		if (ContactsMenu.isDisplayed()){
			
			ContactsMenu.click();
		}else {
			System.out.println("Contacts Menu not displayed");
		}		
		
		return new Contacts();
	}
	
	public LoginPage LogOut() {
		
		WaitForClickableObject(SettingIcon);
		
		if(SettingIcon.isDisplayed()) {
			System.out.println("Setting Button displayed");
		}
		SettingIcon.click();
		WaitForClickableObject(LogOut);
		LogOut.click();
		return new LoginPage();
		
	}




}

