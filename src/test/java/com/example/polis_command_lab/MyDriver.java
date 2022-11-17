package com.example.polis_command_lab;

import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MyDriver extends ChromeDriver implements IDriverDecorator {
    public MyDriver() {
    }

    public MyDriver(ChromeDriverService service) {
        super(service);
    }

    public MyDriver(Capabilities capabilities) {
        super(capabilities);
    }

    public MyDriver(ChromeOptions options) {
        super(options);
    }

    public MyDriver(ChromeDriverService service, ChromeOptions options) {
        super(service, options);
    }

    public MyDriver(ChromeDriverService service, Capabilities capabilities) {
        super(service, capabilities);
    }

    @Override
    public void waitVisible(By by, Duration duration) {
        new WebDriverWait(this, duration).until(ExpectedConditions.visibilityOfElementLocated(by));
    }
}
