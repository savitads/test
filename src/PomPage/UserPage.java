package PomPage;

import java.sql.Driver;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserPage {
	//declare the elements
	@FindBy(xpath="//div[text()='Add User']")
	WebElement addUserBtn;
	
	@FindBy(name="firstName")
	WebElement firstName;
	
	@FindBy(name="lastName")
	WebElement lastName;
	
	@FindBy(name="email")
	WebElement emailId;
	
	@FindBy(name="username")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(name="passwordCopy")
	WebElement confirmPassword;
	
	@FindBy(xpath="//div[text()='Cancel']")
	WebElement cancelBtn;
	
	@FindBy(xpath="//*[text()='Create User']")
	WebElement createBtn;
	
	//Initialize the elements
	public UserPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	//Utilize the elements
	public void clickaddUserBtn() {
		addUserBtn.click();
	}
	public void setFirstName(String fName){
		firstName.sendKeys(fName);
	}
	public void setLastName(String lName){
		lastName.sendKeys(lName);
	}
	public void setEmail(String emailAdd){
		emailId.sendKeys(emailAdd);
	}
	public void setUserName(String userName){
		username.sendKeys(userName);
	}
	public void setPassword(String pwd){
		password.sendKeys(pwd);
	}
	public void setConfirmPwd(String confirmPwd){
		confirmPassword.sendKeys(confirmPwd);
	}
	
	public void cancelBtnClick(WebDriver driver) {
		cancelBtn.click();
		Alert alert = driver.switchTo().alert();
		if(alert != null)
		{
			alert.accept();
		}
		System.out.println("Cancel button is clicked successfully");	
	}
	public void clickCreateUser()
	{
		createBtn.click();
	}
	
}
