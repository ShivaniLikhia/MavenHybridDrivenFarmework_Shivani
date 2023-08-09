package testscripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.DashboardPage;

public class DashboardTest extends TestBase{

	@Test
	public void verifyEmployeeCount() {
		System.out.println("VERIFY - User Profile is Displayed");
		DashboardPage dashboardpage = new DashboardPage();
		boolean isUserProfileVisible = dashboardpage.isUserProfileVisible();
		Assert.assertTrue(isUserProfileVisible,"User profile was not displayed on dashboard page");
		
		System.out.println("STEP - Mouse Hover on Profile and Click on Settings Icon on Profile");
		dashboardpage.mouseHoverOnUserProfile();
		dashboardpage.clickOnSettingButton();
		
		System.out.println("VERIFY - On User Menu 2 options are displayed.");
		int menuSize = dashboardpage.getUserMenuList();
		Assert.assertEquals(menuSize, 2);
		
		System.out.println("STEP - Click on About Tab.");
		dashboardpage.clickOnUserMenuAboutLink();
		
		System.out.println("VERIFY - Employee is more than 0.");
		dashboardpage.waitForInvisibilityOfLoader();
		int actualEmpCount = dashboardpage.getEmployeeCount();
		Assert.assertTrue(actualEmpCount>0);
		
		System.out.println("STEP - Click on OK Button on Pop Up.");
		dashboardpage.clickOnOKButton();
	}
}
