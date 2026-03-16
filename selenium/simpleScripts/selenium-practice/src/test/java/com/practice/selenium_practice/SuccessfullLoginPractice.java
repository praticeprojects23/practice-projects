package com.practice.selenium_practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class SuccessfullLoginPractice {
	public static void main (String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		/*
		 * implicit await vs explicit await
		We can set the implicit wait to 10 seconds with the following statement. 
		We should set the implicit wait right after initializing the WebDriver instance.

		An explicit wait is a more flexible wait that allows us to wait
		 for a specific condition to be met before continuing test execution.
		 */

		//commenting out as we will use explicit waits
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		try {
			System.out.println("navigating to url");
			driver.get("https://the-internet.herokuapp.com/login");
			System.out.println("current url: " + driver.getCurrentUrl());

			//basic manner of WebElement locating/storing
			//			WebElement username = driver.findElement(By.id("username"));
			//			WebElement password = driver.findElement(By.id("password"));
			//			WebElement submitButton = driver.findElement(By.cssSelector("button[type='submit']"));
			/* enhanced version of above 3
			locate all necessary controls
			additionally waiting for visibility
			 */

			WebElement username = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username"))); 
			WebElement password = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
			//clickable is more appropriate for something we intend to click on 
			WebElement submitButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit']")));

			/*various By examples*/
			//			WebElement submitButton = driver.findElement(By.tagName("button"));
			//			WebElement submitButton = driver.findElement(By.className("radius"));
			//using tag + attribute
			//			WebElement submitButton = driver.findElement(By.cssSelector("button[type='submit']"));


			//4. By CSS selector using class
			//			WebElement submitButton = driver.findElement(By.cssSelector("button.radius"));
			//5. 5. By XPath using tag + attribute
			//			WebElement submitButton = driver.findElement(By.xpath("//button[@type='submit']"));
			//6. By XPath using class
			//			WebElement submitButton = driver.findElement(By.xpath("//button[@class='radius']"));
			//7. XPath by text
			//			WebElement submitButton = driver.findElement(By.xpath("//i[contains(text(),'Login')]"));


			//perform actions: sendKeys(), click()
			username.sendKeys("tomsmith");
			password.sendKeys("SuperSecretPassword!");			
			submitButton.click();

			//waiting for the next page prior to further execution
			//validate that we made it to the page
			wait.until(ExpectedConditions.urlContains("/secure"));
			
			//String confirmationMessageString = driver.findElement(By.className("subheader")).getText();
			//enhancing above to check visibilty as well. 
			String confirmationMessageString = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("subheader"))).getText();
			
			System.out.println("text after logging in: " + confirmationMessageString);
			System.out.println("current url: " + driver.getCurrentUrl());

		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			System.out.println("closing browser session in 3 seconds.");
			Thread.sleep(3000);
			driver.quit();
			System.out.println("closed session fully.");
		}
	}
}
