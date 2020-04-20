package common;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.Status;
import TestCases.BaseTestcase;

public class DriverFun {

	private WebDriver driver=null;

	public DriverFun(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public void enterValues(WebElement ele, String value) {
		try {
		ele.sendKeys(value);
		}catch (Exception e) {
			System.out.println(e.getMessage());
			BaseTestcase.test.log(Status.ERROR, "in exception block  "+e.getMessage());

		}
	}
	
	public void click(WebElement ele) {
		try {
			ele.click();
		}catch (Exception e) {
			System.out.println(e.getMessage());
			BaseTestcase.test.log(Status.ERROR, "in exception block  "+e.getMessage());

		}
	}
	
	public void waitTime(WebElement ele) {
		WebDriverWait wait = new WebDriverWait(driver, 70);
		wait.until(ExpectedConditions.visibilityOf(ele));	
	}
	
	
	public void scroll(WebElement ele) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", ele);
	}
	
	public static String captureScreenshot(WebDriver driver) {
	   File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	   String sspath = System.getProperty("user.dir")+"/Screenshots/SS"+currentDate()+".png";
	   try
	    {
	    	FileHandler.copy(src, new File(sspath));
	    	System.out.println("ScreenShot taken!");

	    	
	    }catch(IOException e) {
	    	System.out.println("Unable to SS!! "+e.getMessage());
			BaseTestcase.test.log(Status.ERROR, "in exception block  "+e.getMessage());

	}
	   return sspath;
}
	public static String currentDate() {
		DateFormat dateFormat = new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
		 
		 //get current date time with Date()
		 Date date = new Date();
		 
		 // Now format the date
		 return dateFormat.format(date);
		
	}
	
	
	
	
	
}
