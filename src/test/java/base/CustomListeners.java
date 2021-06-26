package base;


import java.io.IOException;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.relevantcodes.extentreports.LogStatus;





public class CustomListeners extends BaseClass implements ITestListener, ISuiteListener {

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		extTest= extRep.startTest(result.getName().toUpperCase());
		
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub

try {
			
			utility.Utilities.captureScreenshot();
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		extTest.log(LogStatus.PASS,result.getName().toUpperCase()+ " PASS");
		extTest.log(LogStatus.INFO, extTest.addScreenCapture(utility.Utilities.screenshotName));
		extRep.endTest(extTest);
		extRep.flush(); // captures action in html report
		
		
		
		
		        
				
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		

		try {
			
			utility.Utilities.captureScreenshot();
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		        
				extTest.log(LogStatus.FAIL, result.getName().toUpperCase()+" Failed with exception : "+result.getThrowable());
				extTest.log(LogStatus.INFO, extTest.addScreenCapture(utility.Utilities.screenshotName));
				extRep.endTest(extTest);
				extRep.flush();
		
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
		extTest.log(LogStatus.SKIP,result.getName().toUpperCase() + "Skipped the test");
		extRep.endTest(extTest);
		extRep.flush();
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ISuite suite) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ISuite suite) {
		// TODO Auto-generated method stub
		
	}

}
