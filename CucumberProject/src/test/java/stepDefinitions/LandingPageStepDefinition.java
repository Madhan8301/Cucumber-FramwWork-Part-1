package stepDefinitions;

import Utils.TestContextSetup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pageObjects.LandingPage;

public class LandingPageStepDefinition {
	public TestContextSetup textContextSetup;

	
	
	public LandingPageStepDefinition(TestContextSetup textContextSetup) {
		this.textContextSetup = textContextSetup;
	}

	
	@Given("^User is no Landing page$")
	public void user_is_no_landing_page() throws Throwable {
		LandingPage landingPage = textContextSetup.pageObjectManager.getLandingPage();
		landingPage.goToUrl();
		
	}

	
    @When("^User searched for a product (.+) and extracted the name$")
    public void user_searched_for_a_product_and_extracted_the_name(String strArg1) throws Throwable {
		
		LandingPage landingPage = textContextSetup.pageObjectManager.getLandingPage();
		landingPage.SearchProduct(strArg1);
		textContextSetup.ProductName = landingPage.GetProductName().split("-")[0].trim();
		System.out.println(textContextSetup.ProductName);
		
		
	}

	

}
