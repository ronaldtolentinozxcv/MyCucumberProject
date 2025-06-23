package stepsDefinitions;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.BaseClass;
import base.DriverFactory;
import io.cucumber.java.en.*;

import pages.LoginPage;
import pages.TopBar;

public class LoginSteps {
	WebDriver driver;
	TopBar topbar;
	LoginPage loginpage;

	public LoginSteps() {
		driver=DriverFactory.getDriver();
		topbar = new TopBar(driver);
		loginpage = new LoginPage(driver);
	}


	@Given("user is on login page")
	public void user_is_on_login_page() {
		//topbar=new TopBar(base.BaseClass.getDriver());
		base.BaseClass.getLogger().info("=====Clicking login button=====");
		topbar.clickLogin();


	}

	@When("user enters {string} and {string}")
	public void user_enters_and(String username, String password) {
		//loginpage = new LoginPage(base.BaseClass.getDriver());
		base.BaseClass.getLogger().info("=====Entering username and password=====");
		loginpage.enterEmail(username);
		loginpage.enterPassword(password);
	}


	@When("user clicks {string} button")
	public void user_clicks_button(String button) {
		loginpage = new LoginPage(driver);
		loginpage.clickButton(button);
	}


	@Then("user is redirected accordingly {string}")
	public void user_is_redirected_to_homepage_if_status_is(String status) {
		base.BaseClass.getLogger().info("=====\"Validating login result for status: \" + status=====");
		if(status.equalsIgnoreCase("valid"))    
		{
			Assert.assertTrue(topbar.checkLoggedInIsdisplayed());

		}
		else
		{
			Assert.assertTrue(driver.getCurrentUrl().equals("https://www.automationexercise.com/login"));
		}




	}





}
