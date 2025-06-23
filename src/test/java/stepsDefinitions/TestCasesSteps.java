package stepsDefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import base.DriverFactory;
import io.cucumber.java.en.*;
import pages.TestCasesPage;
import pages.TopBar;

public class TestCasesSteps {
	WebDriver driver;
	TopBar topbar;
	TestCasesPage testcasespage;


	public TestCasesSteps() {
		driver=DriverFactory.getDriver();
		topbar=new TopBar(driver);
		testcasespage=new TestCasesPage(driver);
	}


	@Given("the user is on the home page")
	public void the_user_is_on_the_home_page() {
		System.out.println(driver.getCurrentUrl());
	}


	@When("the user clicks {string} from the top bar")
	public void the_user_clicks_from_the_top_bar(String string) {
		topbar.clickTopBarItem(string);
	}

	@Then("the Test Cases page should be displayed")
	public void the_test_cases_page_should_be_displayed() {
		Assert.assertTrue(driver.getCurrentUrl().contains("test_cases"));	
	}

	@When("the user clicks each test case panel")
	public void the_user_clicks_each_test_case_panel() {
		testcasespage.clickAllTestCase();
	}

	@Then("all test cases should expand and display their descriptions")
	public void all_test_cases_should_expand_and_display_their_descriptions() {
		Assert.assertTrue(testcasespage.checkCollapse());
	}
	
	@Then("user should see {int} test cases")
	public void user_should_see_test_cases(Integer int1) {
		int expected=int1.intValue();
		Assert.assertEquals(expected, testcasespage.checkNumberOfTestCases());
		
	}





}
