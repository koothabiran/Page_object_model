package PomPack.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import PomPack.base.BasePage;
import PomPack.util.constants;

public class LoginPage extends BasePage {
	
	
	
	@FindBy(id="login_id")
	public WebElement EmailField;
	
	@FindBy(id="nextbtn")
	public WebElement NextButton;
	
	@FindBy(id="password")
	public WebElement Password;
	
	@FindBy(id="nextbtn")
	public WebElement SignIn;
	
	
	
	
	public LoginPage(WebDriver driver, ExtentTest eTest) {
		
		this.driver= driver;
		this.eTest = eTest;
		
		
	}
	
	
	
	//Reusable methods of Login page

	public boolean doLogin() {
		
		EmailField.sendKeys(constants.USERNAME);
		eTest.log(LogStatus.INFO, "username is entered in the username field");
		
		NextButton.click();
		
	   eTest.log(LogStatus.INFO, "Next button is clicked");
		
		Password.sendKeys(constants.PASSWORD);
		eTest.log(LogStatus.INFO, "password is entered in the password field");
		
		SignIn.click();
		
		eTest.log(LogStatus.INFO, "SignIn button got clicked");
		
		
		HomePage homepage = new HomePage(driver, eTest);
		PageFactory.initElements(driver, homepage);
		
		boolean loginStatus = homepage.VerifyHomePage();
		
		return loginStatus;
		
	}

	

}
