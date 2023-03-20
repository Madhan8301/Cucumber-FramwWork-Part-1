package stepDefinitions;

import java.util.Arrays;
import java.util.List;



import Utils.TestContextSetup;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.CartPage;
import pageObjects.CheckOutPage;
import pageObjects.LandingPage;

public class FunctionalTestingStepDefinitions {
	
	
	public TestContextSetup textContextSetup;
	public String[] arr = {"Brocolli","Mushroom","Pomegranate","Raspberry","Walnuts","Almonds"};
	public List<String> Items =Arrays.asList(arr);


	
	
	public FunctionalTestingStepDefinitions(TestContextSetup textContextSetup) {
		this.textContextSetup = textContextSetup;
	}

	@Given("^User Navigated to landing Page$")
	public void user_navigated_to_landing_page() throws Throwable {
		LandingPage landingPage = textContextSetup.pageObjectManager.getLandingPage();
		landingPage.goToUrl();
	}

	@When("^User adds the List of Item to the cart$")
	public void user_adds_the_list_of_item_to_the_cart() throws Throwable {
		CartPage cartPage = textContextSetup.pageObjectManager.getCartPage();
		
		cartPage.SelectMultipleItems(Items);
		

	}

	@Then("^User Click on CartPage and Proceed to CheckoutPage$")
	public void user_click_on_cartpage_and_proceed_to_checkoutpage() throws Throwable {
		CheckOutPage chekOutPage = textContextSetup.pageObjectManager.getCheckOutPage();
		chekOutPage.goToCart();

	}

	@And("^User validates the Item in the CheckoutPage$")
	public void user_validates_the_item_in_the_checkoutpage() throws Throwable {
		CheckOutPage chekOutPage = textContextSetup.pageObjectManager.getCheckOutPage();
		chekOutPage.VerifyAllProducts(Items);
	}

}
