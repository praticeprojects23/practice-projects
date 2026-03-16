package com.practice.selenium_practice.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	private WebDriver driver;
	private WebDriverWait wait;

	//storing locators: use By. to be used later when locating WebElement for interactions.
	private By usernameField = By.id("username");
	private By passwordField = By.id("password");
	private By submitButton = By.xpath("//button[@type='submit']");
	private By logoutMessage = By.cssSelector("div[id='flash-messages'] div.flash.success");


	public LoginPage(WebDriver driver, WebDriverWait wait){
		this.driver = driver;
		this.wait = wait;
	}

	public boolean isUsernameFieldDisplayed() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(usernameField)).isDisplayed();
	}

	public boolean isPasswordFieldDisplayed() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(passwordField)).isDisplayed();

	}

	public boolean isLoginButtonDisplayed(){
		return wait.until(ExpectedConditions.visibilityOfElementLocated(submitButton)).isDisplayed();
	}

	public String getLogoutConfirmationMessage() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(logoutMessage)).getText().trim();
	}

	public void enterUsername(String username) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(this.usernameField)).sendKeys(username);
	}

	public void enterPassword(String password) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(this.passwordField)).sendKeys(password);
	}

	public void clickLoginButton() {
		wait.until(ExpectedConditions.elementToBeClickable(this.submitButton)).click();
	}

	public void login(String username, String password) {
		this.enterUsername(username);
		this.enterPassword(password);
		this.clickLoginButton();
	}
}
