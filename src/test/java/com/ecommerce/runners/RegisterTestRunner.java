package com.ecommerce.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = "src/test/resources/features/Register.feature",
    glue = {"com.ecommerce.stepDefinitions", "com.ecommerce.hooks"},
    plugin = {"pretty", "html:target/cucumber-reports-html/register.html",
    		"json:target/cucumber-reports-json/register.json",
    		 /*"json:target/allure-results/register.json",  // ✅ Important
    		    "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"*/
    },
    monochrome = true,
    dryRun = false
)
public class RegisterTestRunner extends AbstractTestNGCucumberTests {
}
