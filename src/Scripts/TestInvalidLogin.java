package Scripts;

import org.testng.annotations.Test;

import Generic.BaseTest;
import Generic.Lib;
import PomPage.LoginPage;

public class TestInvalidLogin extends BaseTest{
	@Test(invocationCount = 2)
	public void inValidLogin() throws InterruptedException
	{
		LoginPage login = new LoginPage(driver);
		
		int rowCount = Lib.getRowCount("InvalidLoginCredentials");
		System.out.println(rowCount + " Total number of active rows");
		for(int i=1; i<= rowCount; i++){
		String userName = Lib.getCellValue("InvalidLoginCredentials", i, 0);
		Thread.sleep(1000);
		login.setUserName(userName);
		Thread.sleep(1000);
		login.setPassword(Lib.getCellValue("InvalidLoginCredentials", i, 1));
		Thread.sleep(1000);
		login.clickLogin();
		Thread.sleep(1000);
		//System.out.println("Count of execution value is "+i);
		}
		//System.out.println("Test method successful Login button is clicked");
	}

}
