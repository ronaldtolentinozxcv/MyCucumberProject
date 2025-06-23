package stepsDefinitions;

import java.io.IOException;
import java.util.Properties;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import base.BaseClass;
import base.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;
import pages.ProductDetailsPage;
import pages.ProductsPage;
import pages.TopBar;

public class ProductsSteps {

	WebDriver driver;
	TopBar topbar;
	LoginPage loginpage;
	ProductsPage productpage;
	Properties p;
	ProductDetailsPage productdetailspage;

	public ProductsSteps() throws IOException {
		driver = DriverFactory.getDriver();
		topbar = new TopBar(driver);
		loginpage = new LoginPage(driver);
		productpage = new ProductsPage(driver);
		productdetailspage = new ProductDetailsPage(driver);
		p = BaseClass.getProperties();

	}

	@Given("the user is logged in")
	public void the_user_is_logged_in() {
		topbar = new TopBar(driver);
		// topbar.clickLogin();
		topbar.clickTopBarItem("Signup / Login");
		loginpage.enterEmail(p.getProperty("email"));

		loginpage.enterPassword(p.getProperty("password"));
		loginpage.clickLogin();

	}

	@And("user navigates to {string} page")
	public void user_navigates_to_page(String item) {
		topbar = new TopBar(DriverFactory.getDriver());
		topbar.clickTopBarItem(item);
	}

	@When("user is on Products page")
	public void user_is_on_products_page() {
		productpage = new ProductsPage(DriverFactory.getDriver());
		BaseClass.getCurrentURL().contains("products");
	}

	@Then("user should see {int} product images displayed")
	public void user_should_see_product_images_displayed(Integer expectedCount) {
		productpage = new ProductsPage(DriverFactory.getDriver());
		int expected = expectedCount.intValue();
		int actual = productpage.countNumberOfImages();
		Assert.assertEquals(expected, actual);
	}

	@When("user enters {string} in search field")
	public void user_enters_in_search_field(String search) {
		productpage = new ProductsPage(DriverFactory.getDriver());
		productpage.enterSearchField(search);
	}

	@When("clicks search button")
	public void clicks_search_button() {
		productpage = new ProductsPage(DriverFactory.getDriver());
		productpage.clickSearchButton();
	}

	@Then("products related to Tshirt should be displayed")
	public void products_related_to_tshirt_should_be_displayed() {
		productpage = new ProductsPage(DriverFactory.getDriver());
		Assert.assertTrue(productpage.checkProductsIsDisplayed());
	}

	@When("user selects subcategory {string} and {string}")
	public void user_selects_subcategory_and(String main, String sub) {
		productpage = new ProductsPage(DriverFactory.getDriver());
		productpage.clickMainCategory(main);
		productpage.clickSubCategory(sub);
	}

	@Then("only products under {string} subcategory should be displayed")
	public void only_products_under_subcategory_should_be_displayed(String sub) {
		productpage = new ProductsPage(DriverFactory.getDriver());
		String expected = sub.toLowerCase();
		String actual = (productpage.checkProductHeaderText().toLowerCase());
		String normalize = actual.replaceAll("\\s+", " ");
		Assert.assertTrue(normalize.contains(expected));
	}

	@When("user clicks {string}")
	public void user_clicks(String brand) {
		// productpage=new ProductsPage(DriverFactory.getDriver());
		productpage.clickBrand(brand);
	}

	@Then("only products under {string} should be displayed")
	public void only_products_under_should_be_displayed(String brand) {
		// productpage=new ProductsPage(DriverFactory.getDriver());
		String actual = productpage.checkProductHeaderText().toLowerCase();
		String expected = brand.toLowerCase();
		Assert.assertTrue(actual.contains(expected));
	}

	@Then("user should see products displayed")
	public void user_should_see_products_displayed() {
		// productpage=new ProductsPage(DriverFactory.getDriver());
		Assert.assertTrue(productpage.checkProductsIsDisplayed());
	}

	@When("the user clicks on {string} of the first product")
	public void the_user_clicks_on_of_the_first_product(String string) {
		productpage.clickViewProduct1();
	}

	@Then("the user should be landed on the product detail page")
	public void the_user_should_be_landed_on_the_product_detail_page() {
		driver.getCurrentUrl().contains("product_details");
	}

	@Then("the product name, category, rating, price, availability, condition, and brand should be visible")
	public void the_product_name_category_price_availability_condition_and_brand_should_be_visible() {
		Assert.assertTrue(productdetailspage.check_isProductTitleDisplayed());
		Assert.assertTrue(productdetailspage.check_isProductCategoryDisplayed());
		Assert.assertTrue(productdetailspage.check_isProductRatingDisplayed());
		Assert.assertTrue(productdetailspage.check_isProductPriceDisplayed());
		Assert.assertTrue(productdetailspage.check_isProductAvailabilityDisplayed());
		Assert.assertTrue(productdetailspage.check_isProductConditionDisplayed());
		Assert.assertTrue(productdetailspage.check_isProductBrandDisplayed());
	}

}
