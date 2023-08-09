package pages.hradministration;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.ControlActions;

public class ManageUserRolesPage extends ControlActions {
	
	@FindBy(css = "input.select-dropdown")
	WebElement paginationDropdown;
	
	@FindBy(css = "li[class='summary']")
	WebElement paginationSummary;
	
	@FindBy(css = "table.highlight>tbody>tr")
	List<WebElement> listOfRows;
	
	@FindBy(css = "//a[text()='Organization ']")
	WebElement organisationTab;
	
	@FindBy(xpath = "//a[text()='Manage User Roles ']")
	WebElement manageUserRoles;
	
	public ManageUserRolesPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnManageUserRoles() {
		manageUserRoles.click();
	}
	
	public void mouseHoverOnOrganisationTab(String locatorType,String locatorValue) {
		mouseHover(organisationTab);
	}
	
	public String getPaginationdefaultValue() {
		return paginationDropdown.getText();
	}
	
	public int getTotalTableRows() {
		return listOfRows.size();
	}
	
	public int getByDefaultRecordsDisplyedInTable() {
		WebElement e = getElement("XPATH", "//div[@class='select-wrapper']/input[@value='50']", true);
		String str = e.getAttribute("value");
		return Integer.parseInt(str);
	}
	
	public int getTotalRecordsInTable() {
		return driver.findElements(By.cssSelector("table.highlight>tbody>tr")).size();
	}
	
	public int getTotalRowsfromSummary() {
		String paginationText = getElementText(paginationSummary,false);
		String[] arr = paginationText.split("of");
		return Integer.parseInt(arr[1].trim());
	}
}

