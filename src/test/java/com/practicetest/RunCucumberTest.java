package com.practicetest;

import dev.failsafe.internal.util.Assert;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import static io.cucumber.junit.platform.engine.Constants.GLUE_PROPERTY_NAME;
import static io.cucumber.junit.platform.engine.Constants.PLUGIN_PROPERTY_NAME;
import com.libraries.TestDriver;
import java.util.concurrent.TimeUnit;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("com/practicetest")
@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value = "pretty")
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "com.practicetest")
@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value="junit:target/cucumber-reports/Cucumber.xml, json:target/cucumber-reports/Cucumber.json, html:target/cucumber-reports/Cucumber.html, timeline:target/cucumber-reports/CucumberTimeline")
public class RunCucumberTest {

    @Before
    public void setUp() {
        String browser = "chrome";
        if(browser.equals("firefox")) {
            TestDriver.driver = new FirefoxDriver();
        } else if(browser.equals("chrome")) {
            TestDriver.driver = new ChromeDriver();
        } else if(browser.equals("edge")) {
            TestDriver.driver = new EdgeDriver();
        } else{
            throw  new RuntimeException("Unrecognized system property 'browser': " + browser);
        }

        TestDriver.driver.manage().window().maximize();
        TestDriver.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS) ;
    }

    @After(order = 1)
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            byte[] screenshot = ((TakesScreenshot) TestDriver.getDriver()).getScreenshotAs(OutputType.BYTES);
            Assert.isTrue(false, "Scenario Failed");
        }
        TestDriver.getDriver().quit();
    }

}