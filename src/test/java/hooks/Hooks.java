package hooks;

import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import base.BaseClass;
import base.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
/*
 * Hooks class contains Cucumber hooks that run before and after each scenario or step.
 * 
 * - @Before: Initializes the browser, loads properties, maximizes window, and navigates to the application URL.
 * - @After: Quits the browser after scenario execution.
 * - @AfterStep: Captures screenshot on step failure and attaches it to the report.
 */
public class Hooks {

	WebDriver driver;
	Properties p;
	
    @Before
    public void setup() throws IOException {
        DriverFactory.loadConfig();  // load config first!
        DriverFactory.setDriver();
        //DriverFactory.getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        DriverFactory.getDriver().get(DriverFactory.getProperties().getProperty("appURL"));
        
    }

    @After
    public void tearDown() {
        DriverFactory.closeDriver();
    }
	
	
	@AfterStep
	public void addScreenshot(Scenario scenario) 
	{
		WebDriver driver = DriverFactory.getDriver();
		//this is cucumeber junit report
		if (scenario.isFailed()) 
		{
			TakesScreenshot ts=(TakesScreenshot)driver;
			byte[] screenshot=ts.getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshot, "image/png", scenario.getName());
			
		}
	}
	
	
}
