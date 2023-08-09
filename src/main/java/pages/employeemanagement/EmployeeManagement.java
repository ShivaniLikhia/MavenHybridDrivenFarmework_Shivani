package pages.employeemanagement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.ControlActions;

public class EmployeeManagement extends ControlActions {

	@FindBy(xpath = "//a[text()=' Qualifications ']")
	WebElement qualificationsTab;
	
	@FindBy(xpath = "//a[text()='Organization ']")
	WebElement organisationTab;
	
	@FindBy(xpath = "//a[text()=' General Information ']")
	WebElement generalInformationTab;
	
	@FindBy(xpath = "//input[@id=\"name\"]")
	WebElement organisationName;
	
	@FindBy(xpath = "//button[text()='Save']")
	WebElement saveButton;
	
	public EmployeeManagement() {
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnQualificationsTab() {
		qualificationsTab.click();
	}
	
	public void MouseHoverOnOrganisationTab() {
		mouseHover(organisationTab);
	}
	
	public void clickOnGeneralInformationTab() {
		generalInformationTab.click();
	}
	
	public void changeOrganisationName() {
		waitForWebElementToBeVisible(organisationName).sendKeys("Technocredits");
	}
	
	public boolean isEmployeeFieldDisabled() {
		return driver.findElement(By.xpath("//input[@id='numemp']")).isEnabled();
	}
	
	public void clickOnSaveButton() {
		saveButton.click();
	}
	
	public String getOrganisationName() {
		return getElementText(organisationName,true);
	}
}
