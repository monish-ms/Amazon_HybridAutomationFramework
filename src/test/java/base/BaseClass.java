/**
 * 
 */
package base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

//import org.apache.logging.log4j.Logger;
import org.apache.log4j.Logger;
import org.apache.commons.collections4.Get;
//import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.logging.LoggingHandler;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;


import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

//import filedemo.LoggingFile;
import utility.ExtentManager;

/**
 * @author monis
 *
 *
 */
public class BaseClass {
	
	public static  WebDriver driver = null;     // declaring Webdriver object
	public static Properties config= new Properties();  // Instantiating Properties object
	public ExtentReports extRep= ExtentManager.getInstance(); //Instantiating Extent Reports object
	public static ExtentTest extTest; // declaring Extent Test object
	public static WebDriverWait wait= null;  //declaring WebDriverWait object
	public static Alert alert= null; //declaring Alert object
	public static Actions action= null; // declaring Actions object
	public static Logger app_logs = Logger.getLogger("LogAmazon_HybridAutomationProject"); // Instantiating logger class for application/selenium logs and log4j properties
	
	@BeforeSuite   // @Before annotated method will be executed before all test classes configured to be executed in testNG xml file
	public void init() throws IOException
	{
		app_logs.debug("Test suite has launched");
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\config.properties"); // connects to config.properties file
		config.load(fis); // loads config.properties file
		
		app_logs.debug("Loading the config property file for project");
		
		
		
		System.out.println("Before Suite has started");
		
		
		/*  code block to check which browser is used to test the url */
		if (config.getProperty("browser").equalsIgnoreCase("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+ "\\src\\test\\resources\\browser\\chromedriver.exe");
			driver = new ChromeDriver();
			app_logs.debug("Chrome browser has been launched");
		}else if (config.getProperty("browser").equalsIgnoreCase("Firefox"))
		{
			System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+ "\\src\\test\\resources\\browser\\geckodriver.exe");
			driver=new FirefoxDriver();
			app_logs.debug("Firefox browser has been launched");
		}else if (config.getProperty("browser").equalsIgnoreCase("Edge"))
		{
			System.setProperty("webdriver.edge.driver", System.getProperty("user.dir")+ "src\\test\\resources\\browser\\msedgedriver.exe");
		    driver = new EdgeDriver();
		    app_logs.debug("Edge browser has been launched");
		}
		/* code block ends */
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS); // global implicit wait of 20s
		driver.get(config.getProperty("testURL")); // open the website under test

		
		
		
	}
	
	
	
	@AfterSuite     //@After annotated method will be executed after all test classes are executed in testNG xml file
	public void teardown()
	{
		
		driver.quit();// closes all browser windows associated with the driver
		app_logs.debug("Test suite has ended");
		
	}
	
	
	
	
	

}
