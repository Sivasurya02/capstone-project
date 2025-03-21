package com.ecommerce.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = "src/test/resources/features/CategoriesAndBrand.feature",
    glue = {"com.ecommerce.stepDefinitions", "com.ecommerce.hooks"},
    plugin = {
        "pretty",
        "html:target/cucumber-reports-html/CategoriesAndBrand.html",
        "json:target/cucumber-reports-json/CategoriesAndBrand.json",
        /*"json:target/allure-results/CategoriesAndBrand.json",  // ✅ Important
	    "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"*/
        },
    monochrome = true,
    dryRun = false
)
public class CategoriesAndBrandTestRunner extends AbstractTestNGCucumberTests {
}
