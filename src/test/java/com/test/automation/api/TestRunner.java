package com.test.automation.api;



import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(publish = true,

        glue = {
                "com.test.automation.api","com.test.automation.api.config"
        },
        plugin = {"pretty","html:target/cucumber-reports.html"
        }, monochrome = true,
        features = {
                "classpath:features"
        }
        ,
        tags = "@API"
)
public class TestRunner {
}