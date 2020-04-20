package PageFunctions;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.testng.SkipException;
import ObjectRepositort.ProfilePageOR;
import TestCases.BaseTestcase;
import common.ConfigManager;
import common.DriverFun;

public class ProfilePageFunctions extends ProfilePageOR{
	WebDriver driver=null;
    DriverFun driverFunc;

	public ProfilePageFunctions(WebDriver driver) throws InterruptedException {
		super(driver);
		this.driver = driver;
		driverFunc = BaseTestcase.getDriverFun();
		driver.manage().timeouts().pageLoadTimeout(90, TimeUnit.SECONDS);
		Thread.sleep(30000);
		if(!driver.getTitle().equalsIgnoreCase("Home - Workday")) {
			throw new SkipException("this is not Profile page");
		}
	}
	
	public boolean verifyUserName() throws InterruptedException {
		driverFunc.waitTime(welcome_name);
		String expected= ConfigManager.getProp().getProperty("name");
		String actual=welcome_name.getText();
		if(expected.equalsIgnoreCase(actual)) {
			System.out.print("\nUser matched\n " +expected +" " + actual);
			return true;
		}
		else {
			System.out.print("\nNot matched\n");
			return false;
		}
	}
	
	public PersonalDetailsFunctions profileTabs() throws InterruptedException {
		driver.manage().timeouts().pageLoadTimeout(90, TimeUnit.SECONDS);
		Thread.sleep(50000);
		//verifyUserName();
	    driverFunc.waitTime(PinfoTab);	
		driverFunc.click(PinfoTab);
		//Thread.sleep(20000);
		driverFunc.waitTime(PinfoLink);	
		driverFunc.click(PinfoLink);
		return new PersonalDetailsFunctions(driver);
	}
}
