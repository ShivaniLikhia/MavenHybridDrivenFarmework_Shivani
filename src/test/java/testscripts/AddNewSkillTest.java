package testscripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.DashboardPage;
import pages.employeemanagement.SkillsPage;

public class AddNewSkillTest extends TestBase {

	@Test
	public void verifyNewSkillAdded() {
		System.out.println("Step - Click on Qualification tab");
		DashboardPage dashboard = new DashboardPage();
		dashboard.clickOnMoreTab();
		dashboard.mouseHoverOnQulaificationsTab();
		
		System.out.println("STEP - Click on Skills Tab");
		SkillsPage skillsPage = new SkillsPage();
		skillsPage.clickOnSkillsTab();
		
		System.out.println("STEP - Click on + Icon");
		skillsPage.clickOnPlusIcon();
		
		System.out.println("VERIFY - Popup Header should be displayed as Add Skill.");
		boolean isHeaderDisplayed = skillsPage.isAddSkillsHeaderDisplayed();
		Assert.assertTrue(isHeaderDisplayed);
		
		System.out.println("STEP - Enter Skill as Automation Test");
		skillsPage.addSkillName();
		
		System.out.println("STEP - Enter Description.");
		skillsPage.addDescription();
		
		System.out.println("STEP - Click on Save Button. ");
		skillsPage.clickOnSaveButton();
		
		System.out.println("VERIFY - New Skill added is displayed. ");
		boolean isNewSkillDisplayed = skillsPage.isNewSkillDisplayed();
		Assert.assertTrue(isNewSkillDisplayed);
	}
	
	
	
	
}
