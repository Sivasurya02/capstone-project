package com.ecommerce.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = "src/test/resources/features/Login.feature",
    glue = {"com.ecommerce.stepDefinitions", "com.ecommerce.hooks"},
    plugin = {"pretty", "html:target/cucumber-reports-html/login.html",
    		"json:target/cucumber-reports-json/login.json",
    		/*"json:target/allure-results/login.json",  // ✅ Important
    	    "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"*/
    		},
    monochrome = true,
    dryRun = false
)
public class LoginTestRunner extends AbstractTestNGCucumberTests {
}
