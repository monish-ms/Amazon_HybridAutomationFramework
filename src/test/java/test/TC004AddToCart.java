/**
 * 
 */
package test;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import base.BaseClass;
import page.AddedToCartPage;
import page.HomePage;
import page.SearchResultsPage;

/**
 * @author monis
 *
 */
public class TC004AddToCart extends BaseClass {
	
	HomePage hp;
	SearchResultsPage srp;
	AddedToCartPage atcp;
	
        @Test (priority=3)
        public void verifyAddToCart() throws InterruptedException
        {
        	extTest.log(LogStatus.INFO, "Add to Cart test has started");
        	hp= new HomePage(driver);
        	hp.clickNavLogo();
        	//hp.doSearch("Kindle white papercase");
        	hp.doSearch(config.getProperty("txtSearch"));
        	extTest.log(LogStatus.INFO, "Product has been searched");
        	
        	srp=new SearchResultsPage(driver);
        	srp.clickProduct();
        	extTest.log(LogStatus.INFO, "Product has been selected");
        	
        	atcp=new AddedToCartPage(driver);
        	atcp.clickAddToCart();
        	extTest.log(LogStatus.INFO, "Product has been added to cart");
        	
        	extTest.log(LogStatus.INFO,"Add to Cart has ended");
        	
        }
}
