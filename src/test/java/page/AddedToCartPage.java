/**
 * 
 */
package page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.BaseClass;
import base.BasePage;

/**
 * @author monis
 *
 */
public class AddedToCartPage extends BasePage{

	public AddedToCartPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath ="//input[@id='add-to-cart-button']")
	public WebElement btnAddToCart;
	
	
	@FindBy(xpath="//span[@class='a-button-text']")
	public WebElement  btnNoThanks;
	
	public void clickAddToCart() throws InterruptedException
	{
		BaseClass.wait=  new WebDriverWait(BaseClass.driver,20);
		BaseClass.wait.until(ExpectedConditions.visibilityOfAllElements(btnAddToCart));
		btnAddToCart.click();
		BaseClass.wait.until(ExpectedConditions.visibilityOfAllElements(btnNoThanks));
		
		BaseClass.action= new Actions(BaseClass.driver);
		BaseClass.action.moveToElement(btnNoThanks).click().perform();
		
		//btnNoThanks.click();
	    Thread.sleep(5000);
		
		
	}
	
	
}
