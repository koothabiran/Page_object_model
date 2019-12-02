package PomPack.tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import PomPack.pages.LaunchPage;
import PomPack.tests.base.BaseTest;
import PomPack.util.constants;

public class LoginTest extends BaseTest {
	
	
	@Test
	public void testLogin() {
	
	    eTest = eReport.startTest("testLogin");
	    
		eTest.log(LogStatus.INFO, "Login test has started");
		
		openBrowser(constants.BROWSER_TYPE);
		
		LaunchPage launchpage = new LaunchPage(driver,eTest);
		PageFactory.initElements(driver, launchpage);
		
		boolean loginStatus = launchpage.goToLoginPage();
		
		if(loginStatus) {
			
		reportPass("LoginTest testcase passed");
			
		}else {
			
		reportFail("loginTest testcase failed");
			
		}
		
	}
	
@AfterMethod
	public void testClosure() {
		
		if(eReport!=null) {
			
			eReport.endTest(eTest);
			eReport.flush();
		}
		
		if(driver!=null) {
			
			driver.quit();
			
	}
	
	}
	

}
