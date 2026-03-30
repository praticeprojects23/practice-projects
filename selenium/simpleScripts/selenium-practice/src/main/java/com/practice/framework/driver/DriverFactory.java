package com.practice.framework.driver;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.practice.framework.config.ConfigReader;

public class DriverFactory {

	/*
	 * ThreadLocal: gives each thread its own separate copy of the driver.
	 * That makes the design safer and more scalable, even if you are not doing parallel runs yet.
	 */
	//
	private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();
	
	 // Private constructor to prevent instantiation
    private DriverFactory() {
        // Optionally, throw an exception to be explicit, even via reflection
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }

	public static void initDriver() {
		String browser = ConfigReader.getProperty("browser");
		boolean headless = Boolean.parseBoolean(ConfigReader.getProperty("headless"));
		if (browser.equalsIgnoreCase("chrome")) {
			ChromeOptions options = new ChromeOptions();

			if (headless) {
				options.addArguments("--headless=new");
			}
			options.addArguments("--disable-search-engine-choice-screen");
			options.addArguments("--password-store=basic");

			Map<String, Object> prefs = new HashMap<>();

			prefs.put("credentials_enable_service", false);
			prefs.put("profile.password_manager_enabled", false);
			prefs.put("profile.password_manager_leak_detection", false);

			options.setExperimentalOption("prefs", prefs);

			driver.set(new ChromeDriver(options));
		} else {	
			throw new IllegalArgumentException("Unsupported browser: " + browser);
		}

		getDriver().manage().window().maximize();
	}

	public static WebDriver getDriver() {
		if (driver.get() == null) {
			throw new IllegalStateException("Driver is not initialized. Call initDriver() first.");
		}
		return driver.get();
	}

	public static void quitDriver() {
		if (driver.get() != null) {
			driver.get().quit();
			driver.remove();
		}
	}
}