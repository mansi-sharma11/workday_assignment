package PageFunctions;


import org.openqa.selenium.WebDriver;

import ObjectRepositort.PersonalDetailsOR;
import TestCases.BaseTestcase;
import common.DriverFun;
import junit.framework.Assert;

public class PersonalDetailsFunctions extends PersonalDetailsOR{

	WebDriver driver=null;
    DriverFun driverFunc;
    BaseTestcase btc;
	public PersonalDetailsFunctions(WebDriver driver) {
		super(driver);
		this.driver = driver;
		driverFunc = BaseTestcase.getDriverFun();
		// TODO Auto-generated constructor stub
	}
	
	  	public void Details(String text) throws InterruptedException {
		Thread.sleep(30000);
        //2 extras here
        if(link1.isDisplayed()) {
        	 driverFunc.click(link1);
             driverFunc.waitTime(revise);	
             driverFunc.click(revise);
             Thread.sleep(2000);
             System.out.println("Name is "+header.getText());
             Assert.assertTrue(isTitleMatched());
      		System.out.println("Aseert executed");
             Thread.sleep(20000);
             driverFunc.scroll(textarea);
     		 driverFunc.enterValues(textarea, text);
     		driverFunc.click(save);
        }
	}
	  /*	public void EnterComment(String text) throws InterruptedException {
	   * driverFunc.scroll(textarea);
     		 driverFunc.enterValues(textarea, text);
     		// driverFunc.click(save);
	  		
	  	}
*/
		public boolean isTitleMatched() {
			
			if(TitleName.getText().equalsIgnoreCase("Mansi Sharma")) {
			 return true;
			}
			else {
			return false;
			}
		}
}
