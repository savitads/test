package PomPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	//declare the elements
	@FindBy(xpath = "//*[@class='popup_menu_icon support_icon']")
	WebElement helpIcon;
	
	@FindBy(xpath = "//a[contains(text(),'About your actiTIME')]")
	WebElement aboutOption;
	
	@FindBy(xpath = "//*[text()='actiTIME 2017.4']")
	WebElement version;
	

	//initialize the elements
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//utilize the elements
	public void clickHelpIcon() {
		helpIcon.click();
	}
	public void clickAboutOption() {
		aboutOption.click();
	}
	public String getVersion() {
		return version.getText();
	}
	

}
