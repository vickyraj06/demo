package DemoProject.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	public WebDriver driver;


	public LoginPage(WebDriver driver) {

		this.driver=driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath ="//input[@name='username']")
	WebElement TextUsername;


	@FindBy(xpath ="//input[@name='password1']")
	WebElement TextPassword;

	@FindBy(xpath ="//*[@name='login']")
	WebElement ButLogin;


	@FindBy(xpath ="//*[@name='logout']")
	WebElement ButLogout;



	public void SetUsername(String user) {

		TextUsername.sendKeys(user);
	}

	public void SetPassword(String pass) {

		TextPassword.sendKeys(pass);
	}

	public void ClickLogin() {

		ButLogin.click();
	}

	public void ClickLogout() {

		ButLogout.click();
	}

}
