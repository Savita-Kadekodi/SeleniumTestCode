package com.crm.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import com.crm.qa.base.TestBase;

public class EditNewContact extends TestBase{
	
	@FindBy(xpath="//button[@class='ui linkedin button']")
	WebElement SaveBtn;
	
	@FindBy(xpath="//div[@name ='channel_type']//i[@class='dropdown icon'] ")
	WebElement ChannelDropDownBtn;
	
	@FindBy(xpath="//div[@class='visible menu transition']")
	WebElement DropdownWindow;
	
	@FindBy(xpath="//div[@name='channel_type']")
	WebElement Channel;	
	
	@FindBy(xpath="//div[@class='ui toggle checkbox']")	
	WebElement DoNotCallToggleOff;
	
	@FindBy(xpath="//div[@class='ui toggle checkbox']//label[text()='Do not Call']")
	WebElement DoNotCallLabel_toggleTurnedOff;
	
	@FindBy(xpath="//div[@class='ui checked toggle checkbox']//label[text()='Do not Call']")
	WebElement DoNotCallLabel_toggleTurnedOn;
	
	@FindBy(xpath="//div[@class='ui checked toggle checkbox']")
	WebElement DoNotCallToggleOn;		
	
	@FindBy(xpath="//input[@name='image']")
	WebElement imageInputBox;	
	
	@FindBy(xpath="//div[@class='ui small icon input']")
	WebElement DayField;
	
	@FindBy(xpath="//input[@name='day']")
	WebElement dayInputBox;
	
	@FindBy(xpath="//div[@name='month']//i[@class='dropdown icon']")
	WebElement MonthDropDownIcon;
	
	@FindBy(xpath="//input[@name='year']")
	WebElement YearInputBox;	
	
	@FindBy(xpath="//button[@class='ui linkedin button']")
	WebElement btnSave;
	
	@FindBy(xpath="//input[@name='image']")
	WebElement imageField;
	
	
//+++++++++++++++++++++++++++++
	public EditNewContact(){
		
		PageFactory.initElements(driver, this);
	}
	
//+++++++++++++++++++++++++++++	
	
//Actions
	
	public EditNewContact editChannelType() throws InterruptedException{
		
		
		WaitForObject(ChannelDropDownBtn);
		
		ChannelDropDownBtn.click();
		WaitForObject(DropdownWindow);
		
				
		//get all the channel types available
		List<WebElement> totalChannelTypes = DropdownWindow.findElements(By.tagName("div"));
					
		//loop through all types and get the text
			for(int i=0; i<totalChannelTypes.size(); i++){
				String channelSelected = Channel.getText();
				System.out.println("selected channel " +channelSelected );				
				if(totalChannelTypes.get(i).getText().contains("Facebook"))				
				 {
				    totalChannelTypes.get(i).click();					
				 }
			}
			
		//Click 'Do Not Call' label to turn on or off the toggle
		List<WebElement> DoNotCallBtnLabel = driver.findElements(By.xpath("//label[text()='Do not Call']"));			
		DoNotCallBtnLabel.get(1).click();	
					
		//Select date
		dayInputBox.sendKeys("10");	
				
		//Select month
		MonthDropDownIcon.click();		
		WaitForObject(DropdownWindow);
		
		List<WebElement> months = DropdownWindow.findElements(By.tagName("div"));
			for (int x = 0; x<months.size();x++){
				
				String monthName=months.get(x).getText();
				  if (monthName.contains("January")){
				   months.get(x+1).click();
				  }				  			
			}
		//Select year
		YearInputBox.sendKeys("2020");	
		
		//Attach image
		imageField.sendKeys("Screenshot_20200917-095130_Gallery");
		
		
		//Save the edits
		btnSave.click();	
		return new EditNewContact();	
		
	   }		

}

