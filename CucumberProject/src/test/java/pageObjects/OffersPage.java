package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OffersPage {
	
	WebDriver driver;
	public String Fp;
	
	public OffersPage(WebDriver driver) {
		this.driver=driver;
	}
	
	By Search = By.cssSelector("#search-field");
	By Products = By.cssSelector("tr td:nth-child(1)");
	
	

	
	public void SearchProduct(String Name) throws InterruptedException {
		driver.findElement(Search).sendKeys(Name);
		Thread.sleep(2000);
	}
	
	public String GetProductName() {
		Fp = driver.findElement(Products).getText();
		return Fp;
	}
	
	

}
