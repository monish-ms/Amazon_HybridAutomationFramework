/**
 * 
 */
package test;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import base.BaseClass;
import page.GiftCardsPage;
import page.HomePage;

/**
 * @author monis
 *
 */
public class TC003FilterGiftCards extends BaseClass {

	GiftCardsPage gcp;
	HomePage hp;
	
	@Test
	public void verifyGCFilter ()
	{
		
		extTest.log(LogStatus.INFO, "Gift Card test has started");
		hp= new HomePage(driver);
		hp.clickGiftCards();
		
		gcp= new GiftCardsPage(driver);
		 gcp.clickChkboxFrench();
		 extTest.log(LogStatus.INFO, "Check box has been clicked");
		 
		 
		
	}
	
}
