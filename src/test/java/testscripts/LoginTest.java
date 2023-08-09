package testscripts;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.LoginPage;
import utility.ExcelOperations;

public class LoginTest extends TestBase{

	@Test
	public void verifyLogin() {
		System.out.println("STEP - Verify the Logo is Diplayed on the log in page.");
		LoginPage loginPage = new LoginPage();
		boolean isLogoDisplayedFlag = loginPage.isLogoDisplayed();
		Assert.assertTrue(isLogoDisplayedFlag);
		
		System.out.println("STEP - Login with given Credentials");
		loginPage.doLogin("admin", "RKv0xLp4M@");
		
		System.out.println("VERIFY - Employee Management header should be visible.");
		DashboardPage dashboardPage = new DashboardPage();
		boolean isHeaderVisibleFlag = dashboardPage.isEmployeeManagementHeaderDisplayed();
		Assert.assertTrue(isHeaderVisibleFlag);
	}
	
	@Test
	public void verifyLoginWithInvalidCredentials() {
		System.out.println("STEP - Logo is Displayed on the login Page");
		LoginPage loginPage = new LoginPage();
		boolean isLogoDisplayedFlag = loginPage.isLogoDisplayed();
		Assert.assertTrue(isLogoDisplayedFlag);
		
		System.out.println("STEP - Login with given Credentials");
		loginPage.doLogin("admin", "abckshdcs");
		
		boolean unsuccessfullLoginFlag = loginPage.isInValidToastMessageDisplayed();
		Assert.assertTrue(unsuccessfullLoginFlag);
		
		String currentURL = loginPage.getCurrentURL();
		Assert.assertTrue(currentURL.endsWith("retryLogin"));
	}
	
	@DataProvider(name = "loginTestData")
	public Object[][] loginDataProvider() throws IOException{
		String filePath = ".//resources/testdata/LoginData.xlsx";
		String sheetName = "loginTestData";
		return ExcelOperations.getSheetAllRows(filePath,sheetName);
	}
	
	@Test(dataProvider = "loginTestData")
	public void verifyLoginnWithDataDriven(String userName,String password,String result) {
		System.out.println("STEP - Verify the logo is diplayed on login Page.");
		LoginPage loginPage = new LoginPage();
		boolean isLogoDisplayedFlag = loginPage.isLogoDisplayed();
		Assert.assertTrue(isLogoDisplayedFlag);
		
		System.out.println("STEP - Login with given credentials.");
		loginPage.doLogin(userName,password);
		
		if(result.equalsIgnoreCase("valid")) {
			DashboardPage dashBoardPage = new DashboardPage();
			boolean isHeaderVisibleFlag = dashBoardPage.isEmployeeManagementHeaderDisplayed();
			Assert.assertTrue(isHeaderVisibleFlag);
		}
		else {
			boolean unsuccessfulLoginFlag = loginPage.isInValidToastMessageDisplayed();
			Assert.assertTrue(unsuccessfulLoginFlag);
			
			String currentURL = loginPage.getCurrentURL();
			Assert.assertTrue(currentURL.endsWith("retryLogin"));
		}
		
	}
	
}
