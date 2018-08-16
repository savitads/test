package Scripts;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Generic.BaseTest;
import Generic.Lib;
import PomPage.LoginPage;

public class TestValidLogin extends BaseTest{
	
	@Test()
	public void validLogin() throws InterruptedException
	{
		Logger log = LogManager.getLogger(TestValidLogin.class.getName());
		log.debug("creating the object of Login Page");
		LoginPage login = new LoginPage(driver);
		log.info("Login page object is created successfully");
		String userName = Lib.getCellValue("ValidLoginCredentials", 0, 0);
		login.setUserName(userName);
		login.setPassword(Lib.getCellValue("ValidLoginCredentials", 0, 1));
		log.debug("Username and password entered");
		login.clickLogin();
		log.info("Login button is clicked");
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.titleIs("actiTIME - Enter Time-Track"));
		//wait.until(ExpectedConditions.titleIs("Title of the homepage"));
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(driver.getTitle(), "actiTIME - Enter Time-Track");
	//	sa.assertEquals(driver.getTitle(), "Title of the homepage");
//This should be the last condition,
		sa.assertAll();
	/*	 Assert.fail();
		 System.out.println("Not Failed forcefully");*/
		
	}

}
