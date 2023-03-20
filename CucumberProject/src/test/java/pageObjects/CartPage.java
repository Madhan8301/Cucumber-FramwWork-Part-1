package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartPage {

	public WebDriver driver;
	public String Fp;

	public CartPage(WebDriver driver) {
		this.driver = driver;
	}

	By Search = By.cssSelector(".search-keyword");
	By ProductName = By.cssSelector("h4.product-name");
	By increment = By.xpath("//div[@class='product']/div[@class='stepper-input']/a[@class='increment']");
	By addToCart = By.xpath("//button[normalize-space()='ADD TO CART']");

	public void SearchProduct(String Name) throws InterruptedException {
		driver.findElement(Search).sendKeys(Name);
		Thread.sleep(2000);
	}

	public String GetProductName() {
		Fp = driver.findElement(ProductName).getText();
		return Fp;
	}

	public void AddThreeItemsToCart(String Name) throws InterruptedException {

		for (int i = 0; i < 2; i++) {
			driver.findElement(increment).click();
			Thread.sleep(1000);
		}
		driver.findElement(addToCart).click();
		Thread.sleep(2000);

	}

	public void SelectMultipleItems(List<String> items) throws InterruptedException {
		List<WebElement> AllItems = driver.findElements(ProductName);
		int c=0;
		for(int i=0;i<AllItems.size();i++) {
			String nameinCart = AllItems.get(i).getText().split("-")[0].trim();
			if(items.contains(nameinCart)) {
				c++;
				driver.findElements(addToCart).get(i).click();
				Thread.sleep(4500);
			}
			if(c==items.size()) { 
				break;
			}
		}
	}

}
