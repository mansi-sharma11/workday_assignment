package TestCases;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;

import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import PageFunctions.LoginPageFunctions;
import PageFunctions.PersonalDetailsFunctions;
import PageFunctions.ProfilePageFunctions;
import common.ConfigManager;
import common.Driver;
import common.DriverFun;

public class BaseTestcase {
	public static Driver s;
	static DriverFun driverFun;
	public ExtentReports report;
	public ExtentTest classtest;
	public static ExtentTest test;

	
	public static DriverFun getDriverFun() {
		return driverFun;
	}

	private void setDriverFun(DriverFun driverFun) {
		this.driverFun = driverFun;
	}

	protected LoginPageFunctions loginPage;
	protected ProfilePageFunctions profilePage;
	protected PersonalDetailsFunctions Personaldetails;

	@BeforeSuite
	public void beforesuite() {
		Reporter.log("in the before suite", true);
		ExtentHtmlReporter extent = new ExtentHtmlReporter(new File(System.getProperty("user.dir")+"/Reports+SS/Workday"+DriverFun.currentDate()+".html"));
		report = new ExtentReports();
		report.attachReporter(extent);
		Reporter.log("settings done", true);

	}
	@BeforeTest
	public void beforeTest() {
		Reporter.log("CONFIG LOAD PROPERTIIES", true);

		try {
			ConfigManager.loadProperties();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String browser = ConfigManager.getProp().getProperty("browser");
		s = new Driver();
		s.startDriver(browser);
		s.getDriver();
		driverFun = new DriverFun(s.getDriver());
		setDriverFun(driverFun);
		loginPage = new LoginPageFunctions(s.getDriver());
	
		classtest = report.createTest(getClass().getName());
		classtest.log(Status.INFO, "inside the before test method");
	}
	
	@BeforeMethod
	public void beforMethod(Method method) {
		test=classtest.createNode(method.getName());
	}
	
	@AfterMethod
	public void aftermethod(ITestResult result) throws IOException {
		String pa = DriverFun.captureScreenshot(s.getDriver());
		if(result.getStatus()==ITestResult.SUCCESS) {		
			classtest.pass("Passed!!",MediaEntityBuilder.createScreenCaptureFromPath(pa).build());
			classtest.info("Info");
		}
		else if(result.getStatus()==ITestResult.FAILURE) {	
			test.log(Status.FAIL, result.getMethod().getMethodName()+"has failed");
			classtest.fail(result.getThrowable().getMessage(),MediaEntityBuilder.createScreenCaptureFromPath(pa).build());

		}
		else if(result.getStatus()==ITestResult.SKIP) {	
			test.log(Status.SKIP, result.getMethod().getMethodName()+"has skipped ");
			//classtest.skip(result.getThrowable().getMessage(),MediaEntityBuilder.createScreenCaptureFromPath(pa).build());
			classtest.skip("Skipped!!",MediaEntityBuilder.createScreenCaptureFromPath(pa).build());
		}
		report.flush();
		Reporter.log("Report generated with screenshot", true);
	}
	
	
	
	@AfterTest
	public static void afterTest() {
		s.getDriver().quit();

	}
	
}
