package page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.BaseClass;
import base.BasePage;

public class HomePage extends BasePage{
	
	
	//WebDriver driver;
	
		
	public HomePage(WebDriver driver)
	{
		super (driver);
	}
	
	@FindBy(id="nav-link-accountList-nav-line-1")
	public WebElement moveTo;
	
	@FindBy(className="nav-action-inner")
	public WebElement btnSignIn;
	
	@FindBy (id="twotabsearchtextbox")
	public WebElement txtSearch;
	
	
	@FindBy(id="nav-search-submit-button")
	public WebElement btnSearch;
	
	
	//@FindBy(xpath= "//a[@href='/gp/browse.html?node=9230166011&ref_=nav_cs_gc_521dead25f684fd0b0c54d72ee7ac2c9\']")
	  @FindBy(xpath="//a[@href='/gp/browse.html?node=9230166011&ref_=nav_cs_gc_521dead25f684fd0b0c54d72ee7ac2c9\']")
	public WebElement tabGiftCards;
	  
	  
	  @FindBy(xpath="//span[@id='glow-ingress-line1']")
	  public WebElement linkDeliverTo;
	 
	
	  @FindBy(id="GLUXZipUpdateInput_0")
	  public WebElement txtbx1PostalCode;
	  
	  @FindBy(id="GLUXZipUpdateInput_1")
	  public WebElement txtbx2PostalCode;
	  
	  @FindBy(css="input[aria-labelledby='GLUXZipUpdate-announce']")
	  public WebElement btnApply;
	  
	  @FindBy(css="#nav-global-location-popover-link")
	  public WebElement linkalterDeliverTo;
	
	  @FindBy(xpath="//span[@class='a-dropdown-container']")
	  public WebElement drpCountry;
	  
	  @FindBy(xpath="//div[@class='a-popover-inner a-lgtbox-vertical-scroll']//a[@id='GLUXCountryList_5']")
	  public WebElement optionCountryUK;
	  
	  
	  @FindBy(id="nav-logo-sprites")
	  public WebElement logoNav;
	  
	  
	  
	public void moveToSignIn()   
	{
		//Actions action= new Actions(driver);
		//action.moveToElement(moveTo).perform();
		BaseClass.wait.until(ExpectedConditions.visibilityOfAllElements(moveTo));
		moveTo.click();
	}
	
	public void clickSignIn()
	{
		BaseClass.wait.until(ExpectedConditions.visibilityOfAllElements(btnSignIn));
		btnSignIn.click();
	}
	
	
	public void conductSearch(String prdname)     // TC002Search 
	{
	      txtSearch.sendKeys(prdname);
	      btnSearch.click();
	}

	
	public void clickGiftCards()
	{
	    tabGiftCards.click();
	    
	}
	
	public void doSearch(String prdname)
	{
		txtSearch.sendKeys(prdname);
		txtSearch.sendKeys(Keys.ARROW_DOWN);
		txtSearch.sendKeys(Keys.ENTER);
	}
	
	public void clickDeliverToPostalCode (String pc1, String pc2) throws InterruptedException
	{
		BaseClass.wait=  new WebDriverWait(BaseClass.driver,20);
		BaseClass.wait.until(ExpectedConditions.elementToBeClickable(linkDeliverTo));			
		linkDeliverTo.click();
		BaseClass.wait.until(ExpectedConditions.elementToBeClickable(txtbx1PostalCode));
		txtbx1PostalCode.sendKeys(pc1);
		txtbx2PostalCode.sendKeys(pc2);
		btnApply.click();
		Thread.sleep(2000);
		
		
			
	}
		public void clickDeliverToCountry() throws InterruptedException
		{
			BaseClass.wait=  new WebDriverWait(BaseClass.driver,20);
			BaseClass.wait.until(ExpectedConditions.elementToBeClickable(linkalterDeliverTo));
			linkalterDeliverTo.click();
			Thread.sleep(8000);
			BaseClass.wait.until(ExpectedConditions.elementToBeClickable(drpCountry));
			drpCountry.click();
			Thread.sleep(3000);
			optionCountryUK.click();
			Thread.sleep(5000);
			
			
		}
		
		public void clickNavLogo()
		{
			logoNav.click();
		}

	}

