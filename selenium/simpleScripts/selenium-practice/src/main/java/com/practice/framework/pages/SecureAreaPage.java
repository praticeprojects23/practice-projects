package com.practice.framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SecureAreaPage {
	private WebDriverWait wait;

	private By loginMessage = By.className("subheader");
	private By logoutButton = By.cssSelector("div[id='content'] i.icon-signout");

	public SecureAreaPage(WebDriverWait wait){
		this.wait = wait;
	}

	public String getSuccessfulLoginMessage() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(loginMessage)).getText().trim();
	}

	public void clickLogoutButton() {
		wait.until(ExpectedConditions.elementToBeClickable(logoutButton)).click();	
	}

	public boolean isLogoutButtonDisplayed() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(logoutButton)).isDisplayed();
	}
}
