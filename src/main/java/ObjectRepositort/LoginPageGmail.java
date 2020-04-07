package ObjectRepositort;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageGmail {
	private WebDriver driver;
	
	 public LoginPageGmail(WebDriver driver) {
	  PageFactory.initElements(driver, this);
	
}
	 
	 @FindBy(xpath ="//input[@id='Email']")
	  protected WebElement emailInput;
	 
	 @FindBy(xpath ="//input[@id='next']")
	  protected WebElement nextBtn;
	 
	 @FindBy(xpath = "//input[@type='password']")
	 protected WebElement passwordInput;
	
	 @FindBy(xpath = "//input[@id='signIn']")
	 protected WebElement signInBtn;
	 
	 @FindBy(xpath="//input[@name='Pin']")
	 protected WebElement Pin;
	 
     @FindBy(xpath="//input[@type='submit']")
     protected WebElement Done;
     
     @FindBy(xpath ="//input[@type='checkbox']")
	  protected WebElement check;
	 
	 //@FindBy(xpath ="//button/span[text()='Submit']")
     @FindBy(xpath="//button[@title='Submit']")
	  protected WebElement Btn;
     
     @FindBy(xpath="//button[@data-automation-id='linkButton']")
     protected  WebElement Skip;
   
}
