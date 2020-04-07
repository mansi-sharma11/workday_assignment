package TestCases;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import common.ConfigManager;

public class PersonalDetailsTest extends BaseTestcase {
	@BeforeMethod
	public void Login() throws InterruptedException {

		Pinfo = loginPage.login(ConfigManager.getProp().getProperty("username"),ConfigManager.getProp().getProperty("password"));
		Pdetails = Pinfo.intoDetails();
	}

	@Test
	public void VerifyDetailsandComment() throws InterruptedException{
		logger = report.createTest("Details Verify");
		Pdetails.Details("Demo comment");
		logger.pass("All verified");
		logger.log(Status.INFO, "verified!!");

	}
	
	
	
	//test with different methods
	
	/*@Test
	public void Deets() throws InterruptedException {
		logger = report.createTest("Details Verify");
		Pdetails.Details();
		logger.pass("Details reached");
		
		logger = report.createTest("PersonalInfo Verify");
		Assert.assertTrue(Pdetails.isTitleMatched());
		logger.pass("Name matched");

		 
		logger = report.createTest("Enter Comment");
		Pdetails.EnterComment("Demo");
		logger.pass("Comment entered");

		 

	}*/

	
}
