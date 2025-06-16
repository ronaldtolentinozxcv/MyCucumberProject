package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.BasePage;
import base.DriverFactory;

public class PaymentPage extends BasePage {
	WebDriver driver = DriverFactory.getDriver(); //for using the driver in methods
	public PaymentPage(WebDriver driver) {
		super(driver);
		this.driver = driver; //for using the driver in methods 
	}
	
	@FindBy(xpath="//input[@name='name_on_card']")
	WebElement txt_nameOnCard;
	
	@FindBy(xpath="//input[@name='card_number']")
	WebElement txt_cardNumber;
	
	@FindBy(xpath="//input[@placeholder='ex. 311']")
	WebElement txt_cvc;
	
	@FindBy(xpath="//input[@placeholder='MM']")
	WebElement txt_expiration;
	
	@FindBy(xpath="//input[@placeholder='YYYY']")
	WebElement txt_year;
	
	@FindBy(xpath="//button[@id='submit']")
	WebElement btn_payAndConfirmOrder;
	
	@FindBy(xpath="//b[normalize-space()='Order Placed!']")
	WebElement header_orderPlaced;
	
	public boolean isHeaderMsgDisplayed()
	{
		if(header_orderPlaced.isDisplayed()==true)
		{
			return true;
		}
		else
		{
			return false;
		}
		
	}
	
	
	public void enterNameOnCard(String name)
	{
		txt_nameOnCard.sendKeys(name);
	}
	
	public void enterCardNumber(String num)
	{
		txt_cardNumber.sendKeys(num);
	}
	
	public void enterCVC(String cvc)
	{
		txt_cvc.sendKeys(cvc);
	}
	
	public void enterExpiration(String exp)
	{
		txt_expiration.sendKeys(exp);
	}
	
	public void enterYear(String yr)
	{
		txt_year.sendKeys(yr);
	}
	
	public void clickPayAndConfirm()
	{
		btn_payAndConfirmOrder.click();
	}
	
	
	
	
	
	
	
	

}
