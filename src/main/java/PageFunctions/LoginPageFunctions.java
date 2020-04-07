package PageFunctions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import ObjectRepositort.LoginPageGmail;
import TestCases.BaseTestcase;
import common.DriverFun;


public class LoginPageFunctions extends LoginPageGmail {


	WebDriver driver=null;
    DriverFun driverFunc;

	public LoginPageFunctions(WebDriver driver) {
		super(driver);
		this.driver = driver;
		driverFunc = BaseTestcase.getDriverFun();
		
	}
	public PersonalInfoFunctions login(String username, String password) throws InterruptedException  {	
		driverFunc.waitTime(emailInput);
		driverFunc.enterValues(emailInput,username);
		driverFunc.click(nextBtn);
		//Thread.sleep(2000);
		driverFunc.waitTime(passwordInput);
		driverFunc.enterValues(passwordInput,password);
		driverFunc.click(signInBtn);
		driver.manage().timeouts().pageLoadTimeout(70, TimeUnit.SECONDS);
		Thread.sleep(20000);
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.visibilityOf(Skip));
		driverFunc.click(Skip);
		return new PersonalInfoFunctions(driver);
	 
	}
	

}
