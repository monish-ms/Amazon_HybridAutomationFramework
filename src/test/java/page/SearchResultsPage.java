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
public class SearchResultsPage extends BasePage {

	public SearchResultsPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	
	@FindBy(xpath="//img[@data-image-index='1']")
	public WebElement imgProduct;
	
  	
	public void clickProduct()
	{
		imgProduct.click();
		
	}

}
