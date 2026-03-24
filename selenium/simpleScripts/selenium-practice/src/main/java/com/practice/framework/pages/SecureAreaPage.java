package com.practice.framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SecureAreaPage {
	private WebDriver driver;
	private WebDriverWait wait;

	private By secureAreaMessage = By.className("subheader");
	private By logoutButton = By.xpath("//a[contains(@href,'/logout')]");
//    private By logoutButton = By.cssSelector("a.button.secondary.radius");


	public SecureAreaPage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
	}

	public String getSecureAreaMessage() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(secureAreaMessage)).getText().trim();
	}

	public void clickLogoutButton() {
	    wait.until(ExpectedConditions.elementToBeClickable(logoutButton)).click();
	}

	public boolean isLogoutButtonDisplayed() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(logoutButton)).isDisplayed();
	}
}
