package stepDefinitions;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;



import Utils.TestContextSetup;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;

public class Hooks {
	
	public TestContextSetup textContextSetup;
	public Hooks(TestContextSetup textContextSetup) {
		this.textContextSetup=textContextSetup;
		
	}
	
	@After
	public void CloseBrowser() throws IOException {
		textContextSetup.testBase.getDriver().quit();
	}
	
	@AfterStep
	public void getScreenShot(Scenario scenario) throws IOException {
		WebDriver driver = textContextSetup.testBase.getDriver();
		if(scenario.isFailed()) {
			File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			byte[] fis = FileUtils.readFileToByteArray(src);
			scenario.attach(fis, "image/png", "image");
		}
		
	}

}
