package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.BasePage;
import base.DriverFactory;

public class CartPage extends BasePage {
	WebDriver driver = DriverFactory.getDriver(); //for using the driver in methods
	public CartPage(WebDriver driver) {
		super(driver);
		this.driver=driver; //for using the driver in methods
		
	}
	
	@FindBy(xpath="//div[@id='cart_info']")
	WebElement table_cart;
	
	
	
	
	public boolean isCartTableDisplayed()
	{
		try {
		if(table_cart.isDisplayed()==true)
		{
			return true;
		}
		else
		{
			return false;
		}
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}
	
	public void clickLinkButton(String button)
	{
		
		String xpath="//a[normalize-space()='"+button+"']";
		//WebElement btn=driver.findElement(By.xpath(xpath));
		//btn.click();
		
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
		WebElement element=wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		element.click();
		
		
	}
	

}
