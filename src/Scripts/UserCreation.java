package Scripts;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Generic.BaseTest;
import Generic.Lib;
import PomPage.HomePage;
import PomPage.LoginPage;
import PomPage.UserPage;

public class UserCreation extends TestValidLogin {
	
	@Test()
	public void validLogin() throws InterruptedException
	{
		Logger log = LogManager.getLogger(TestValidLogin.class.getName());
		log.debug("Inside the user creation class");
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
		
		HomePage hp= new HomePage(driver);
		hp.clickUser();
		wait.until(ExpectedConditions.titleIs("actiTIME - User List"));
		System.out.println("User btn clicked");
		
		UserPage userCreation = new UserPage(driver);
		System.out.println("Inside user creation table");
		userCreation.clickaddUserBtn();
		userCreation.setLastName("ds");
		userCreation.cancelBtnClick(driver);
		hp.clickUser();
		userCreation.clickaddUserBtn();
		userCreation.setFirstName("savita");
		Thread.sleep(2000);
		userCreation.setLastName("ds");
		Thread.sleep(2000);
		userCreation.setEmail("savitads24@gmail.com");
		Thread.sleep(2000);
		userCreation.setUserName("savita1234");
		userCreation.setPassword("1234Savita");
		userCreation.setConfirmPwd("1234Savita");
		Thread.sleep(2000);
		userCreation.clickCreateUser();
		
		log.debug("User creation successful");
		
		
	}

}
