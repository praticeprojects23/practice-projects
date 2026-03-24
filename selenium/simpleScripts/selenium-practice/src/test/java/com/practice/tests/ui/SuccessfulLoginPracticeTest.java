package com.practice.tests.ui;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SuccessfulLoginPracticeTest {
	WebDriver driver;
	WebDriverWait wait;
	String baseURL;
	WebElement logoutButton;
	WebElement username;
	WebElement password;

	@BeforeMethod
	public void setup(){
		driver = new ChromeDriver();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		baseURL = "https://the-internet.herokuapp.com/login";
	}

	@Test
	public void validLoginThenLogoutShouldReturnToLoginPage() {
		System.out.println("navigating to url");
		driver.get(baseURL);
		System.out.println("current url: " + driver.getCurrentUrl());

		username = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username"))); 
		password = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
		WebElement submitButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit']")));

		username.sendKeys("tomsmith");
		password.sendKeys("SuperSecretPassword!");			
		submitButton.click();

		//converted to an assert
		Assert.assertTrue(driver.getCurrentUrl().contains("/secure"), 
				"The url should have contained /secure to indicate it has successfully logged in.");

		//converted to an assert
		String expectedMessage = "Welcome to the Secure Area. When you are done click logout below";
		String receivedconfirmationMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("subheader"))).getText().trim();
		Assert.assertTrue(receivedconfirmationMessage.contains(expectedMessage), "subheading text should had been: Welcome to the Secure Area. When you are done click logout below");
		// adding assertion for presence of logout button
		logoutButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[id='content'] i.icon-signout")));
		Assert.assertTrue(logoutButton.isDisplayed(), "Logout button should be present"); 
		
		/*Logout part*/
		logoutButton.click();
		Assert.assertTrue(driver.getCurrentUrl().contains("/login"), 
				"The url should have contained /login to indicate it has successfully return to login page.");
		expectedMessage = "You logged out of the secure area!";
		username = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username"))); 
		password = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
		receivedconfirmationMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[id='flash-messages'] div.flash.success"))).getText().trim();
		Assert.assertTrue(receivedconfirmationMessage.contains(expectedMessage), "subheading text should had been: " +expectedMessage);
		
	}

	@AfterMethod
	public void teardown(){
		driver.quit();
		System.out.println("closed session fully.");
	}
}
