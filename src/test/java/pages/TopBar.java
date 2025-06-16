package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.BasePage;
import base.DriverFactory;

public class TopBar extends BasePage {
	WebDriver driver = DriverFactory.getDriver();
	public TopBar(WebDriver driver) {
		super(driver);
		this.driver = driver; //for using the driver in methods
	}
	
	@FindBy(xpath="//a[normalize-space()='Home']")
	public WebElement btn_home;
	
	@FindBy(xpath="//a[normalize-space()='Products']")
	public WebElement btn_products;
	
	@FindBy(xpath="//a[normalize-space()='Cart']")
	public WebElement btn_cart;
	
	@FindBy(xpath="//a[contains(text(),'Signup / Login')]")
	public WebElement btn_signUpLogin;

	
	@FindBy(xpath="//a[contains(text(),'Test Cases')]")
	public WebElement btn_testCases;
	
	@FindBy(xpath="//a[contains(text(),'API Testing')]")
	public WebElement btn_apiTesting;
	
	@FindBy(xpath="//a[contains(text(),'Video Tutorials')]")
	public WebElement btn_videoTutorials;
	
	@FindBy(xpath="//a[contains(text(),'Contact us')]")
	public WebElement btn_contactUs;
	
	@FindBy(xpath="//a[contains(text(),'Logged in as')]")
	public WebElement btn_loggedIn;
	
	
	
	
	public void clickTopBarItem(String button)
	{
//		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(10));
//		WebElement element=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(normalize-space(text()),'"+button+"')]")));
//		element.click();
		
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		    By locator = By.xpath("//a[contains(normalize-space(text()),'" + button + "')]");
		    wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		    WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
		    element.click();
	}
	
	
	public void clickLogin() {
		btn_signUpLogin.click();
	}
	
	public boolean checkLoggedInIsdisplayed()
	{
		try
		{
		return btn_loggedIn.isDisplayed();
		}
		catch (Exception e)
		{
			e.getStackTrace();
			return false;
		}
	}
	
	public boolean checkLoggedInAsIsDisplayed()
	{
		return btn_loggedIn.isDisplayed();
	}
	
	public void clickProducts()
	{
		btn_products.click();
	}

}
