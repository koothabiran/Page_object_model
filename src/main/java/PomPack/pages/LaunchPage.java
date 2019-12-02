package PomPack.pages;

	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import PomPack.base.BasePage;
import PomPack.util.constants;

public class LaunchPage extends BasePage {

	
	//WebElements of Lauch page

	@FindBy(className="zh-customers")
	public WebElement Customers;

	@FindBy(className="zh-support")
	public WebElement Support;

	@FindBy(className="zh-login")
	public WebElement Login;

	@FindBy(className="zh-signup")
	public WebElement Signup;


	//constructors
	public LaunchPage(WebDriver driver, ExtentTest eTest) {
	
	this.driver = driver;
	this.eTest = eTest;
	
	
	
}


//Reusable methods of Launch page

public boolean goToLoginPage() {
	
	driver.get(constants.APP_URL);
	
	eTest.log(LogStatus.INFO,"Application url "+constants.APP_URL + "is opened");
	Login.click();
	eTest.log(LogStatus.INFO, "Login button is clicked");
	
	
	LoginPage loginpage = new LoginPage(driver, eTest);
	PageFactory.initElements(driver, loginpage);
	
	boolean loginStatus = loginpage.doLogin();
	return loginStatus;
	
}


}
