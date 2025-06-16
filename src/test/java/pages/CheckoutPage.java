package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import base.BasePage;
import base.DriverFactory;

public class CheckoutPage extends BasePage {
	WebDriver driver = DriverFactory.getDriver(); //for using the driver in methods
	public CheckoutPage(WebDriver driver) {
		super(driver);
		this.driver = driver; //for using the driver in methods 
	}
	
	
	public void clickLinkButton(String button)
	{
		String xpath="//a[normalize-space()='"+button+"']";
		WebElement btn=driver.findElement(By.xpath(xpath));
		btn.click();
	}

}
