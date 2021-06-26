/**
 * 
 */
package utility;

import java.io.File;

import com.relevantcodes.extentreports.DisplayOrder;
import com.relevantcodes.extentreports.ExtentReports;

/**
 * @author monis
 *
 * Class methods are called from BaseClass
 */
public class ExtentManager {

	
	static ExtentReports extent;
	
	public static ExtentReports getInstance()
	{
		
		extent = new ExtentReports(System.getProperty("user.dir")+ "\\target\\extent.html", false, DisplayOrder.NEWEST_FIRST);// initialized html extent report, false won't replace the previous ss
		//extent.loadConfig(new File(System.getProperty("user.dir")+ "\\src\\test\\resources\\extentconfig\\ReportsConfig.xml"));
		return extent;
	}
	
}
