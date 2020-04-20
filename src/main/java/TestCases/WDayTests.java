package TestCases;

import static org.testng.AssertJUnit.assertTrue;
import org.testng.annotations.Test;
import common.ConfigManager;

public class WDayTests extends BaseTestcase {

	@Test(priority=1)
	public void verifyLoginFunctionality() throws InterruptedException
	{
		//classtest = report.createTest("Login");
		test=classtest.createNode("login entereies");
		profilePage=loginPage.login(ConfigManager.getProp().getProperty("username"), ConfigManager.getProp().getProperty("password"));		
	}
	

	@Test(priority=2)
	public void verifyUser()throws InterruptedException
	{
		test=classtest.createNode("checking name");
		assertTrue(profilePage.verifyUserName());
	}
	
	
	@Test(priority=3)
	public void clickTabs()throws InterruptedException
	{
		test=classtest.createNode("clicking tabs");
		Personaldetails=profilePage.profileTabs();
	}
	
	@Test(priority=4)
	public void enterComment()throws InterruptedException
	{
		test=classtest.createNode("adding comment");
        Personaldetails.openPersonalDetails("Test");	
	}

}
