package stepDefinition;

import org.junit.AfterClass;
import org.openqa.selenium.WebDriver;

import common.Log;
import common.utilities;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Steps {

	@Given("^I am at the Account\\/Login page$")
	public void i_am_at_the_account_login_page() throws InterruptedException {
		System.out.println("url here is"+utilities.OR.getProperty("url"));
		utilities.Launchurl(utilities.OR.getProperty("url"));
		utilities.clickByLinkText(utilities.OR.getProperty("LoginLink"));
		Log.info("Clicked on the login element in the main page");

	}

	@When("^I enter the account username$")
	public void i_enter_the_account_username() {
		Log.info("Entering the username");
		utilities.enterField(utilities.OR.getProperty("userNameBtn"), (utilities.OR.getProperty("username")));

	}

	@When("^I enter the password$")
	public void i_enter_the_password() {

		Log.info("entering the password");
		utilities.enterField(utilities.OR.getProperty("passwordBtn"), (utilities.OR.getProperty("password")));

	}

	@When("^I click the login button$")
	public void i_click_the_login_button() throws InterruptedException {
		utilities.clickByButton((utilities.OR.getProperty("LoginBtn")));
		Log.info("Clicked on Login Button");

	}

	@Then("^I should be at the home page$")
	public void i_should_be_at_the_home_page() {
		utilities.validatePageTitle("STORE");
		Log.info("The page title has been successfully verified");
		Log.info("User logged in successfully");

	}

	@Given("^I click on phones categories$")
	public void i_click_on_phones_categories() throws Throwable {
		utilities.clickByLinkText((utilities.OR.getProperty("phoneCategories")));
		Log.info("Clicked on Phone Categories");
	
	}

	@When("^I add the item to Cart$")
	public void i_add_the_item_to_Cart() throws Throwable {
		utilities.clickByLinkText("Samsung galaxy s6");
		utilities.clickByLinkText(utilities.OR.getProperty("addToCart"));
		utilities.acceptAlert();
		Log.info("Clicked on item to add to cart");
	   
	}

	@Then("^the item is added to the Cart$")
	public void the_item_is_added_to_the_Cart() throws Throwable {
		utilities.clickByLinkText((utilities.OR.getProperty("cart")));
		utilities.getTextByCss(utilities.OR.getProperty("addedProduct")).contains("Samsung galaxy s6");
		Log.info("Item added to the cart");
	
	}
}
