package Scripts;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Generic.BaseTest;
import Generic.Lib;
import PomPage.HomePage;
import PomPage.LoginPage;

public class ValidActiTimeVersion extends BaseTest{
	@Test(invocationCount = 2)
	public void ValidActiTimeVersion() throws InterruptedException
	{
	LoginPage login = new LoginPage(driver);
	String userName = Lib.getCellValue("ValidLoginCredentials", 0, 0);
	login.setUserName(userName);
	login.setPassword(Lib.getCellValue("ValidLoginCredentials", 0, 1));
	login.clickLogin();
	WebDriverWait wait = new WebDriverWait(driver, 10);
	wait.until(ExpectedConditions.titleIs("actiTIME - Enter Time-Track"));
	wait.until(ExpectedConditions.urlContains("https://demo.actitime.com/user/submit_tt.do"));
	
	HomePage homePage = new HomePage(driver);
	homePage.clickHelpIcon();
	homePage.clickAboutOption();
	String version = homePage.getVersion();
	System.out.println(version +" is the version ");
	
	String versionNumber = Lib.getCellValue("Version", 1, 0);
	
	SoftAssert sa = new SoftAssert();
	sa.assertEquals(version, versionNumber);
	sa.assertAll();
	
   }
}