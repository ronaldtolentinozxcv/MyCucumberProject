package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/*
 * BasePage serves as the parent class for all page objects.
 * It initializes web elements using Selenium's PageFactory and stores the WebDriver instance.
 * All page classes can extend this class to inherit common setup functionality.
 */
public class BasePage {

	WebDriver driver;

	public BasePage(WebDriver driver) {
		this.driver = DriverFactory.getDriver();
		PageFactory.initElements(driver, this);
	}

}
