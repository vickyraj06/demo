package DemoProject.TestCases;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;


import DemoProject.Utilities.ReadConfig;

public class BaseClass {

	ReadConfig rc = new ReadConfig();

	public String url=rc.GetBaseurl();
	public String username=rc.GetUsername();
	public String password=rc.GetPassword();	
	public String Chromelocation=rc.GetLocation();
	public String FirefoxLocation =rc.GetLocationfirefox();
	public String Title =rc.GetTitle();
	public static WebDriver driver;
	public static Logger logger ;

	@Parameters("browser")
	@BeforeClass
	public void setup(String browser) {

		logger = Logger.getLogger(BaseClass.class);

		PropertyConfigurator.configure("log4j.properties");
		
		if(browser.equals("chrome")) {

			System.setProperty("webdriver.chrome.driver",Chromelocation);

			driver = new ChromeDriver();
			logger.info("CHROME BROWSER LAUNCHED");
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
			


		}
		
		else if(browser.equalsIgnoreCase("firefox"))
		{

			System.setProperty("webdriver.gecko.driver",FirefoxLocation);

			driver = new FirefoxDriver();
			logger.info("FIREFOX BROWSER LAUNCHED");
		}
		else {

			System.setProperty("webdriver.chrome.driver",Chromelocation);

			driver = new ChromeDriver();
			logger.info("CHROME BROWSER LAUNCHED");
		}

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get(url);
		logger.info("NAVIGATED TO WEBSITE");
	}

	@AfterClass
	public void teardown() {

		driver.quit();
		logger.info("BROWSER CLOSED");
	}


}
