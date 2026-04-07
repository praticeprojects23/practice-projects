package com.practice.tests.stepdefinitions;

import java.nio.file.Paths;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.practice.framework.driver.DriverFactory;
import com.practice.framework.pages.SubmissionPage;
import com.practice.framework.pages.WebFormPage;
import com.practice.framework.utils.WaitUtils;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class WebFormSteps {
	private WebDriver driver;
	private WebDriverWait wait;
	private WebFormPage wfp;
	private SubmissionPage sp;

	@Given("user is on the Selenium web form page")
	public void userIsOnTheWebFormPage() {
		driver = DriverFactory.getDriver();
		wait = WaitUtils.createWait(driver);
		wfp = new WebFormPage(driver, wait);
		wfp.open();
	}

	@When("user selects {string} from the select dropdown")
	public void userSelectsOption (String choice) {
		wfp.selectOptionByVisibleText(choice);
	}

	@When("user selects option at index {int} from the select dropdown")
	public void userSelectsOptionAtIndex(int index) {
		wfp.selectOptionByIndex(index);
	}

	@Then("{string} should be selected in the select dropdown")
	public void selectedOptionShouldBe(String expectedDropdownValue) {
		Assert.assertEquals(wfp.getSelectedOptionText(), expectedDropdownValue);
	}

	@When("user enters {string} into the datalist")
	public void selectDatalistValue(String text) {
		wfp.setDatalistValue(text);
	}

	@Then("{string} should be retrieved from the datalist")
	public void confirmDatalistValue(String expected) {
		Assert.assertEquals(wfp.getDatalistValue(), expected);
	}

	@When ("user enters {string} into the text input")
	public void setText(String textInput) {
		wfp.setTextAreaText(textInput);
	}

	@Then("the text input value should be {string}")
	public void confirmStoredInputValue(String expected) {
		Assert.assertEquals(wfp.getTextAreaText(), expected);
	}

	/*text area*/

	@When("user enters the following text into the textarea:")
	public void user_enters_the_following_text_into_the_textarea(String docString) {
		wfp.setTextAreaText(docString);
	}
	@Then("the textarea value should be:")
	public void the_textarea_value_should_be(String docString) {
		Assert.assertEquals(wfp.getTextAreaText(), docString);
	}

	/*checkbox*/
	//helper method to simplify
	private void assertCheckboxSelectionState(String checkboxName, boolean expected) {
		Assert.assertEquals(wfp.isCheckboxSelected(checkboxName), expected);
	}

	@When("user unselects the {string} checkbox")
	public void unselectCheckbox(String selector) {
		wfp.unselectCheckbox(selector);
	}

	@When("user selects the {string} checkbox")
	public void selectCheckbox(String selector) {
		wfp.selectCheckbox(selector);
	}

	@Then("the {string} checkbox should be selected")
	public void checkboxShouldBeSelected(String checkboxName) {
		assertCheckboxSelectionState(checkboxName, true);
	}

	@Then("the {string} checkbox should not be selected")
	public void checkboxShouldNotBeSelected(String checkboxName) {
		assertCheckboxSelectionState(checkboxName, false);
	}

	/*radio button*/

	@When("user selects the {string} radio button")
	public void checkRadioButton(String locator) {
		wfp.selectRadio(locator);
	}

	@Then("the {string} radio button should be selected")
	public void checkRadioButtonIsSelected(String selector) {
		Assert.assertEquals(wfp.isRadioSelected(selector), true);
	}

	@Then("the {string} radio button should not be selected")
	public void checkRadioButtonIsNotSelected(String selector) {
		Assert.assertEquals(wfp.isRadioSelected(selector), false);
	}

	/*file input*/
	@When("user uploads a file")
	public void uploadFile() {
		String filePath = Paths.get("src", "test", "resources", "testdata", "upload-test.txt")
				.toAbsolutePath()
				.toString();

		wfp.uploadFile(filePath);
	}

	@Then("the uploaded file name should be shown")
	public String getFileName() {
		return wfp.getFilename();
	}

	/*date*/
	@When("user selects a date {string}")
	public void selectDate(String dateToSet) {
		wfp.setDate(dateToSet);
	}

	@Then("the displayed date should be shown as {string}")
	public void checkDisplayedDate(String expectedDate) {
		Assert.assertEquals(wfp.getDate(), expectedDate);
	}

	/*color input field*/
	@When("user sets the color picker to {string}")
	public void setColor(String color) {
		wfp.setColor(color);
	}

	@Then("the color picker value should be {string}")
	public void checkSelectedColor(String expectedColor) {
		Assert.assertEquals(wfp.getColor(), expectedColor);
	}

	/*range input field*/
	@When("user sets the range value to {string}")
	public void setRangeValue(String value) {
		wfp.setRangeValue(value);
	}

	@Then("the range value should be {string}")
	public void checkRangeValue(String expectedRangeValue) {
		Assert.assertEquals(wfp.getRangeValue(), expectedRangeValue);
	}

	/*password*/
	@When("user enters {string} into the password field")
	public void enterPassword(String password) {
		wfp.setPassword(password);
	}

	@Then("the password field value should be {string}")
	public void checkPassword(String expectedPassword) {
		Assert.assertEquals(wfp.getPasswordValue(), expectedPassword);
	}

	/*disabled input*/
	@Then("the disabled input should not be enabled")
	public void checkDisabledInputState() {
		Assert.assertFalse(wfp.isDisabledInputEnabled()); 
	}

	@Then("the readonly input should be readonly")
	public void checkReadOnlyInputState() {
		Assert.assertTrue(wfp.isReadonlyInputReadonly());	
	}

	@When("user clicks the submit button")
	public void clickSubmitButton() {
		wfp.clickSubmit();
		sp = new SubmissionPage(driver, wait);
	}

	@Then("the form should be submitted")
	public void confirmFormSubmission() {
		Assert.assertEquals(sp.getSubmissionMessage(), "Form submitted");
		Assert.assertTrue(sp.confirmSubmissionPageURL());
	}
}