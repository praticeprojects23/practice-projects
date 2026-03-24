package com.practice.tests.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.practice.framework.config.ConfigReader;
import com.practice.tests.base.BaseTest;
import com.practice.tests.testdata.LoginTestData;

public class SuccessfulLoginPracticeTest extends BaseTest {
	@Test
	public void validLoginThenLogoutShouldReturnToLoginPage() {
		driver.get(ConfigReader.getProperty("baseUrl"));
		System.out.println("current url: " + driver.getCurrentUrl());

		WebElement username = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username"))); 
		WebElement password = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
		WebElement submitButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit']")));

		username.sendKeys(LoginTestData.VALID_USERNAME);
		password.sendKeys(LoginTestData.VALID_PASSWORD);			
		submitButton.click();

		Assert.assertTrue(driver.getCurrentUrl().contains("/secure"), 
				"The url should have contained /secure to indicate it has successfully logged in.");

		String expectedMessage = "Welcome to the Secure Area. When you are done click logout below";
		String receivedconfirmationMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("subheader"))).getText().trim();
		Assert.assertTrue(receivedconfirmationMessage.contains(expectedMessage), "subheading text should had been: Welcome to the Secure Area. When you are done click logout below");

		WebElement logoutButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[id='content'] i.icon-signout")));
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
}
