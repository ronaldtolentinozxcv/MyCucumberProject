package runners;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

//@RunWith(Cucumber.class)
@CucumberOptions(
		features= {".//Features/"}, 
		//features= {"@reports/Failed Scenarios/rerun.txt"},
		glue={"stepsDefinitions", "hooks"},
		plugin= {"pretty", "html:reports/Cucumber Report/myreport.html",
				"json:reports/JSON Report/JSONreport.report",
				"junit:reports/JUnit Report/JSONreport.xml",
				"rerun:reports/Failed Scenarios/rerun.txt",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
		},
		//tags="@smoketest",
		//tags="@regression",
		tags="@smoketest and @regression", //Scenarios tagged with both @smoketest and @regression
		//tags="@smoketest and not @regression" //Scenarios tagged with @smoketest but not tagged with @regression
		//tags="@smoketest or @regression" //Scenarios tagged with either @smoketest or @regression
		dryRun=false,
		monochrome=true,
		publish=true
		


		)	
public class Runner extends AbstractTestNGCucumberTests  {
	@Override
    @org.testng.annotations.DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }

}
