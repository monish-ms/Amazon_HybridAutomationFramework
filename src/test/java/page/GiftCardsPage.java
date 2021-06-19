/**
 * 
 */
package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.BasePage;

/**
 * @author monis
 *
 */
public class GiftCardsPage extends BasePage {

	public GiftCardsPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	
	@FindBy (xpath="//div[@id='s-refinements']//div[1]//ul[1]//li[2]//span[1]//a[1]//div[1]//label[1]//i[1]")
	public WebElement chkboxFrench;
	
	
	public void clickChkboxFrench()
	{
		chkboxFrench.click();
	}
	
	
	
}
