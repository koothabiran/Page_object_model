package PomPack.tests.base;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import PomPack.util.ExtentManager;
import PomPack.util.constants;
import junit.framework.Assert;

public class BaseTest {
	
	
	public WebDriver driver=null;
	
	
	public ExtentReports eReport = ExtentManager.getInstance();
	public ExtentTest eTest = null;
	
	public  void openBrowser(String browserType) {
		
		if(browserType.equalsIgnoreCase("firefox")) {
			
			System.setProperty("webdriver.gecko.driver", constants.FIREFOX);
			driver = new FirefoxDriver();
				
			}
			
		else if(browserType.equalsIgnoreCase("chrome")) {
				
				System.setProperty("webdriver.chrome.driver", constants.CHROME);
				driver = new ChromeDriver();
					
				}
			
		eTest.log(LogStatus.INFO, "ScucessFully opened the browser "+browserType);	
		driver.manage().window().maximize();
		
		eTest.log(LogStatus.INFO, "Window is maximized");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
			
		}
		
		
	public void reportPass(String message) {
		
		
		eTest.log(LogStatus.PASS, message);
		
		
		
	}
		
	
	
	public void reportFail(String message) {
		
		
		eTest.log(LogStatus.FAIL, message);
		
		takeScreenshot();
		
		
		Assert.fail(message);
		
	}
	
	
	//Reusable method for taking screenshot
		public void takeScreenshot(){
			
			// fileName of the screenshot
			Date d=new Date();
			String screenshotFile=d.toString().replace(":", "_").replace(" ", "_")+".png";
			// store screenshot in that file
			File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			try {
				FileUtils.copyFile(scrFile, new File("screenshots//"+screenshotFile));
			} catch (IOException e) {
				e.printStackTrace();
			}
			//put screenshot file into the reports
			eTest.log(LogStatus.INFO,"Screenshot-> "+ eTest.addScreenCapture(System.getProperty("user.dir")+"//screenshots//"+screenshotFile));
				
		}

	
	
	}
	
	
	
	
	
	
	
	
	


