package com.example.polis_command_lab;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserPage {
    protected WebDriver driver;
    private final By messageLocator = By.xpath("//*[@class='toolbar_nav_i_ic']");

    public UserPage(WebDriver driver) {
        this.driver = driver;
    }

    public MessagePage clickMessageButton() {
        driver.findElement(messageLocator).click();

        return new MessagePage(driver);
    }
}
