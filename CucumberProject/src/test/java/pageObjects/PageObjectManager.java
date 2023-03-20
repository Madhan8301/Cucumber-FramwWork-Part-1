package pageObjects;

import org.openqa.selenium.WebDriver;

public class PageObjectManager {

	public LandingPage landingPage;
	public OffersPage offersPage;
	public CartPage cartPage;
	public CheckOutPage chekOutPage;
	public WebDriver driver;
	
	public PageObjectManager(WebDriver driver) {
		this.driver = driver;
	}
	public LandingPage getLandingPage() {
		landingPage = new LandingPage(driver);
		return landingPage;
	}
	
	public OffersPage getOffersPage() {
		offersPage = new OffersPage(driver);
		return offersPage;
	}
	public CartPage getCartPage() {
		cartPage = new CartPage(driver);
		return cartPage;
	}
	public CheckOutPage getCheckOutPage() {
		chekOutPage = new CheckOutPage(driver);
		return chekOutPage;
	}
}
