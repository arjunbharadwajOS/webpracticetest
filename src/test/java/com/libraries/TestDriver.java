package com.libraries;

import org.openqa.selenium.WebDriver;

public class TestDriver {
    public static WebDriver driver;
    public static WebDriver getDriver() {
        return driver;
    }

    public static void setDriver(WebDriver driver) {
        TestDriver.driver = driver;
    }
}
