package com.practice.tests.hooks;

import com.practice.framework.driver.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

    @Before
    public void setup() {
    	System.out.println("HOOKS BEFORE RUNNING");
        DriverFactory.initDriver();
    }

    @After
    public void teardown() {
    	System.out.println("HOOKS AFTER RUNNING");
        DriverFactory.quitDriver();
    }
}