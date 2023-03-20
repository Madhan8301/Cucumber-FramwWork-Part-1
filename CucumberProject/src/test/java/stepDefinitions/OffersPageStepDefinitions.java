package stepDefinitions;

import org.testng.Assert;

import Utils.TestContextSetup;
import io.cucumber.java.en.Then;
import pageObjects.LandingPage;
import pageObjects.OffersPage;
import pageObjects.PageObjectManager;

public class OffersPageStepDefinitions {

	public String OfferProductName;
	public String childid;
	public String parentid;
	public PageObjectManager pgm1;
public TestContextSetup textContextSetup;
	
	public OffersPageStepDefinitions(TestContextSetup textContextSetup) {
		this.textContextSetup = textContextSetup;
	}
	
	@Then("^User searched (.+) in the offer page and extraced the name$")
    public void user_searched_in_the_offer_page_and_extraced_the_name(String strArg1) throws Throwable {
		
		
		switchToOffersPage();
		OffersPage offersPage = textContextSetup.pageObjectManager.getOffersPage();
		
		
		offersPage.SearchProduct(strArg1);
		
		OfferProductName = offersPage.GetProductName();
		
	}
	
	public void switchToOffersPage() throws InterruptedException {
		
		
		LandingPage landingPage = textContextSetup.pageObjectManager.getLandingPage();
		landingPage.move_To_TopDeals();
		textContextSetup.genericUtils.SwitchToChildWindow();
		
	}

	@Then("^validate the name in productPage and offersPage matches$")
	public void validate_the_name_in_productpage_and_offerspage_matches() throws Throwable {

		Assert.assertEquals(OfferProductName, textContextSetup.ProductName);
		
	}
}
