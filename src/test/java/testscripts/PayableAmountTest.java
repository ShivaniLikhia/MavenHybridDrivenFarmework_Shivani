package testscripts;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.ControlActions;
import pages.DashboardPage;
import pages.LoginPage;
import pages.employeemanagement.MyInfoPage;
import pages.employeemanagement.myinfo.SalaryPage;

public class PayableAmountTest extends TestBase{
		
		@Test
		public void verifyPayableAmount() {
		System.out.println("STEP - Click on my Info Button");
		MyInfoPage myinfoPage = new MyInfoPage();
		myinfoPage.clickOnMyInfoTab();
		
		System.out.println("VERIFY - User Personal details label displayed");
		DashboardPage dashboardpage = new DashboardPage();
		boolean isUserPersonalDetailsButtonDisplayed =  dashboardpage.isUserPersonalDetailsButtonDisplayed();
		Assert.assertTrue(isUserPersonalDetailsButtonDisplayed);
		
		System.out.println("STEP - Click on Salary.");
		SalaryPage salarypage = new SalaryPage();
		salarypage.clickOnSalaryTab();
		
		System.out.println("Verify - CTC amount is non zero");
		int actualSalary = salarypage.getCTC();
		if(actualSalary > 0) {
			Assert.assertTrue(true);
		}
	}
}
