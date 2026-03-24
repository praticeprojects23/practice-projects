package com.practice.tests.runners;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
/*
 * Extending AbstractTestNGCucumberTests is the standard way to run Cucumber scenarios using TestNG,
 *  acting as a bridge for BDD execution. It allows a runner class to use TestNG’s
 *   @Test and @DataProvider annotations, facilitating scenario execution, reporting,
 *    and parallel testing, typically using the io.cucumber.testng package.
 */
@CucumberOptions(
			features = "src/test/resources/features/", //.feature files
			glue ="com.practice.selenium_practice.stepdefinitions" //step definitions
			//optional
//			plugin = "",
//			monochrome = "",
//			tags = "",
			)

public class LoginRunner extends AbstractTestNGCucumberTests{}
