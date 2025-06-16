package stepsDefinitions;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import base.BaseClass;
import base.DriverFactory;
import io.cucumber.java.en.*;
import pages.CartPage;
import pages.CheckoutPage;
import pages.LoginPage;
import pages.PaymentPage;
import pages.ProductsPage;

public class PurchaseProductSteps {

	WebDriver driver;
	ProductsPage productspage;
	CartPage cartpage;
	CheckoutPage checkoutpage;
	PaymentPage paymentpage;
	


	public PurchaseProductSteps() {
		driver=DriverFactory.getDriver();
		productspage=new ProductsPage(driver);
		cartpage=new CartPage(driver);
		checkoutpage=new CheckoutPage(driver);
		paymentpage=new PaymentPage(driver);
	}




	@When("user clicks {string} on any product")
	public void user_clicks_on_any_product(String string) {
		productspage.clickAddToCart_MenTshirt();
		
	}

	@Then("user should see {string} message box")
	public void user_should_see_message_box(String string) {
		Assert.assertTrue(productspage.isAddedMsgDisplayed());
	}

	@Then("user should see products added in cart")
	public void user_should_see_products_added_in_cart() {
		Assert.assertTrue(cartpage.isCartTableDisplayed());
	}

	@Then("user should be redirected to {string} page")
	public void user_should_be_redirected_to_page(String page) {
		Assert.assertTrue(driver.getCurrentUrl().contains(page));
	}

	@When("user enters details for Name on Card, Card Number, CVC, Expiration Month, Expiration Year")
	public void user_enters_details_for_name_on_card_card_number_cvc_expiration_month_expiration_year() {
		paymentpage.enterNameOnCard("Test qa");
		paymentpage.enterCardNumber("12111");
		paymentpage.enterCVC("123");
		paymentpage.enterExpiration("208");
		paymentpage.enterYear("2030");
		
		
	}

	@Then("user should see {string} message")
	public void user_should_see_message(String expected) {
		Assert.assertTrue(paymentpage.isHeaderMsgDisplayed());	
	}
	
	
	@When("user clicks {string} link button")
	public void user_clicks_button(String button) {
		cartpage.clickLinkButton(button);
		
		
	}
	
	@When("user clicks {string} submit button")
	public void user_clicks_submit_button(String button) {
		paymentpage.clickPayAndConfirm();
	}



}
