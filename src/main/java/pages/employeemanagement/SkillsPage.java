package pages.employeemanagement;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.ControlActions;

public class SkillsPage extends ControlActions {
	
	@FindBy(css="div.tooltipped>a.waves-light")
	WebElement plusIconElement;
	
	@FindBy(css = "div.input-field>input#name")
	WebElement addSkillName;
	
	@FindBy(css = "div.input-field>textarea#description")
	WebElement addDescriptionElement;
	
	@FindBy(css = "div.modal-footer>a.primary-btn")
	WebElement saveButtonElement;
	
	@FindBy(xpath = "//div[@class='sub-menu-item']/a[text()='Skills']")
	WebElement skillsTab;
	
	public SkillsPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnSkillsTab() {
		skillsTab.click();
	}
	
	public void clickOnPlusIcon() {
		plusIconElement.click();
	}
	
	public boolean isAddSkillsHeaderDisplayed() {
		return isElementDisplayed(addSkillName);
	}
	
	public void addSkillName() {
		WebElement e = waitForWebElementToBeVisible(addSkillName);
		e.sendKeys("Automation Test");
	}
	
	/*public void addSkillName() {
		setText("Automation Test", addSkillName, true);
	}*/
	
	public void addDescription() {
		setText("Learn Automation test of Website using Selenium.", addDescriptionElement, true);
	}
	
	public void clickOnSaveButton() {
		saveButtonElement.click();
	}
	
	public boolean isNewSkillDisplayed() {
		return isElementDisplayed("XPATH", "//table[@class='highlight bordered']/tbody/tr[1]/td[2]", true);
	}
}
