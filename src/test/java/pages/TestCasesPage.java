package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.BasePage;
import base.DriverFactory;

public class TestCasesPage extends BasePage {

	WebDriver driver; //for using the driver in methods
	public TestCasesPage(WebDriver driver) {
		super(driver);
		this.driver = driver; //for using the driver in methods
	}

	//Elements
	@FindBy (xpath="//h4//u")
	List<WebElement> links_testcases;


	//Methods
	
	public int checkTotalTestCases()
	{
		return links_testcases.size();
	}
	
	
	public int checkNumberOfTestCases()
	{
		return links_testcases.size();
	}

	public void clickAllTestCase()
	{

		for(int i=1; i<=links_testcases.size(); i++)
		{
			String xpath="(//h4//u)["+i+"]";
			WebElement tc=driver.findElement(By.xpath(xpath));
			JavascriptExecutor js=(JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView()", tc);
			js.executeScript("arguments[0].click()", tc);
		}

	}

	public boolean checkCollapse()
	{
		for(int i=1; i<=links_testcases.size(); i++)
		{
			String xpath="//div[@id='collapse"+i+"']";
			String attr=driver.findElement(By.xpath(xpath)).getAttribute("class");
			System.out.println("Status of testcase "+ i +" :"+attr);
			if(!attr.contains("in"))
			{
				return false;
			}
		}
		return true;





	}


}
