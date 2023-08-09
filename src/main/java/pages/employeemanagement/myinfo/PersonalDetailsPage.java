package pages.employeemanagement.myinfo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.ControlActions;

public class PersonalDetailsPage extends ControlActions{
	
	@FindBy(css = "div#personal_details_tab>h4")
	WebElement personalDetailsHeader;
	
	public boolean isPersonalDetailsHeaderDisplayed() {
		return isElementDisplayed(personalDetailsHeader);
	}
	
	
}
