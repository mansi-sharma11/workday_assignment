package PageFunctions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import ObjectRepositort.PersonalInfoOR;
import TestCases.BaseTestcase;
import common.DriverFun;

public class PersonalInfoFunctions extends PersonalInfoOR{
	WebDriver driver=null;
    DriverFun driverFunc;

	public PersonalInfoFunctions(WebDriver driver) {
		super(driver);
		this.driver = driver;
		driverFunc = BaseTestcase.getDriverFun();
	}

	public PersonalDetailsFunctions intoDetails() throws InterruptedException {
		driver.manage().timeouts().pageLoadTimeout(70, TimeUnit.SECONDS);
		Thread.sleep(20000);
	    driverFunc.waitTime(PinfoTab);	
		driverFunc.click(PinfoTab);
		//Thread.sleep(20000);
		driverFunc.waitTime(PinfoLink);	
		driverFunc.click(PinfoLink);
		return new PersonalDetailsFunctions(driver);
	}
}
