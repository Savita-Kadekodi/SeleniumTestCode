package com.crm.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class CalenderPage extends TestBase {
	
	@FindBy(xpath="//span[text()='Calendar']")
	WebElement CalenderLink;
	
	
	
	//++++++++++++++++++++++++++++++++++++
	public  CalenderPage() {
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	
	public void clickCalenderLink() {
	CalenderLink.click();
	
	
	 
	
	
	}
	
	

}
