package PageFunctions;

import org.openqa.selenium.WebDriver;
import org.testng.SkipException;

import ObjectRepositort.PersonalDetailsOR;
import TestCases.BaseTestcase;
import common.DriverFun;

public class PersonalDetailsFunctions extends PersonalDetailsOR {

	WebDriver driver = null;
	DriverFun driverFunc;
	BaseTestcase btc;

	public PersonalDetailsFunctions(WebDriver driver) throws InterruptedException {
		super(driver);
		this.driver = driver;
		driverFunc = BaseTestcase.getDriverFun();
		Thread.sleep(10000);
		if (!driver.getTitle().equalsIgnoreCase("Change My Personal Information - Workday")) {
			throw new SkipException("this is not personal details page");
		}
	}

	public void openPersonalDetails(String text) throws InterruptedException {
		if (link1.isDisplayed()) {
			driverFunc.click(link1);
			driverFunc.waitTime(revise);
			driverFunc.click(revise);
			Thread.sleep(2000);
			System.out.println("Name is " + header.getText());
			Thread.sleep(20000);
			driverFunc.scroll(textarea);
			driverFunc.enterValues(textarea, text);
			// driverFunc.click(save);
		} else {
			System.out.println("Name is " + header.getText());
			Thread.sleep(20000);
			driverFunc.scroll(textarea);
			driverFunc.enterValues(textarea, text);
			// driverFunc.click(save);
		}
	}
}
