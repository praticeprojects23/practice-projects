package com.practice.framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SubmissionPage {
	private WebDriver driver;
	private WebDriverWait wait;
	private By submissionHeader = By.cssSelector("h1");

	public SubmissionPage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
	}

	private WebElement getWebElement(By locator) {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	public boolean confirmSubmissionPageURL() {
		wait.until(ExpectedConditions.urlContains("submitted"));
		return driver.getCurrentUrl().contains("submitted");
	}

	public String getSubmissionMessage() {
		wait.until(ExpectedConditions.urlContains("submitted"));
		return getWebElement(submissionHeader).getText();
	}

}
