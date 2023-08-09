package pages.employeemanagement;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.ControlActions;

public class MyInfoPage extends ControlActions {
	
	@FindBy(css = "div#top_level_menu_item_menu_item_40>a")
	WebElement myInfoTab;
	
	public MyInfoPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnMyInfoTab() {
		myInfoTab.click();
	}
}
