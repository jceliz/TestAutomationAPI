package com.test.automation.api.config;

import com.test.automation.api.stepdefinitions.BaseStepDefs;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

@CucumberContextConfiguration
@SpringBootTest(classes = BaseStepDefs.class)
public class CucumberSpringConfig {
}
