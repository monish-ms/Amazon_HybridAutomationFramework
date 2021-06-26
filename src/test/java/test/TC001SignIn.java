package test;



import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import base.BaseClass;
import page.HelloUserPage;
import page.HomePage;
import page.SignInPage;


public class TC001SignIn extends BaseClass{
	
	HomePage hp;
	SignInPage sp;
	HelloUserPage hup;
	
	
	@DataProvider(name="inputs")
	public Object[][] getLoginData() throws IOException
	{
		File src= new File(System.getProperty("user.dir") + "\\src\\test\\resources\\excel\\LoginData.xlsx");
		
	     FileInputStream fis= new FileInputStream (src);
	     
	     XSSFWorkbook wb= new XSSFWorkbook(fis); 
	     
	     XSSFSheet sheet= wb.getSheetAt(0);
	     
	
		
		//int rows= rowCount +1;
		
		int rowCount=sheet.getLastRowNum();
		System.out.println(rowCount);
		
		int rows = rowCount + 1;
		System.out.println(rows);
	
		int cellCount=sheet.getRow(0).getLastCellNum();
		System.out.println(cellCount);

		String data[][] = new String [rowCount][cellCount];

		for(int i=1; i<rowCount+1; i++) {
			Row r=sheet.getRow(i);

			for(int j=0; j<cellCount; j++) {
				System.out.println(data[i-1][j]=r.getCell(j).getStringCellValue());
			}
		}
		
		return data;
	}
	
	/*@BeforeMethod
	public void init()
	{
		System.setProperty("webdriver.gecko.driver","C:\\Users\\monis\\eclipse-workspace\\Amazon_HybridAutomationFramework\\src\\test\\resources\\browser\\geckodriver.exe");		
	     driver= new FirefoxDriver ();
	     // Initializing Page Factory Objects
	     //hp=PageFactory.initElements(driver, HomePage.class);
	     hp=new HomePage(driver);
	     sp= PageFactory.initElements(driver, SignInPage.class);
	     hup= PageFactory.initElements(driver, HelloUserPage.class);
	     driver.get("https://www.amazon.ca/");
	     driver.manage().window().maximize();
	     driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    
	}*/
	
	
	@Test(dataProvider="inputs", priority=6)
	public void verifyLogin(String uname, String pwd)
	{
		System.out.println("Test has started");
		try {
			
			
			
			hp= new HomePage(driver);
			
		
			hp.moveToSignIn();
			//hp.clickSignIn();
           extTest.log(LogStatus.INFO, "Clicked SignIn button");  
			
			
            // hp.clickNavLogo();
           
			sp= new SignInPage (driver);
			
		
			sp.doLogin(uname,pwd);
			extTest.log(LogStatus.INFO,"User is signed in with username and password");
			
			hup= new HelloUserPage (driver);
			
			Assert.assertEquals(hup.getAcctUserName(), hup.expected_username);
			extTest.log(LogStatus.INFO,"Verifying LogIn");

			
			System.out.println(hup.getAcctUserName());
		    extTest.log(LogStatus.INFO,"SignIn test completed");
			
		    Thread.sleep(1000);
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	/*@AfterMethod 
	public void tearDown()
	{
		driver.close();
		System.out.println("After method has been executed");
		
	}*/

}
