package com.practice.tests.stepdefinitions;

//import java.time.Duration;

import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

//import com.practice.framework.config.ConfigReader;
import com.practice.framework.driver.DriverFactory;
import com.practice.framework.pages.LoginPage;
import com.practice.framework.pages.SecureAreaPage;
import com.practice.tests.testdata.LoginTestData;
//import io.cucumber.java.After;
//import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {
	private WebDriver driver;
	private WebDriverWait wait;
	private LoginPage loginPage;
	private SecureAreaPage secureAreaPage;

	@Given(value = "user is on the login page")
	public void checkUserIsOnLoginPage() {
		driver = DriverFactory.getDriver();
        wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(10));
        loginPage = new LoginPage(driver, wait);
        secureAreaPage = new SecureAreaPage(driver, wait);

        loginPage.open();
        
		Assert.assertTrue(loginPage.isUsernameFieldDisplayed(), "when first loading the page, username field should be displayed.");
		Assert.assertTrue(loginPage.isPasswordFieldDisplayed(), "when first loading the page, password field should be displayed.");
		Assert.assertTrue(loginPage.isLoginButtonDisplayed(), "when first loading the page, login button field should be displayed.");
		Assert.assertTrue((driver.getCurrentUrl()).contains("/login"), 
				"When returning back to login screen, url should have contained \"/login");
	}

	@When(value = "user logs in with valid credentials")
	public void loginWithValidCredentials() {
		loginPage.loginAs(LoginTestData.VALID_USERNAME, LoginTestData.VALID_PASSWORD);
	}

	@Then (value = "user should be navigated to the secure area")
	public void validateUserIsOnSecureArea() {
		Assert.assertTrue(secureAreaPage.getSecureAreaMessage().contains(LoginTestData.SECURE_AREA_MESSAGE),
				"expected message was not retrieved when logging in.");

		Assert.assertTrue((driver.getCurrentUrl()).contains("/secure"), 
				"did not have expected url containing \"/secure");
	}

//	@After
//	public void teardown() {
//		if(driver != null)driver.quit();
//	}
}
