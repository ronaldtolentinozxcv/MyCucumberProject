package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.BasePage;
import base.DriverFactory;

public class ProductsPage extends BasePage {

	WebDriver driver = DriverFactory.getDriver(); //for using the driver in methods
	public ProductsPage(WebDriver driver) {
		super(driver);
		this.driver=driver; //for using the driver in methods
		
	}
	
	//============================Elements=============================
	@FindBy(xpath="//div[@class='single-products']//img")
	List<WebElement> images;
	
	@FindBy(xpath="//input[@id='search_product']")
	WebElement txt_search;
	
	@FindBy(xpath="//button[@id='submit_search']")
	WebElement btn_search;
	
	@FindBy(xpath="//h2[normalize-space()='Searched Products']")
	WebElement header_searchedProducts;
	
	@FindBy(xpath="//div[@class='productinfo text-center']//p")
	List<WebElement> title_products;
	
	@FindBy(xpath="//div[@class='features_items']//h2[@class='title text-center']")
	WebElement header_products;
	
	@FindBy(xpath="(//a[contains(text(),'Add to cart')])[3]")
	WebElement btn_addToCart2;
	
	@FindBy(xpath="//h4[normalize-space()='Added!']")
	WebElement msg_added;
	
	@FindBy(xpath="(//a[contains(text(),'View Product')])[1]")
	WebElement btn_viewProduct1;
	
	public void clickViewProduct1()
	{
		btn_viewProduct1.click();
	}
	
	
	public void clickAddToCart_MenTshirt()
	{
		btn_addToCart2.click();
	}
	
	public boolean isAddedMsgDisplayed()
	{
		
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
		WebElement elem=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//h4[normalize-space()='Added!']")));
		try {
		return elem.isDisplayed();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}
	
	public void clickButton(String button)
	{
		
		String xpath="//button[normalize-space()='"+button+"']";
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
		WebElement btn=wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
		btn.click();
		
	}
	
	public boolean checkProductsIsDisplayed()
	{
		if(!title_products.isEmpty())
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public int countNumberOfImages()
	{
		return images.size();
	}
	
	public void enterSearchField(String search)
	{
		txt_search.sendKeys(search);
	}
	
	public void clickSearchButton()
	{
		btn_search.click();
	}
	
	public void clickMainCategory(String main)
	{
		
		String xpath="//div[@class='panel-group category-products']//a[normalize-space()='"+main+"']";
		driver.findElement(By.xpath(xpath)).click();
	}
	
	public void clickSubCategory(String sub)
	{
	
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		String xpath="//div[@class='panel-group category-products']//a[normalize-space()='"+sub+"']";
		WebElement subCategory=wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", subCategory);
		
		//subCategory.click();
	}
	
	public String checkProductHeaderText()
	{
		String actual=header_products.getText();
		String normalize=actual.replaceAll("\\s+", " ");
		return normalize;
		
		
	}
	
	public void clickBrand(String brand)
	{
	
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		String xpath="//div[@class='brands_products']//a[@href='/brand_products/"+brand+"']";
		WebElement element=wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		element.click();
	}
	
	
		
	
	
	

}
