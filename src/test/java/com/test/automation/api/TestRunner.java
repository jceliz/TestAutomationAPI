package com.test.automation.api;



import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(publish = true,

        glue = {
                "com.test.automation.api",
        },
        plugin = {
//                "io.qameta.allure.cucumber6jvm.AllureCucumber6Jvm"
        }, monochrome = false,
        features = {
                "classpath:features"
        }
        ,
        tags = "@API"
)
public class TestRunner {
}