package common;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Driver {
	static WebDriver driver=null;
	public void startDriver(String browser) {
	
		switch (browser) {
		case "chrome":
			//WebDriverManager.chromedriver().setup();
			System.setProperty("webdriver.chrome.driver","C:/Users/mansi.sharma1/Downloads/chromedriver_win32/chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

			//driver.manage().window().maximize();
		break;

		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;

		default:
			break;
		}
		driver.get(ConfigManager.getProp().getProperty("url"));
		setDriver(driver);
		
	}
	
	public WebDriver getDriver() {
		return driver;
	}

	public static void setDriver(WebDriver driver) {
		Driver.driver = driver;
	}


}
	/*String browserName = prop.getProperty("browser");
	
	if(browserName.equals("chrome")) {
		System.setProperty("webdriver.chrome.driver","C:/Users/mansi.sharma1/Downloads/chromedriver_win32/chromedriver.exe");
		driver = new ChromeDriver();
	}*/




