package com.practice.tests.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.practice.framework.driver.DriverFactory;
import com.practice.framework.utils.WaitUtils;

public class BaseTest {

	protected WebDriver driver;
	protected WebDriverWait wait;


	@BeforeMethod
	public void setUp() {
		DriverFactory.initDriver();
		driver = DriverFactory.getDriver();

		//using utility, and value obtained from config file
		wait = WaitUtils.createWait(driver);
	}

	@AfterMethod(alwaysRun = true)
	public void tearDown() {
		DriverFactory.quitDriver();
	}
}