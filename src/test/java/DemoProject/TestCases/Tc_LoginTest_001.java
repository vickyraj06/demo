package DemoProject.TestCases;

import java.awt.AWTException;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import DemoProject.pageObjects.LoginPage;

public class Tc_LoginTest_001 extends BaseClass{

	public static LoginPage lp ;

	@Test
	public static void LoginTest() throws AWTException, IOException  {

		logger.info("Tc_LoginTest_001 TESTING STARTED");

		
		lp = new LoginPage(driver);
		BaseClass baseClass = new BaseClass();
		lp.SetUsername(baseClass.username);
		logger.info("USERNAME ENTERED");
		lp.SetPassword(baseClass.password);
		logger.info("PASSWORD ENTERED");
		lp.ClickLogin();
		logger.info("LOGIN BUTTON CLICKED");

		String Expected_Title=baseClass.Title;
		String Actual_Title=driver.getTitle();

		if(Actual_Title.equals(Expected_Title)) {

			Assert.assertTrue(true);
			logger.info("TITLE MATCHED -- PASSED");
		}

		else {

			logger.error("TITLE NOT MATCHING -- FAILED");
			Assert.assertTrue(false);
			

		}
		logger.info("Tc_LoginTest_001 TESTING FINISHED");



	}


}
