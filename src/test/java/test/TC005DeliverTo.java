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
public class TC005DeliverTo extends BaseClass {
	
	HomePage hp;
	
	@Test (priority =5)
	public void verifyDeliverToPostalCode() throws InterruptedException
	{
		app_logs.info("DeliverToPostalCode test has started");
		extTest.log(LogStatus.INFO,"DeliverTo PostalCode test has started");
		
		hp=new HomePage(driver);
		
		//hp.clickNavLogo();
		hp.clickDeliverToPostalCode("L3S","0B9");
		extTest.log(LogStatus.INFO, "Deliver to PostalCode has been executed");
		app_logs.info("DeliverToPostalCode test has completed");
		
			}
	
	@Test (priority =4)
	public void verifyDeliverToCountry() throws InterruptedException
	{
		app_logs.info("DeliverToCountry test has started");
		extTest.log(LogStatus.INFO,"DeliverToCountry test has started");
		
		hp=new HomePage(driver);
		
		
		hp.clickDeliverToCountry();
		extTest.log(LogStatus.INFO, "DeliverToCountry has been executed");
		app_logs.info("DeliverToCountry test has completed");
	}

}

