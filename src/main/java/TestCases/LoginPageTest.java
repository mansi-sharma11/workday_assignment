package TestCases;

import org.testng.annotations.Test;

import common.ConfigManager;

public class LoginPageTest extends BaseTestcase{
	@Test
	public void verifyLoginFunctionality() throws InterruptedException
	{
		
		logger = report.createTest("Login");

		Pinfo=loginPage.login(ConfigManager.getProp().getProperty("username"), ConfigManager.getProp().getProperty("password"));
			
		logger.pass("Passed");
		
	}


}
