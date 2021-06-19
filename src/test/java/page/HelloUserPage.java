package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.BasePage;

public class HelloUserPage extends BasePage {
	
	WebDriver driver;
	public String  actual_username;
	public String expected_username = "Hello, Monish";
	
	
	public HelloUserPage(WebDriver driver) {
		super(driver);    // comments?
	
	}

	
	@FindBy(xpath="//span[@id='nav-link-accountList-nav-line-1']")
	public WebElement acctUserName;
	
	public String getAcctUserName()
	{
		return acctUserName.getText();
		
	}

}
