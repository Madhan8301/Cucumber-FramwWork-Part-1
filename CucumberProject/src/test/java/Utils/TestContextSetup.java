package Utils;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import pageObjects.PageObjectManager;

public class TestContextSetup {
	public WebDriver driver;
	public String ProductName;
	public PageObjectManager pageObjectManager;
	public TestBase testBase;
	public GenericUtils genericUtils;
	
	public TestContextSetup() throws IOException { 
		testBase = new TestBase();
		pageObjectManager = new PageObjectManager(testBase.getDriver());
		genericUtils = new GenericUtils(testBase.getDriver());
	}
}
