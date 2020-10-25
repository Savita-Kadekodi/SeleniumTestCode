package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crm.qa.util.TestUtil;

public class TestBase {
	
	
	public static WebDriver driver;
	public static Properties prop;
	
	
	public TestBase(){			
		
		try{
			//using prop method read the values from config file			
			prop = new Properties();
			//fileinputstream method forms connection between java and config files
			FileInputStream ip = new FileInputStream("C:\\Users\\Savita\\eclipse-workspace\\FreeCRMTest\\src\\main\\java\\com\\crm\\qa\\config\\config.properties");
			//Load the values from config file
			prop.load(ip);				
		}
			catch(FileNotFoundException e){
			e.printStackTrace();
		}	catch(IOException e){
			e.printStackTrace();
		}
			
	}
	
	public static void initialization() {
	String browserName = prop.getProperty("browser");
	
	if(browserName.equals("chrome")){		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Savita\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");		
		driver = new ChromeDriver();		
	}else if(browserName.equals("FF")){		
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\Savita\\Downloads\\geckodriver-v0.27.0-win64\\geckodriver.exe");						
		driver = new FirefoxDriver();				
	}
	
	//fn to maximise the screen
	driver.manage().window().maximize();
	//delete all cookies
	driver.manage().deleteAllCookies();
	//page load timeout, wait time may needs change so declared in util file and get the value here 
	driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
	//implicit wait, wait time may needs change so declared in util file and get the value here 
	driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
	
	
	
	//Launch browser
	driver.get(prop.getProperty("url"));
	
  }
	public static void WaitForObject(WebElement element){
		new WebDriverWait(driver, 40).until(ExpectedConditions.visibilityOf(element));
		
	}
	
	public static void WaitForClickableObject(WebElement element) {
		new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(element));
		
	}
	// Generate Random Number 					
	public static String fnGenerateRandomNum(int intMin, int intMax)
		{
			Random RefRand = new Random();
			int intNum = (RefRand.nextInt(intMax-intMin) + 1) + intMin;
			//Convert Integer to String
			return Integer.toString(intNum);
			//string.substring(index)
			
		}
	
	
	
	public static void selectDateByJS(WebDriver driver, WebElement element, String dateVal) {
		JavascriptExecutor je= ((JavascriptExecutor)driver);
		
		//here we are setting the dateVal ( the date value we are inputting) value to the attribute'value' directly in the  
		//DOM. When we do F12 and see the calendar, it may have diff value set for 'Value' attribute
		//We are setting now that to the date we need to select in the calendar
		//dateVal is passed here as a parameter by adding + on either side
		
		je.executeScript("arguments[0].setAttribute('value','"+dateVal+"')",element);
		
		// no if you can call the method 'selectDateByJS'
		//create the web element of the calendar object, 
		//value for dateVal can be set as Sting dateVal="10-16-2020" (for eg)
		
	}


}
