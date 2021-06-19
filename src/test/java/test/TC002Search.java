/**
 * 
 */
package test;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import base.BaseClass;
import page.HomePage;

/**
 * @author monis
 *
 */
public class TC002Search extends BaseClass {
	
	HomePage hp;
	
	@Test
	public void verifySearch()
	{
		hp= new HomePage(driver);
		
		
		hp.conductSearch("Kindle");
		extTest.log(LogStatus.INFO, "Search has been conducted");
		
			
	}
	
	

}
