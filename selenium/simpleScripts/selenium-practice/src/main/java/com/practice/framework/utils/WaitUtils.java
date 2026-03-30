package com.practice.framework.utils;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.practice.framework.config.ConfigReader;

public class WaitUtils {

    private WaitUtils() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }

    public static WebDriverWait createWait(WebDriver driver) {
        int waitTime = Integer.parseInt(ConfigReader.getProperty("explicitWait"));
        return new WebDriverWait(driver, Duration.ofSeconds(waitTime));
    }
}