package pages.employeemanagement.myinfo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.ControlActions;

public class SalaryPage extends ControlActions {
	
	@FindBy(css = "div.summary-cards-container>div>div:last-child")
	WebElement ctcTextElement;
	
	@FindBy(css = "//a[text()='Salary ']")
	WebElement salaryTab;
	
	public SalaryPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnSalaryTab() {
		salaryTab.click();
	}
	
	public int getCTC() {
		WebElement e = waitForWebElementToBeVisible("xpath", "//div[text()='$168,500.00']");
		String element = e.toString();
		int digit = element.charAt(1);
		return digit;
	}
	
	public double getCTCValue() {
		String empCTCInfo = getElementText(ctcTextElement,false);
		empCTCInfo = empCTCInfo.substring(1).replace(",","");
		return Double.parseDouble(empCTCInfo);
	}
}
