package PomPack.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.relevantcodes.extentreports.ExtentTest;

import PomPack.base.BasePage;

public class HomePage extends BasePage { 
	
	
	
	@FindBy(css="span[class^='zicon-apps-calendar']")
	public WebElement calendar;
	
	
	@FindBy(css="span[class^='zicon-apps-chat']")
	public WebElement Cliq;
	
	@FindBy(css="span[class^='zicon-apps-crm']")
	public WebElement CRM;
	
	@FindBy(css="span[class^='zicon-apps-mail']")
	public WebElement Mail;
	
	
	@FindBy(css="span[class^='zicon-apps-salesiq']")
	public WebElement SalesIQ;
	
	
	
	//constructor code
	public HomePage(WebDriver driver, ExtentTest eTest) {
		
		this.driver = driver;
		this.eTest = eTest;
		
	}
	
	
	
	//Reusable method for verifying user Logging sucessfully or not
	public boolean VerifyHomePage() {
		
		
		return(isElementPresent(CRM));
		
		
		
	}

}
 