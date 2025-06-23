package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.BasePage;
import base.DriverFactory;

public class ProductDetailsPage extends BasePage {

	WebDriver driver = DriverFactory.getDriver(); //for using the driver in methods
	public ProductDetailsPage(WebDriver driver) {
		super(driver);
		this.driver=driver; //for using the driver in methods
		
	}
	
	//Elements
	@FindBy(xpath="//div[@class='product-information']//h2")
	WebElement productTitle;
	
	@FindBy(xpath="//p[contains(text(),'Category:')]")
	WebElement productCategory;

	
	@FindBy(xpath="//div[@class='product-information']//img[contains(@src, 'rating.png')]")
	WebElement productRating;
	
	@FindBy(xpath="//span[contains(text(),'Rs')]")
	WebElement productPrice;
	
	@FindBy(xpath="//b[normalize-space()='Availability:']")
	WebElement productAvailability;
	
	@FindBy(xpath="//b[normalize-space()='Condition:']")
	WebElement productCondition;
	
	@FindBy(xpath="//b[normalize-space()='Brand:']")
	WebElement productBrand;
	
	
	//Methods
	public boolean check_isProductTitleDisplayed()
	{
		return productTitle.isDisplayed();
	}
	
	public boolean check_isProductCategoryDisplayed()
	{
		return productCategory.isDisplayed();
	}
	
	public boolean check_isProductRatingDisplayed()
	{
		return productRating.isDisplayed();
	}
	
	public boolean check_isProductPriceDisplayed()
	{
		return productPrice.isDisplayed();
	}
	
	public boolean check_isProductAvailabilityDisplayed()
	{
		return productAvailability.isDisplayed();
	}
	
	public boolean check_isProductConditionDisplayed()
	{
		return productCondition.isDisplayed();
	}
	
	public boolean check_isProductBrandDisplayed()
	{
		return productBrand.isDisplayed();
	}
	
	
	
	

}
