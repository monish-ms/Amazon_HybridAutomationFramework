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
		extTest.log(LogStatus.INFO,"DeliverTo PostalCode test has started");
		
		hp=new HomePage(driver);
		
		//hp.clickNavLogo();
		hp.clickDeliverToPostalCode("L3S","0B9");
		extTest.log(LogStatus.INFO, "Deliver to PostalCode has been executed");
	
		  hp.clickNavLogo();
			}
	
	@Test (priority =4)
	public void verifyDeliverToCountry() throws InterruptedException
	{
		extTest.log(LogStatus.INFO,"DeliverTo Country test has started");
		
		hp=new HomePage(driver);
		
		
		hp.clickDeliverToCountry();
		extTest.log(LogStatus.INFO, "Deliver to Country has been executed");
	}

}

