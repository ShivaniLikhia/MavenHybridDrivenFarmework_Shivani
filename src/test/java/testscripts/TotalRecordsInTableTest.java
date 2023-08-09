package testscripts;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ControlActions;
import pages.DashboardPage;
import pages.LoginPage;
import pages.hradministration.ManageUserRolesPage;

public class TotalRecordsInTableTest extends TestBase {
	
	@Test
	public void verifyTotalRecordsInTable() {
		System.out.println("STEP - Click on HR Administration tab from left panel.");
		DashboardPage dashboardpage = new DashboardPage();
		dashboardpage.clickOnHRAdministrationTab();
		
		System.out.println("STEP - Click on Manage user roles from top panel.");
		ManageUserRolesPage manageUserRolesPage = new ManageUserRolesPage();
		manageUserRolesPage.clickOnManageUserRoles();
		
		System.out.println("VERIFY - By Default 50 records should be displayed in table.");
		int actualRecordDisplayed = manageUserRolesPage.getByDefaultRecordsDisplyedInTable();
		Assert.assertEquals(actualRecordDisplayed,50);
		
		System.out.println("VERIFY - Total records and showing count of records are same.");
		int totalRecords = manageUserRolesPage.getTotalTableRows();
		int countOfRecords = manageUserRolesPage.getTotalRecordsInTable();
		Assert.assertEquals(totalRecords, countOfRecords);
	}
}
