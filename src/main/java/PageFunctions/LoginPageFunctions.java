package PageFunctions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.SkipException;

import ObjectRepositort.LoginPageOR;
import TestCases.BaseTestcase;
import common.DriverFun;


public class LoginPageFunctions extends LoginPageOR {


	WebDriver driver=null;
    DriverFun driverFunc;

	public LoginPageFunctions(WebDriver driver) {
		super(driver);
		this.driver = driver;
		driverFunc = BaseTestcase.getDriverFun();
		if(!driver.getTitle().equalsIgnoreCase("Sign in - Google Accounts")) {
			throw new SkipException("this is not gmail page");
		}
		
	}
	
	public ProfilePageFunctions login(String username, String password) throws InterruptedException  {	
		driverFunc.waitTime(emailInput);
		driverFunc.enterValues(emailInput,username);
		driverFunc.click(nextBtn);
		//Thread.sleep(2000);
		//driverFunc.waitTime(passwordInput);
		driverFunc.enterValues(passwordInput,password);
		//driverFunc.click(signInBtn);
		driver.manage().timeouts().pageLoadTimeout(70, TimeUnit.SECONDS);
		Thread.sleep(20000);
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOf(Skip));
		driverFunc.click(Skip);
		Thread.sleep(20000);
		return new ProfilePageFunctions(driver);
	 
	}
	

}
