package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.BasePage;
import base.DriverFactory;

public class AccountCreatedPage extends BasePage{
	
	
	
	WebDriver driver; //for using the driver in methods
	public AccountCreatedPage(WebDriver driver) {
		super(driver);
		this.driver = driver; //for using the driver in methods
		
	}
	
	@FindBy(xpath="//b[normalize-space()='Account Created!']")
	WebElement header_accountCreated;
	
	@FindBy(xpath="//a[normalize-space()='Continue']")
	WebElement btn_continue;
	
	public String getAccountCreatedText()
	{
		return header_accountCreated.getText();
	}
	
	public void clickButton(String button)
	{
		String xpath="//button[contains(text(),'"+button+"')]";
		WebElement btn=driver.findElement(By.xpath(xpath));
		JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", btn);
	}
	
	public void clickContinue()
	{
		btn_continue.click();
	}
	

}
