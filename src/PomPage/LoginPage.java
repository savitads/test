package PomPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	//declare the elements
		@FindBy(id="username")
		WebElement unTB;
		
		@FindBy(name="pwd")
		WebElement pwdTB;
		
		@FindBy(xpath="//div[text()='Login ']")
		WebElement loginBtn;
		
		//Initialize the elements
		public LoginPage(WebDriver driver) {
			PageFactory.initElements(driver, this);
		}

		//Utilize the elements
		public void setUserName(String un) {
			unTB.sendKeys(un);
		}
		
		public void setPassword(String pw) {
			pwdTB.sendKeys(pw);
		}
		
		public void clickLogin() {
			loginBtn.click();
		}


}
