
package stepsDefinitions;

import org.openqa.selenium.WebDriver;

import base.BaseClass;
import base.DriverFactory;
import io.cucumber.java.en.Then;
import pages.LoginPage;
import pages.TopBar;
import utilities.BrokenImageChecker;

public class ImageValidationSteps {
	WebDriver driver;


	public ImageValidationSteps() {
		driver=DriverFactory.getDriver();
	}
	
	@Then("all images should not be broken")
	public void all_images_should_not_be_broken() {
		BrokenImageChecker checker = new BrokenImageChecker(driver);
	    checker.verifyAllImages();
	}

}
