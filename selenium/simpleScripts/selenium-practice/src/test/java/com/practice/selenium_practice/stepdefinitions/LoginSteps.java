package com.practice.selenium_practice.stepdefinitions;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.practice.selenium_practice.pages.LoginPage;
import com.practice.selenium_practice.pages.SecureAreaPage;
import com.practice.selenium_practice.testdata.LoginTestData;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {
	private WebDriver driver;
	private WebDriverWait wait;
	private LoginPage loginPage;
	private SecureAreaPage secureAreaPage;

	@Before
	public void setup() {
		driver = new ChromeDriver();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.get(LoginTestData.BASE_URL);

		loginPage = new LoginPage(driver, wait);
		secureAreaPage = new SecureAreaPage(wait);
	}

	@Given(value = "user is on the login page")
	public void checkUserIsOnLoginPage() {
		Assert.assertTrue(loginPage.isUsernameFieldDisplayed(), "when first loading the page, username field should be displayed.");
		Assert.assertTrue(loginPage.isPasswordFieldDisplayed(), "when first loading the page, password field should be displayed.");
		Assert.assertTrue(loginPage.isLoginButtonDisplayed(), "when first loading the page, login button field should be displayed.");
		Assert.assertTrue((driver.getCurrentUrl()).contains("/login"), 
				"When returning back to login screen, url should have contained \"/login");
	}

	@When(value = "user logs in with valid credentials")
	public void loginWithValidCredentials() {
		loginPage.login(LoginTestData.VALID_USERNAME, LoginTestData.VALID_PASSWORD);
	}

	@Then (value = "user should be navigated to the secure area")
	public void validateUserIsOnSecureArea() {
		Assert.assertTrue(secureAreaPage.getSuccessfulLoginMessage().contains(LoginTestData.SECURE_AREA_MESSAGE),
				"expected message was not retrieved when logging in.");

		Assert.assertTrue((driver.getCurrentUrl()).contains("/secure"), 
				"did not have expected url containing \"/secure");
	}

	@After
	public void teardown() {
		if(driver != null)driver.quit();
	}
}
