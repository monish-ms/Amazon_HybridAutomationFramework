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
	
	@Test(priority=1)
	public void verifySearch()
	{
		  app_logs.info("Search test has started");
		extTest.log(LogStatus.INFO,"Search test has started");
		hp= new HomePage(driver);
		
		hp.clickNavLogo();
		hp.conductSearch(config.getProperty("txtbarSearch"));
		//hp.conductSearch("Kindle");
		app_logs.info("Search test has completed");
		extTest.log(LogStatus.INFO, "Search has been conducted");
		
			
	}
	
	

}
