package com.libraries;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestDriverTest {
    @Test
    public void testDriverMethods() {
        // Create a mock WebDriver
        WebDriver mockDriver = Mockito.mock(WebDriver.class);

        // Set the mock driver
        TestDriver.setDriver(mockDriver);

        // Get the driver and assert it is the same as the mock driver
        WebDriver retrievedDriver = TestDriver.getDriver();
        assertEquals(mockDriver, retrievedDriver);
    }
}