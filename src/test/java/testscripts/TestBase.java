package testscripts;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import base.ControlActions;
import pages.LoginPage;

public class TestBase {
	
	@BeforeMethod
	public void setUp() {
		System.out.println("PREREQUISITE - Launch Orange HRM  URL.");
		ControlActions.start();
		
		System.out.println("PREREQUSITE - User Login  with Valid credentials.");
		LoginPage loginpage = new LoginPage();
		loginpage.doLogin("admin", "RKv0xLp4M@");
	}
	
	@AfterMethod
	public void tearDown() {
		ControlActions.closeBrowser();
	}
}
