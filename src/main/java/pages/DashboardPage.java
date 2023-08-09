package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.ControlActions;

public class DashboardPage extends ControlActions{
	
	@FindBy(xpath = "//div[text()='Employee Management']")
	WebElement employeeManagementHeader;
	
	@FindBy(xpath = "//div[@id='widget.id' and not (contains(@class, 'ng-hide'))]")
	List<WebElement> listOfWidgets;
	
	@FindBy(xpath = "//div[@id='widget.id' and not (contains(@class, 'ng-hide'))]//div[@class='widget-header']/span[2]")
	List<WebElement> listOfWidgetsText;
	
	@FindBy(css = "div#sidebar-profile-picture")
	WebElement userProfile;
	
	@FindBy(css = "div.image-container>a>i")
	WebElement settingButton;
	
	@FindBy(css = "div.opened>div>div")
	List<WebElement> menuList;
	
	@FindBy(css = "a#aboutDisplayLink")
	WebElement aboutElemnent;
	
	@FindBy(css = "div.modal-footer>a#heartbeatSubmitBtn")
	WebElement submitButton;
	
	@FindBy(css = "div#menu-content>ul>li:nth-child(3)>a:first-child")
	WebElement employeeManagementTab;
	
	@FindBy(css = "div#menu-content>ul>li:nth-child(2)>a:first-child")
	WebElement hrAdministrationTab;
	
	@FindBy(css = "div.picture>div>img")
	WebElement userProfilePicture;
	
	@FindBy(xpath = "//div[@class='top-level-menu-item-container']/a[text()='More ']")
	WebElement moreTabElement;
	
	@FindBy(xpath = "//a[text()=' Qualifications ']")
	WebElement qualificationsTab;
	
	@FindBy(xpath = "//a[text()='Personal Details ']")
	WebElement personalDetailsBtn;
	
	private WebDriverWait wait;
	
	public DashboardPage() {
		PageFactory.initElements(driver, this);
	}
	
	public int getTotalVisibleWidgets() {
		return listOfWidgets.size();
	}
	
	public boolean isEmployeeManagementHeaderDisplayed() {
		return isElementDisplayed(employeeManagementHeader);
	}
	
	public boolean isUserProfileVisible() {
		return isElementDisplayed(userProfilePicture);
	}
	
	public void waitUntilWidgetsGetLoaded() {
		waitForWebElementsToBeVisible(listOfWidgets);
	}
	
	public List<String> getAllWidgetsName(){
		return getListOfWebElements(listOfWidgetsText);
	}
	
	public void mouseHoverOnUserProfile() {
		mouseHover(userProfile);
	}
	
	public boolean isUserPersonalDetailsButtonDisplayed() {
		return isElementDisplayed(personalDetailsBtn);
	}
	
	public int getTotalVisibleUserMenuOptions() {
		return driver.findElements(By.cssSelector("div.opened>div>div")).size();
	}
	
	public void clickOnSettingButton() {
		settingButton.click();
	}
	
	public int getUserMenuList() {
		return menuList.size();
	}
	
	public void clickOnUserMenuAboutLink() {
		aboutElemnent.click();
	}
	
	public void clickOnMoreTab() {
		waitForWebElementToBeVisible(moreTabElement).click();
	}
	
	public void mouseHoverOnQulaificationsTab() {
		mouseHover(qualificationsTab);
	}
	
	public void clickOnQualificationsTab() {
		qualificationsTab.click();
	}
	
	public int getTotalVisibleMenuOptions() {
		return driver.findElements(By.cssSelector("div.opened>div>div")).size();
	}
	
	public void waitForInvisibilityOfLoader() {
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div#displayAboutLoadMask")));
	}
	
	public int getEmployeeCount() {
		WebElement e = waitForWebElementToBeVisible("xpath","//div[@id='companyInfo']//p[contains(text(),'Employees')]");
		String str = e.getText();
		String[] empCountInfoArr = str.split(" ");
		int totalEmployees = Integer.parseInt(empCountInfoArr[1]);
		return totalEmployees;
	}
	
	public void clickOnOKButton() {
		submitButton.click();
	}
	
	public void clickOnEmployeeManagementTab() {
		employeeManagementTab.click();;
	}
	
	public void clickOnHRAdministrationTab() {
		hrAdministrationTab.click();
	}
}
