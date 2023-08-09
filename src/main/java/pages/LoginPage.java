package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.ControlActions;

public class LoginPage extends ControlActions {
	
	@FindBy(xpath = "//div[@id=\"divLogin\"]/div[2]/div/div[1]/img")
	WebElement logoElement;
	
	@FindBy(css = "input#txtUsername")
	WebElement userNameElement;
	
	@FindBy(css = "input#txtPassword")
	WebElement passwordElement;
	
	@FindBy(css = "button[Type='submit']")
	WebElement submitBtn;
	
	@FindBy(css = "div.toast-message")
	WebElement inValidToastElement;
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean isLogoDisplayed(){
		return isElementDisplayed(logoElement);
	}
	
	public void doLogin(String uname, String password) {
		userNameElement.sendKeys(uname);
		passwordElement.sendKeys(password);
		submitBtn.click();
	}
	
	public boolean isInValidToastMessageDisplayed() {
		return inValidToastElement.isDisplayed();
	}
	
	public String getCurrentURL() {
		return driver.getCurrentUrl();
	}
}
