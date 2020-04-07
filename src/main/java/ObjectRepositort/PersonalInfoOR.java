package ObjectRepositort;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PersonalInfoOR {

	private WebDriver driver;
	
	 public PersonalInfoOR(WebDriver driver) {
	  PageFactory.initElements(driver, this);
	
}
	 //home of work-day
	 @FindBy(xpath ="//div[@title='Personal Information']")
	  protected WebElement PinfoTab;
	 
	 @FindBy(xpath ="//a[@title='Personal Information']")
	  protected WebElement PinfoLink;
	 
}
