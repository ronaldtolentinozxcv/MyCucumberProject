package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BasePage;
import base.DriverFactory;

public class LoginPage extends BasePage {
	WebDriver driver = DriverFactory.getDriver();
	public LoginPage(WebDriver driver) {
		super(driver);
		this.driver = driver; //for using the driver in methods
		
	}
	
	@FindBy(xpath="//input[@data-qa='login-email']")
	WebElement txt_email;
	
	@FindBy(xpath="//input[@placeholder='Password']")
	WebElement txt_password;
	
	@FindBy(xpath="//input[@placeholder='Name']")
	WebElement txt_name;
	
	@FindBy(xpath="//input[@data-qa='signup-email']")
	WebElement txt_signUpEmail;
	
	
	@FindBy(xpath="//button[normalize-space()='Login']")
	WebElement btn_login;
	
	
	
	public void clickButton(String button)
	{
		
		String xpath="//button[contains(text(),'"+button+"')]";
		driver.findElement(By.xpath(xpath)).click();
	}
	
	
	public void enterEmail(String email)
	{
		txt_email.sendKeys(email);
	}
	
	public void enterPassword(String password)
	{
		txt_password.sendKeys(password);
	}
	
	public void clickLogin()
	{
		btn_login.click();
	}
	
	public void enterName(String name)
	{
		txt_name.sendKeys(name);
	}
	
	public void enterSignUpEmail(String email)
	{
		txt_signUpEmail.sendKeys(email);
	}
	

}
