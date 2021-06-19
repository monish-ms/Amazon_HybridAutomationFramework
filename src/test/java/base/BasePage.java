/**
 * 
 */
package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * @author monis
 *
 */
public class BasePage {
	
	public BasePage (WebDriver driver)
	{
		PageFactory.initElements(driver,this); // comment?
	}

}
