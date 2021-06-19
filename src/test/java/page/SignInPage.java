package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.BasePage;


public class SignInPage extends BasePage {
	
	
	
	WebDriver driver;
	
	
	public SignInPage (WebDriver driver)
	{
		super (driver);
	}
	
	@FindBy(id="ap_email")
	public WebElement txtUserName ;
	
	@FindBy(id="continue")
	public WebElement btnContinue;
	
	@FindBy(id="ap_password")
	public WebElement txtPassword;
	
	@FindBy(id="signInSubmit")
	public WebElement btnSignInSubmit;
	
	public void doLogin(String myusername, String mypassword)
	{
		txtUserName.sendKeys(myusername);
		btnContinue.click();
		txtPassword.sendKeys(mypassword);
		btnSignInSubmit.click();
		
	}

}
