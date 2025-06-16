package stepsDefinitions;

import org.openqa.selenium.WebDriver;

import base.BaseClass;
import base.DriverFactory;
import io.cucumber.java.en.*;
import junit.framework.Assert;
import pages.AccountCreatedPage;
import pages.LoginPage;
import pages.RegistrationPage;
import pages.TopBar;

public class RegistrationSteps {
	WebDriver driver;
	TopBar topbar;
	LoginPage loginpage;
	RegistrationPage registration;
	AccountCreatedPage accountcreatedpage;

	public RegistrationSteps() {
		driver=DriverFactory.getDriver();
		topbar = new TopBar(driver);
		loginpage = new LoginPage(driver);
		registration=new RegistrationPage(driver);
		accountcreatedpage=new AccountCreatedPage(driver);
	}

	@Given("the user is on the registration page")
	public void the_user_navigates_to_signup_page() {
		topbar.clickLogin();
	}

	@When("user Enter name and email address")
	public void user_enter_name_and_email_address() {
		loginpage.enterName(BaseClass.randomString());
		loginpage.enterSignUpEmail(BaseClass.randomString()+"_"+BaseClass.randomAlphaNumeric()+"@gmail.com");
	
	}

	@When("click {string} button")
	public void click_button(String Signup) {
		loginpage.clickButton(Signup);
	}

	@Then("user should redirected to signup page")
	public void user_should_redirected_to_signup_page() {
		driver.getCurrentUrl().equals("https://www.automationexercise.com/signup");
	}

	@When("user enter details for Title, Name, Email, Password, Date of birth")
	public void user_enter_details_for_title_name_email_password_date_of_birth() throws InterruptedException {
		registration.clickMRcheckbox();
		registration.enterName("Testrt");
		registration.enterPassword("testttt1");
		registration.selectDay("3");
		registration.selectMonth("July");
		registration.selectYear("2005");
		
	}

	@When("user select checkbox Sign up for our newsletter!")
	public void user_select_checkbox_sign_up_for_our_newsletter() {
		//registration = new RegistrationPage(BaseClass.getDriver());
		registration.clickNewsLetter();
		
	}

	@When("user select checkbox Receive special offers from our partners!")
	public void user_select_checkbox_receive_special_offers_from_our_partners() throws InterruptedException {
		//registration = new RegistrationPage(BaseClass.getDriver());
		registration.clickSpecialOffer();
		
	}

	@When("user fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number")
	public void user_fill_details_first_name_last_name_company_address_address2_country_state_city_zipcode_mobile_number() throws InterruptedException {
		registration.enterFirstName("TestRT");
		registration.enterLastName("QA");
		registration.enterCompany("QAcomp");
		registration.enterAddress1("Add city test");
		registration.enterAddress2("Add city test 2");
		registration.selectCountry("Canada");
		registration.enterCity("Test");
		registration.enterState("vancouver");
		registration.enterZipCode("123355");
		registration.enterMobile("1212121");
		
	}
	
	
	@And("user click on {string} button")
	public void user_click(String string) {
		registration.clickCreateAccount();
	}

	@Then("user should see  {string} message")
	public void user_should_see_message(String expected) {
		String actual=accountcreatedpage.getAccountCreatedText();
		Assert.assertEquals(expected, actual);
	}

	@When("user click {string} button")
	public void user_click_button(String string) {
		//accountcreatedpage.clickButton(string);
		accountcreatedpage.clickContinue();
	}

	@Then("user should see  {string} user")
	public void user_should_see_user(String expected) {
		Assert.assertTrue(topbar.checkLoggedInAsIsDisplayed());
	}

	@When("User Enter name and already registered email address {string}")
	public void user_enter_name_and_already_registered_email_address(String string) {
		loginpage.enterSignUpEmail("testrtqa@gmail.com");
	}

	@Then("User should still be on login page")
	public void user_should_still_be_on_login_page() {
	    Assert.assertTrue(driver.getCurrentUrl().contains("login"));
	}


}
