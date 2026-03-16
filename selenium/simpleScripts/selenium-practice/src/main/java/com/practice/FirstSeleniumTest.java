package com.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstSeleniumTest {
    public static void main(String[] args) {
    	System.out.println("first line");
        WebDriver driver = new ChromeDriver();

        try {
            driver.get("https://example.com");

            WebElement heading = driver.findElement(By.tagName("h1"));
            System.out.println("Heading text: " + heading.getText());
        } finally {
        	 System.out.println("driver.quit()");
            driver.quit();
        }
        System.out.println("last line");
    }
}