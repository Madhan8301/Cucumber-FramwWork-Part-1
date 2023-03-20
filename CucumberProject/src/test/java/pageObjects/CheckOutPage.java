package pageObjects;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckOutPage {

	public WebDriver driver;
	public String pName;
	
	
	public CheckOutPage(WebDriver driver) {
		this.driver = driver;
	}
	
	By Cart = By.xpath("//a/img[@alt='Cart']");
	
	By Checkout = By.xpath("//button[normalize-space()='PROCEED TO CHECKOUT']");
	By ProductName = By.cssSelector(".product-name");
	
	public void goToCart() {
		driver.findElement(Cart).click();
		driver.findElement(Checkout).click();
			
	}
	
	public String VerifyProduct() {
		
		pName = driver.findElement(ProductName).getText().split("-")[0].trim();
		return pName;
	}

	public void VerifyAllProducts(List<String> items) {
		List<WebElement> ListofAddedProduct = driver.findElements(ProductName);
		int ans=0;
		for(int i=0;i<ListofAddedProduct.size();i++) {
			String ExName =ListofAddedProduct.get(i).getText();
			if(items.contains(ExName)) {
				ans++;
			}
		}
		if(ans==items.size()) {
			System.out.println("All Items are Present.....");
		}
	}
	
	

}
