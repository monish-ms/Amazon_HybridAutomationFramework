/**
 * 
 */
package base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import utility.ExtentManager;

/**
 * @author monis
 *
 *We initialize WebDriver, 
 */
public class BaseClass {
	
	public static  WebDriver driver = null;
	public Properties config= new Properties();
	public ExtentReports extRep= ExtentManager.getInstance();
	public static ExtentTest extTest;
	
	@BeforeSuite   // @Before annotated method will be executed before all test classes configured to be executed in testNG xml file
	public void init() throws IOException
	{
		
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\config.properties"); // connects to config.properties file
		config.load(fis); // loads config.properties file
		
		System.out.println("Before Suite has started");
		
		
		/*  code block to check which browser is used to test the url */
		if (config.getProperty("browser").equalsIgnoreCase("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+ "\\src\\test\\resources\\browser\\chromedriver.exe");
			driver = new ChromeDriver();
		}else if (config.getProperty("browser").equalsIgnoreCase("Firefox"))
		{
			System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+ "\\src\\test\\resources\\browser\\geckodriver.exe");
			driver=new FirefoxDriver();
			
		}else if (config.getProperty("browser").equalsIgnoreCase("Edge"))
		{
			System.setProperty("webdriver.edge.driver", System.getProperty("user.dir")+ "src\\test\\resources\\browser\\msedgedriver.exe");
		    driver = new EdgeDriver();
		}
		/* code block ends */
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS); // global implicit wait of 20s
		driver.get(config.getProperty("testURL")); // open the website under test

		
		System.out.println("Before Suite has ended");
		
	}
	
	
	
	@AfterSuite     //@After annotated method will be executed after all test classes are executed in testNG xml file
	public void teardown()
	{
		
		driver.quit();// closes all browser windows associated with the driver
		System.out.println("After suite has ended");
		
	}
	
	
	
	
	

}
