package com.practice.tests.hooks;

import com.practice.framework.driver.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

    @Before
    public void setup() {
        DriverFactory.initDriver();
    }

    @After
    public void teardown() {
        DriverFactory.quitDriver();
    }
}