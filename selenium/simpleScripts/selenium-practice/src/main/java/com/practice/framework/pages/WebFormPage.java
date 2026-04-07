package com.practice.framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.practice.framework.config.ConfigReader;

public class WebFormPage {

	private WebDriver driver;
	private WebDriverWait wait;

	private By selectDropdown = By.name("my-select");
	private By datalistDropdown = By.name("my-datalist");

	private By textInput = By.id("my-text-id");
	private By textArea = By.name("my-textarea");

	private By checkedCheckbox = By.id("my-check-1");
	private By defaultCheckbox = By.id("my-check-2");

	private By checkedRadio = By.id("my-radio-1");
	private By defaultRadio = By.id("my-radio-2");

	private By fileInput = By.cssSelector("input[type='file']");
	private By datePicker = By.name("my-date");

	private By colorPicker = By.name("my-colors");

	private By rangePicker = By.name("my-range");

	private By passwordInput = By.name("my-password");
	private By disabledInput = By.cssSelector("input[disabled]");
	private By readonlyInput = By.cssSelector("input[readonly]");	
	private By submitButton = By.cssSelector("button[type=submit]");

	public WebFormPage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
	}

	private WebElement getWebElement(By locator) {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	private Select getSelectDropdown() {
		WebElement dropdownElement = getWebElement(selectDropdown);
		return new Select(dropdownElement);
	}

	public void open() {
		driver.get(ConfigReader.getProperty("webFormUrl"));
	}
	//select 

	public void selectOptionByVisibleText(String text) {
		getSelectDropdown().selectByVisibleText(text);
	}

	public String getSelectedOptionText() {
		return getSelectDropdown().getFirstSelectedOption().getText();
	}

	public void selectOptionByIndex(int index) {
		getSelectDropdown().selectByIndex(index);
	}

	//datalist related methods
	public String getDatalistValue() {
		return getWebElement(datalistDropdown).getAttribute("value");
	}

	public void setDatalistValue(String text) {
		WebElement datalist = getWebElement(datalistDropdown);
		datalist.clear();
		datalist.sendKeys(text);
	}

	//textInput
	public void setInputText(String text) {
		WebElement inputField = getWebElement(textInput);
		inputField.clear();
		inputField.sendKeys(text);
	}

	public String getInputText() {
		return getWebElement(textInput).getAttribute("value");
	}

	//textArea
	public void setTextAreaText(String text) {
		WebElement textAreaField = getWebElement(textArea);
		textAreaField.clear();
		textAreaField.sendKeys(text);
	}

	public String getTextAreaText() {
		return getWebElement(textArea).getAttribute("value");
	}

	//checkbox and radio buttons
	//two helper methods
	private By getCheckboxLocator(String checkboxName) {
		switch (checkboxName.toLowerCase()) {
		case "checked":
			return checkedCheckbox;
		case "default":
			return defaultCheckbox;
		default:
			throw new IllegalArgumentException("Unknown checkbox: " + checkboxName);
		}
	}

	private By getRadioLocator(String radioName) {
		switch (radioName.toLowerCase()) {
		case "checked":
			return checkedRadio;
		case "default":
			return defaultRadio;
		default:
			throw new IllegalArgumentException("Unknown radio button: " + radioName);
		}
	}

	public void unselectCheckbox(String checkboxName) {
		WebElement checkbox = getWebElement(getCheckboxLocator(checkboxName));
		if (checkbox.isSelected()) {
			checkbox.click();
		}
	}

	public void selectCheckbox(String checkboxName) {
		WebElement checkbox = getWebElement(getCheckboxLocator(checkboxName));
		if (!checkbox.isSelected()) {
			checkbox.click();
		}
	}

	public boolean isCheckboxSelected(String checkboxName) {
		return getWebElement(getCheckboxLocator(checkboxName)).isSelected();
	}

	public void selectRadio(String radioName) {
		WebElement radio = getWebElement(getRadioLocator(radioName));
		if (!radio.isSelected()) {
			radio.click();
		}
	}

	public boolean isRadioSelected(String radioName) {
		return getWebElement(getRadioLocator(radioName)).isSelected();
	}

	//file input
	public void uploadFile(String filePath) {
		getWebElement(fileInput).sendKeys(filePath);
	}

	public String getFilename() {
		return getWebElement(fileInput).getAttribute("value");
	}

	//date input

	public void setDate(String date) {
		WebElement dateInputField = getWebElement(datePicker);
		dateInputField.clear();
		dateInputField.sendKeys(date);
	}

	public String getDate() {
		return getWebElement(datePicker).getAttribute("value");
	}

	//colors input field, treat it as input field, value
	public void setColor(String colorValue) {
		WebElement colorInputField = getWebElement(colorPicker);
		colorInputField.clear();
		colorInputField.sendKeys(colorValue);
	}

	public String getColor() {
		return getWebElement(colorPicker).getAttribute("value");
	}

	public void setRangeValue(String value) {
		WebElement range = getWebElement(rangePicker);
		((org.openqa.selenium.JavascriptExecutor) driver)
		.executeScript("arguments[0].value = arguments[1];", range, value);
	}

	public String getRangeValue() {
		return getWebElement(rangePicker).getAttribute("value");
	}

	// password
	public void setPassword(String text) {
		WebElement passwordField = getWebElement(passwordInput);
		passwordField.clear();
		passwordField.sendKeys(text);
	}

	public String getPasswordValue() {
		return getWebElement(passwordInput).getAttribute("value");
	}

	// disabled
	public boolean isDisabledInputEnabled() {
		return getWebElement(disabledInput).isEnabled();
	}

	// readonly
	public boolean isReadonlyInputReadonly() {
		return getWebElement(readonlyInput).getAttribute("readonly") != null;
	}

	public String getReadonlyInputValue() {
		return getWebElement(readonlyInput).getAttribute("value");
	}

	// submit
	public void clickSubmit() {
		getWebElement(submitButton).click();
	}
	
}