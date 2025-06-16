package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import base.BasePage;
import base.DriverFactory;

public class RegistrationPage extends BasePage {
	WebDriver driver = DriverFactory.getDriver(); //for using the driver in methods
	public RegistrationPage(WebDriver driver) {
		super(driver);
		this.driver = driver; //for using the driver in methods
	}

	//==================================Elements=========================================================
	@FindBy(xpath="//b[normalize-space()='Enter Account Information']")
	WebElement header_enterAccountInfo;

	@FindBy(xpath="//input[@id='id_gender1']")
	WebElement checkbox_mr;

	@FindBy(xpath="//input[@id='name']")
	WebElement txt_name;

	@FindBy(xpath="//input[@id='password']")
	WebElement txt_password;

	@FindBy(xpath="//select[@id='days']")
	WebElement dropdown_day;

	@FindBy(xpath="//select[@id='months']")
	WebElement dropdown_month;

	@FindBy(xpath="//select[@id='years']")
	WebElement dropdown_year;

	@FindBy(xpath="//div[@class='checkbox']//input[@id='newsletter']")
	WebElement checkbox_newsLetter;

	@FindBy(xpath="//input[@id='optin']")
	WebElement checkbox_specialOffers;

	@FindBy(xpath="//input[@id='first_name']")
	WebElement txt_firstName;

	@FindBy(xpath="//input[@id='last_name']")
	WebElement txt_lastName;

	@FindBy(xpath="//input[@id='company']")
	WebElement txt_company;

	@FindBy(xpath="//input[@id='address1']")
	WebElement txt_address;

	@FindBy(xpath="//input[@id='address2']")
	WebElement txt_address2;

	@FindBy(xpath="//select[@id='country']")
	WebElement dropdown_country;

	@FindBy(xpath="//input[@id='state']")
	WebElement txt_state;

	@FindBy(xpath="//input[@id='city']")
	WebElement txt_city;

	@FindBy(xpath="//input[@id='zipcode']")
	WebElement txt_zip;

	@FindBy(xpath="//input[@id='mobile_number']")
	WebElement txt_mobile;

	@FindBy(xpath="//button[normalize-space()='Create Account']")
	WebElement btn_createAccount;


	//======================================Methods======================================================
	public void clickMRcheckbox() 
	{
		checkbox_mr.click();
	}

	public void enterName(String name)
	{
		txt_name.sendKeys(name);
	}

	public void enterPassword(String password)
	{
		txt_password.sendKeys(password);
	}

	public void selectDay(String day)
	{
		Select dy=new Select(dropdown_day);
		dy.selectByVisibleText(day);
	}	

	public void selectMonth(String month)
	{
		Select dropdownMonth=new Select(dropdown_month);
		dropdownMonth.selectByVisibleText(month);
	}

	public void selectYear(String year)
	{
		Select yr=new Select(dropdown_year);
		yr.selectByValue(year);
	}

	public void clickNewsLetter()
	{
		//checkbox_newsLetter.click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", checkbox_newsLetter);
	}

	public void clickSpecialOffer()
	{
		//checkbox_specialOffers.click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", checkbox_specialOffers);
	}

	public void enterFirstName(String fname) 
	{
		txt_firstName.sendKeys(fname);
	}

	public void enterLastName(String lname) 
	{
		txt_lastName.sendKeys(lname);
	}

	public void enterCompany(String company) 
	{
		txt_company.sendKeys(company);
	}

	public void enterAddress1(String address) 
	{
		txt_address.sendKeys(address);
	}

	public void enterAddress2(String address2) 
	{
		txt_address2.sendKeys(address2);
	}

	public void selectCountry(String country)
	{
		Select cn=new Select(dropdown_country);
		cn.selectByVisibleText(country);
	}

	public void enterState(String state)
	{
		txt_state.sendKeys(state);
	}

	public void enterCity(String city)
	{
		txt_city.sendKeys(city);
	}

	public void enterZipCode(String zip)
	{
		txt_zip.sendKeys(zip);
	}

	public void enterMobile(String mobile)
	{
		txt_mobile.sendKeys(mobile);
	}

	public void clickCreateAccount()
	{
		btn_createAccount.click();
	}

	public void clickButton(String button)
	{
		String xpath="//button[contains(text(),'"+button+"')]";
		driver.findElement(By.xpath(xpath)).click();

	}










}
