package com.crm.qa.pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crm.qa.base.TestBase;
import com.crm.qa.util.TestUtil;


public class Contacts extends TestBase {
	

		@FindBy(xpath="//table[contains(@class,'ui celled sortable striped table custom-grid table-scroll')]")
		WebElement ContactsTable;
		
		@FindBy(xpath="//div[@class='ui warning message']")
		WebElement NoRecords;
		
		@FindBy(xpath="//thead[@class='full-width']")
		WebElement TitleRow;
		
		@FindBy(xpath="//input[@type='checkbox']")
		WebElement ChkboxSelectAll;	
		
		@FindBy(xpath="//button[text()='New']")
		WebElement BtnNew;
		
		@FindBy(xpath="//p[text()='Are you sure you want to delete this record? Deleted records can be recovered via the rubbish bin']")
		WebElement MoveToBinText;
		
		@FindBy(xpath="//tbody")
		WebElement tbody;
		
		@FindBy(xpath="//button[text()='Delete']")
		WebElement DeleteContactBtn;
		
				
//++++++++++++++++++++++++++++++++++++++++++
		
	public Contacts() {		
		PageFactory.initElements(driver, this);
	}
//++++++++++++++++++++++++++++++++++++++++++++++++
	
//Actions	
	
	public Contacts TableTitle() {	
		
		WaitForObject(TitleRow);
		//Verify Table Title filed shows
		if(TitleRow.isDisplayed()) {
			System.out.println("Title row displayed");
			
			//Verify column names matches the array values 
			String[] columnNames = {"Name","Address","Category","Status","Phone","Email","Options"};
			int i = columnNames.length;
			
				for (int x=0; x<i; x++) {
					String titles = TitleRow.getText();	
					if(titles.contains(columnNames[x])){
						System.out.println("Expected column " +columnNames[x]+" is displayed");
					}			
					
				}
				
		}else {
			System.out.println("Error: Title row not displayed");
		}	
		return new Contacts();
	}
	
//++++++++++++++++++++++++++++++++++++

	public Contacts noRecordsMessage() {
		 
		String val = ContactsTable.findElement(By.tagName("td")).getText();
		if((val.isEmpty()) && NoRecords.isDisplayed()){
			System.out.println("Contacts table is empty and Warning message box is displayed");		
				 
			 } else {
				 System.out.println("Contacts table is not empty");
			 }
		return new Contacts();
	}
//+++++++++++++++++++++++++++++++++++

	public AddNewContact clickNewButton() {
		
		if(BtnNew.isDisplayed()) {
			System.out.println("Button New is displayed");
			BtnNew.click();
		}else {
			System.out.println("Error : Button New NOT displayed");
		}
		return new AddNewContact();
	}
	
//+++++++++++++++++++++++++++++++
	
	public EditNewContact EditContact() {	
		
		int rowVal = ContactsTable.findElements(By.tagName("tr")).size();
		System.out.println("total rows " +rowVal);	
				
			if(rowVal>0) {
				
				System.out.println("Contacts table is NOT empty");
				
				List<WebElement> ArrCells=ContactsTable.findElements(By.tagName("tr"));
				List<WebElement>  ArrCols = ArrCells.get(1).findElements(By.tagName("td"));


				ArrCols.get(0).findElement(By.tagName("div")).click();
				ArrCols.get(7).findElements(By.tagName("button")).get(1).click();			
			
				
			}
			return new EditNewContact();
	}
//+++++++++++++++++++++++++++++++++++++++++
	
	public Contacts DeleteContact() {	
		
		int trows = ContactsTable.findElements(By.tagName("tr")).size();
		System.out.println("total rows " +trows);	
		
		
			if(trows>0) {
				
				System.out.println("Contacts table is NOT empty");				
				
				List<WebElement> ArrCells=ContactsTable.findElements(By.tagName("tr"));
				List<WebElement>  ArrCols = ArrCells.get(1).findElements(By.tagName("td"));


				ArrCols.get(0).findElement(By.tagName("div")).click();
				ArrCols.get(7).findElements(By.tagName("button")).get(3).click();
				
				//Delete popup  
				String MoveToTheBinText= MoveToBinText.getText();

					if( MoveToTheBinText.equals("Are you sure you want to delete this record? Deleted records can be recovered via the rubbish bin")) {
						System.out.println("Expected alert message displayed");
					}else{
						System.out.println("Error: Not a valid message");
					}
				
				DeleteContactBtn.click();
				
			}
			return new Contacts();
	}
//+++++++++++++++++++++++++++++++++++++++++++		
	
	
}

	
	
	


