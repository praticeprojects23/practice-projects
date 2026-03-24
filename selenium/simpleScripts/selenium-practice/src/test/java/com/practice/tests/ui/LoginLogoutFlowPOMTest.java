package com.practice.tests.ui;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.practice.framework.pages.LoginPage;
import com.practice.framework.pages.SecureAreaPage;
import com.practice.tests.base.BaseTest;
import com.practice.tests.testdata.LoginTestData;

public class LoginLogoutFlowPOMTest extends BaseTest{

	@Test
	public void validLoginThenLogoutShouldReturnToLoginPage() {
		LoginPage loginPage = new LoginPage(driver, wait);
		loginPage.open();

		SecureAreaPage secureAreaPage = new SecureAreaPage(driver, wait);

		Assert.assertTrue(loginPage.isUsernameFieldDisplayed(), "after logging out, username field should be displayed.");
		Assert.assertTrue(loginPage.isPasswordFieldDisplayed(), "after logging out, password field should be displayed.");
		Assert.assertTrue(loginPage.isLoginButtonDisplayed(), "after logging out, login button field should be displayed.");

		loginPage.loginAs(LoginTestData.VALID_USERNAME,LoginTestData.VALID_PASSWORD);

		Assert.assertTrue(secureAreaPage.getSecureAreaMessage().contains(LoginTestData.SECURE_AREA_MESSAGE),
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
		Assert.assertEquals(loginPage.getLogoutConfirmationMessage(), LoginTestData.LOGOUT_MESSAGE);
	}
}
