package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

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
	  @FindBy(xpath="//a[@href='/gp/browse.html?node=9230166011&ref_=nav_cs_gc_521dead25f684fd0b0c54d72ee7ac2c9\\']")
	public WebElement tabGiftCards;
	
	
	public void moveToSignIn()   
	{
		//Actions action= new Actions(driver);
		//action.moveToElement(moveTo).perform();
		moveTo.click();
	}
	
	public void clickSignIn()
	{
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
}
