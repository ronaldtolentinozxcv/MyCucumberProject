package stepsDefinitions;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;

import base.DriverFactory;
import io.cucumber.java.en.*;
import junit.framework.Assert;
import pages.ContactUsPage;
import pages.LoginPage;
import pages.TopBar;

public class ContactUsSteps {

	WebDriver driver;
	TopBar topbar;
	ContactUsPage contactuspage;
	

	public ContactUsSteps() {
		driver=DriverFactory.getDriver();
		topbar = new TopBar(driver);	
		contactuspage = new ContactUsPage(driver);
	}




	@Given("the user is on the Contact Us page")
	public void the_user_is_on_the_contact_us_page() {
		topbar.clickTopBarItem("Contact us");
	}

	@When("the user enters name {string}")
	public void the_user_enters_name(String name) {		
		contactuspage.enterName(name);		
	}

	@When("enters email {string}")
	public void enters_email(String email) {
		contactuspage.enterEmail(email);
	}

	@When("enters subject {string}")
	public void enters_subject(String sub) {
		contactuspage.enterSubject(sub);
	}

	@When("enters message {string}")
	public void enters_message(String msg) {
		contactuspage.enterMessage(msg);
	}

	@When("uploads a file")
	public void uploads_a_file() {
		String filePath=System.getProperty("user.dir") + "/src/test/resources/testtext.txt";
		contactuspage.enterFile(filePath);
	}

	@When("clicks the Submit button")
	public void clicks_the_submit_button() {
		contactuspage.clickSubmit();
		
	}
	
	@And("clicks Ok on Alert message")
	public void clicks_ok_on_alert_message() {
		Alert alert=driver.switchTo().alert();
		alert.accept();
		
	}
	
	
	

	@Then("a success message {string} should be displayed")
	public void a_success_message_should_be_displayed(String expected) {
		String actual=contactuspage.checkSuccessMessage();
		Assert.assertEquals(expected, actual);
	}

	@Then("the user clicks the {string} button")
	public void the_user_clicks_the_button(String string) {
		contactuspage.clickHome();
	}

	@Then("the user should be navigated to the homepage")
	public void the_user_should_be_navigated_to_the_homepage() {
		Assert.assertTrue(driver.getCurrentUrl().equals("https://www.automationexercise.com/"));
	}

	@Then("user should not see Success message")
	public void user_should_not_see_success_message() {

		if(!contactuspage.isSuccessMessageDisplayed())
		{
			Assert.assertTrue(true);
		}
		else
		{
			Assert.fail();
		}
	}



}
