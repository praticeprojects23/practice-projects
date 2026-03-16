package com.practice.selenium_practice;

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

public class InvalidLoginPracticeTest {
	WebDriver driver;
	WebDriverWait wait;
	String baseUrl;
	
	@BeforeMethod
	public void setup() {
		driver = new ChromeDriver();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		baseUrl = "https://the-internet.herokuapp.com/login";
	}
	
	@Test
	public void invalidLoginShouldRemainOnLoginPage() {
		driver.get(baseUrl);
		
		//get our elements with proper visibility/clickable state checks
		WebElement username = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//form/div[1]/div/input[@id='username']")));
		WebElement password = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
		WebElement submit = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[type='submit']")));
		
		//perform operations
		username.sendKeys("tomsmith");
		password.sendKeys("wrongPassword1!");
		submit.click();
		
		//Assertion on invalid password
		WebElement failureDiv = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[id='flash-messages']")));
		String failureMessage = failureDiv.getText().trim();
		Assert.assertTrue(failureMessage.contains("Your password is invalid!"),
				"Expected invalid password message was not shown.");
		
		// Assert that url stayed on /login
		String currentPage = driver.getCurrentUrl();
		Assert.assertTrue(currentPage.contains("/login"),
				"Expected to remain on the login page after invalid login.");
		
	}
	
	@AfterMethod
	public void teardown() {
		System.out.println("quit browser as teardown.");
		driver.quit();
	}
}
