package testscripts;

import org.testng.Assert;

import pages.DashboardPage;
import pages.employeemanagement.EmployeeManagement;

public class CompanyNameUpdateTest extends TestBase {

	public void verifyCompanyNameUpdate() {
		
		System.out.println("STEP - Click on HR Administration Tab. ");
		DashboardPage dashboardpage = new DashboardPage();
		dashboardpage.clickOnHRAdministrationTab();
		
		System.out.println("STEP - Mouse hover on Organisations Tab.");
		EmployeeManagement employeeManagement = new EmployeeManagement();
		employeeManagement.MouseHoverOnOrganisationTab();
		
		System.out.println("STEP - Click on General Information Tab.");
		employeeManagement.clickOnGeneralInformationTab();
		
		System.out.println("STEP - Change Name of Organisation to Technocredits");
		employeeManagement.changeOrganisationName();
		
		System.out.println("STEP - Verify Number of Employees field is disabled.");
		boolean isEmployeesFieldDisabled = employeeManagement.isEmployeeFieldDisabled();
		Assert.assertTrue(isEmployeesFieldDisabled);
		
		System.out.println("STEP - Click on Save Button.");
		employeeManagement.clickOnSaveButton();
		
		System.out.println("STEP - MouseHover on UserProfile and Click on Settings Icon");
		dashboardpage.mouseHoverOnUserProfile();
		dashboardpage.clickOnSettingButton();;
		
		System.out.println("STEP - Click on About Tab");
		dashboardpage.clickOnUserMenuAboutLink();
		
		System.out.println("VERIFY - Company updated as : Technocredits is saved");
		String updatedCompanyName = employeeManagement.getOrganisationName();
		Assert.assertEquals(updatedCompanyName, "Technocredits");
	}
	
}
