package ObjectRepositort;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProfilePageOR {

	private WebDriver driver;
	
	 public ProfilePageOR(WebDriver driver) {
	  PageFactory.initElements(driver, this);
	
}
	 //title
	 @FindBy(xpath="//title")
	 protected WebElement title;
	 //name of the profile
	 @FindBy(xpath="//h1[@data-automation-id='landingPageWelcomeCardHeading']")
	 protected WebElement welcome_name;
	 //home of work-day
	 @FindBy(xpath ="//div[@title='Personal Information']")
	  protected WebElement PinfoTab;
	 
	 @FindBy(xpath ="//a[@title='Personal Information']")
	  protected WebElement PinfoLink;
	 
}
