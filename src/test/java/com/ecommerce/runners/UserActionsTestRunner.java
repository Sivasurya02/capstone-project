package com.ecommerce.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = "src/test/resources/features/UserActions.feature",
    glue = {"com.ecommerce.stepDefinitions", "com.ecommerce.hooks"},
    plugin = {"pretty", "html:target/cucumber-reports-html/userActions.html",
    		"json:target/cucumber-reports-json/userActions.json",
    		 /*"json:target/allure-results/userActions.json",  // ✅ Important
    		    "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"*/
    		},
    monochrome = true,
    dryRun = false
)
public class UserActionsTestRunner extends AbstractTestNGCucumberTests {
}
