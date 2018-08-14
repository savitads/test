package Generic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class BaseTest implements IAutoConstant {
	
	public WebDriver driver;
	static
	{
		System.setProperty(CHROME_KEY, CHROME_VALUE);
		System.setProperty(GECKO_KEY, GECKO_VALUE);
		//System.setProperty(IE_KEY, IE_VALUE);
	}
	//@Parameters("BrowserName")
	@BeforeMethod
	public void lunchApplication()
//	public void lunchApplication(String BrowserName)
	{
		/*if(BrowserName.equals("chrome"))
		 * 
		 * 
		{
			driver = new ChromeDriver();
			System.out.println(driver);
		}else
		{
			driver = new FirefoxDriver();
			System.out.println(driver);
		}
	*/
		//
		driver = new ChromeDriver();
	//	System.out.println("@Beforetest is successful");
		driver.get(Lib.getPropertyValue("URL"));
		
	   String implicitWait = Lib.getPropertyValue("IMPLICIT_TIME_PERIOD");
	   long timeOutPeriod = Long.parseLong(implicitWait);
		driver.manage().timeouts().implicitlyWait(timeOutPeriod, TimeUnit.SECONDS);
	}
	
	
	@AfterMethod
	public void closeApplication(ITestResult res)
	{
		if(ITestResult.FAILURE == res.getStatus())
		{
			System.out.println(res.getStatus() + " Status of the result");
		    Lib.captureScreenshot(driver, res.getName());
		}
		System.out.println("After method Successful");
		driver.close();
	}

}
