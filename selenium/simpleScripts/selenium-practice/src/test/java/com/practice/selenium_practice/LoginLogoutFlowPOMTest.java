package com.practice.selenium_practice;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.practice.selenium_practice.pages.LoginPage;
import com.practice.selenium_practice.pages.SecureAreaPage;

public class LoginLogoutFlowPOMTest {
	private WebDriver driver;
	private WebDriverWait wait;
	private String baseURL;

	@BeforeMethod
	public void setup() {
		driver = new ChromeDriver();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		baseURL = "https://the-internet.herokuapp.com/login";
	}

	@Test
	public void validLoginThenLogoutShouldReturnToLoginPage() {
		driver.get(baseURL);
		LoginPage loginPage = new LoginPage(driver, wait);
		SecureAreaPage secureAreaPage = new SecureAreaPage(wait);

		Assert.assertTrue(loginPage.isUsernameFieldDisplayed(), "after logging out, username field should be displayed.");
		Assert.assertTrue(loginPage.isPasswordFieldDisplayed(), "after logging out, password field should be displayed.");
		Assert.assertTrue(loginPage.isLoginButtonDisplayed(), "after logging out, login button field should be displayed.");

		loginPage.login("tomsmith","SuperSecretPassword!");

		String expectedMessage = "Welcome to the Secure Area. When you are done click logout below";
		Assert.assertTrue(secureAreaPage.getSuccessfulLoginMessage().contains(expectedMessage),
				"expected message was not retrieved when logging in.");

		Assert.assertTrue((driver.getCurrentUrl()).contains("/secure"), 
				"did not have expected url containing \"/secure");

		//logout test
		Assert.assertTrue(secureAreaPage.isLogoutButtonDisplayed(),"logout button should be be visible");
		secureAreaPage.clickLogoutButton();
		Assert.assertTrue((driver.getCurrentUrl()).contains("/login"), 
				"When returning back to login screen, url should have contained \"/login");

		Assert.assertTrue(loginPage.isUsernameFieldDisplayed(), "after logging out, username field should be displayed.");
		Assert.assertTrue(loginPage.isPasswordFieldDisplayed(), "after logging out, password field should be displayed.");
		Assert.assertTrue(loginPage.isLoginButtonDisplayed(), "after logging out, login button field should be displayed.");
		Assert.assertEquals(loginPage.getLogoutConfirmationMessage(), "You logged out of the secure area!");
	}

	@AfterMethod
	public void teardown() {
		driver.quit();
	}
}
