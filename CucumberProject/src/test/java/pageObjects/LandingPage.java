package pageObjects;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LandingPage {
	
	WebDriver driver;
	public String Fp;
	
	public LandingPage(WebDriver driver) {
		this.driver=driver;
	}
	
	By Search = By.cssSelector(".search-keyword");
	By ProductName = By.cssSelector("h4.product-name");
	By Top_Deals = By.linkText("Top Deals");
	
	
	
	public void goToUrl() throws IOException {
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\resources\\global.properties");
		Properties prop = new Properties();
		prop.load(fis);
		String actualUrl = prop.getProperty("url");
		driver.get(actualUrl);
	}
	
	public void SearchProduct(String Name) throws InterruptedException {
		driver.findElement(Search).sendKeys(Name);
		Thread.sleep(2000);
	}
	
	public String GetProductName() {
		Fp = driver.findElement(ProductName).getText();
		return Fp;
	}
	
	public void move_To_TopDeals() throws InterruptedException {
		driver.findElement(Top_Deals).click();
		Thread.sleep(2000);
	}

}
