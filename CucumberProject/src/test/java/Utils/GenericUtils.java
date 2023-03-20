package Utils;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;

public class GenericUtils {

	
	public WebDriver driver;
	public String parentid;
	public String childid;
	
	public GenericUtils(WebDriver driver) {
		this.driver=driver;
	}
	
	public void SwitchToChildWindow() throws InterruptedException {
		Set<String> handle = driver.getWindowHandles();
		Iterator <String> it = handle.iterator();
		
		parentid = it.next();
		childid = it.next();
		
		driver.switchTo().window(childid);
		Thread.sleep(2000);
	}
	
	public void SwitchToParendWindow() {
		driver.switchTo().window(parentid);
	}
	
}
