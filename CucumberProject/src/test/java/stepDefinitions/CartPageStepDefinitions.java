package stepDefinitions;

import java.io.IOException;

import org.testng.Assert;

import Utils.TestContextSetup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.CartPage;
import pageObjects.CheckOutPage;
import pageObjects.LandingPage;

public class CartPageStepDefinitions {
	
	public TestContextSetup textContextSetup;
	public String findedProduct;
	public String pName;

	
	
	public CartPageStepDefinitions(TestContextSetup textContextSetup) {
		this.textContextSetup = textContextSetup;
	}

	@Given("User Switch back to the LandingPage")
	public void user_switch_back_to_the_landing_page() throws IOException {
		
		LandingPage landingPage = textContextSetup.pageObjectManager.getLandingPage();
		landingPage.goToUrl();
	   
	}
	@When("User Searched for {string} in search box")
	public void user_searched_for_in_search_box(String productName) throws InterruptedException {
		CartPage cartPage = textContextSetup.pageObjectManager.getCartPage();
		cartPage.SearchProduct(productName);
		
	    
	}
	@Then("User Added three {string} to the cart")
	public void user_added_three_beetroot_to_the_cart(String productName) throws InterruptedException {
		CartPage cartPage = textContextSetup.pageObjectManager.getCartPage();
		cartPage.AddThreeItemsToCart(productName);
	}
	
	
	@Then("User Procedd to the checkout page and validate the items {string}")
	public void user_procedd_to_the_checkout_page_and_validate_the_items(String productName) {
		CheckOutPage chekOutPage = textContextSetup.pageObjectManager.getCheckOutPage();
		chekOutPage.goToCart();
		pName = chekOutPage.VerifyProduct();
		Assert.assertEquals(productName, pName);
	}
}
