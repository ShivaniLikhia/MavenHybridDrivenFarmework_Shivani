package testscripts;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.DashboardPage;

public class WidgetTest extends TestBase {
	
	@Test
	public void VerifyWidgetsOnDashboard() {
		System.out.println("STEP - Get diplayed widgets on Dashboard page");
		DashboardPage dashboardpage = new DashboardPage();
		dashboardpage.waitUntilWidgetsGetLoaded();
		int totalWidgetsVisible = dashboardpage.getTotalVisibleWidgets();
		System.out.println("Verify - Toatal Widgets should be 13.");
		Assert.assertEquals(totalWidgetsVisible,13);
		
		System.out.println("STEP - Get widget names.");
		List<String> actualList = dashboardpage.getAllWidgetsName();
		
		List<String> expectedList = new ArrayList<>();
		expectedList.add("Quick Access");
        expectedList.add("Buzz Latest Posts");
        expectedList.add("My Actions");
        expectedList.add("Latest Documents");
        expectedList.add("Latest News");
        expectedList.add("Employees on Leave Today");
        expectedList.add("Time At Work");
        expectedList.add("Headcount by Location");
        expectedList.add("COVID-19 Report");
        expectedList.add("Current Year's Leave Taken by Department");
        expectedList.add("Leave Taken on Each Calendar Month Over the Years");
        expectedList.add("Leave Scheduled in Each Month");
        expectedList.add("Leave Taken on Each Day of the Week Over Time");
        
        System.out.println("VERIFY - Expected and Actual WIdget list is same");
        Assert.assertEquals(actualList, expectedList);
		
	}
}
