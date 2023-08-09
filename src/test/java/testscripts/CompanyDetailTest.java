package testscripts;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.ControlActions;
import pages.DashboardPage;
import pages.LoginPage;

public class CompanyDetailTest extends TestBase{
	
	@Test
	public void verifyCompanyDetails() {
		System.out.println("Verify User Profile is Displayed");
		DashboardPage dashboardpage = new DashboardPage();
		boolean isUserProfileDisplayed = dashboardpage.isUserProfileVisible();
		Assert.assertTrue(isUserProfileDisplayed);
		
		System.out.println("STEP - Mouse hover on profile and Click on Settings icon on profile");
		dashboardpage.mouseHoverOnUserProfile();
		dashboardpage.clickOnSettingButton();
		
		System.out.println("VERIFY - User Menu total 2 Options Displayed");
		int actualOptions = dashboardpage.getTotalVisibleMenuOptions();
		Assert.assertEquals(actualOptions,2);
		
		System.out.println("STEP - Click on About tab");
		dashboardpage.clickOnUserMenuAboutLink();
		
		System.out.println("VERIFY - Employee is more than 0. ");
		int actualEmpCount = dashboardpage.getEmployeeCount();
		Assert.assertTrue(actualEmpCount>0);
		
		System.out.println("STEP - Click on OK Button on Pop Up.");
		dashboardpage.clickOnOKButton();
	}
}
