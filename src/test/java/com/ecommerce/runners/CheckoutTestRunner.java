package com.ecommerce.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = "src/test/resources/features/Checkout.feature",
    glue = {"com.ecommerce.stepDefinitions", "com.ecommerce.hooks"},
    plugin = {
        "pretty",
        "html:target/cucumber-reports-html/checkout.html",
        "json:target/cucumber-reports-json/checkout.json",
        /*"json:target/allure-results/checkout.json",  // ✅ Important
	    "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm" */   
        },
    monochrome = true,
    dryRun = false
)
public class CheckoutTestRunner extends AbstractTestNGCucumberTests {
}
