package com.practice.selenium_practice.runners;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
			features = "src/test/resources/features/", //.feature files
			glue ="com.practice.selenium_practice.stepdefinitions" //step definitions
			//optional
//			plugin = "",
//			monochrome = "",
//			tags = "",
			)

public class LoginRunner extends AbstractTestNGCucumberTests{}
