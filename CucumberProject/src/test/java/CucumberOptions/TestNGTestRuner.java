package CucumberOptions;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
				  features = "src/test/java",
				  glue = "stepDefinitions",
				  monochrome=true ,
				  plugin = {"html:target/cucumber.html","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
						  "rerun:target/failed_scenarios.txt"}
				  )
public class TestNGTestRuner extends AbstractTestNGCucumberTests{
	
	@Override
	@DataProvider(parallel =true)
	public Object[][] scenarios(){
		return super.scenarios();
	}
	
	//plugin = {"html:target/cucumber.html","com.avenstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
 
}
