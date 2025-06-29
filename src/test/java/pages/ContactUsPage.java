package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.BasePage;
import base.DriverFactory;

public class ContactUsPage extends BasePage {

	WebDriver driver; //for using the driver in methods
	public ContactUsPage(WebDriver driver) {
		super(driver);
		this.driver=driver; //for using the driver in methods
		
	}
	
	@FindBy(xpath="//input[@name='name']")
	WebElement txt_name;
	
	@FindBy(xpath="//input[@name='email']")
	WebElement txt_email;
	
	@FindBy(xpath="//input[@name='subject']")
	WebElement txt_subject;
	
	@FindBy(xpath="//textarea[@id='message']")
	WebElement txt_message;
	
	@FindBy(xpath="//input[@name='upload_file']")
	WebElement btn_chooseFile;
	
	@FindBy(xpath="//input[@name='submit']")
	WebElement btn_submit;
	
	@FindBy(xpath="//div[@class='status alert alert-success']")
	WebElement msg_success;
	
	@FindBy(xpath="//span[normalize-space()='Home']")
	WebElement btn_home;
	
	
	
	//Methods
	public void enterName(String name)
	{
		txt_name.sendKeys(name);
	}
	
	public void enterEmail(String email)
	{
		txt_email.sendKeys(email);
	}
	
	public void enterSubject(String subject)
	{
		txt_subject.sendKeys(subject);
	}
	
	public void enterMessage(String message)
	{
		txt_message.sendKeys(message);
	}
	
	public void enterFile(String File)
	{
		btn_chooseFile.sendKeys(File);
	}
	
	public void clickSubmit()
	{
		btn_submit.click();
		
		
	}
	
	public String checkSuccessMessage()
	{
		return msg_success.getText();
	}
	
	public void clickHome()
	{
		btn_home.click();
	}
	
	public boolean isSuccessMessageDisplayed()
	{
		return msg_success.isDisplayed();
	}
	
	
	
	
	
	
	
	
	

}
