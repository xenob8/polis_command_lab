package com.example.polis_command_lab;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.example.polis_command_lab.Constants.LOGIN_PAGE_TITTLE;

public class LoginPage {
    By usernameLocator_ = By.xpath("//*[@id=\"field_email\"]");
    By passwordLocator_ = By.xpath("//*[@id=\"field_password\"]");
    By loginButtonLocator_ = By.xpath("//*[@value='Войти в Одноклассники']");

    private final WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        if (!LOGIN_PAGE_TITTLE.equals(this.driver.getTitle())) {
            throw new IllegalStateException("Not a login page");
        }
    }

    public void typeUsername(String username) {
        driver.findElement(usernameLocator_).sendKeys(username);
    }

    public void typePassword(String password) {
        driver.findElement(passwordLocator_).sendKeys(password);
    }

    public UserPage submitLogin() {
        driver.findElement(loginButtonLocator_).submit();
        return new UserPage(driver);
    }

    public UserPage loginAs(String username, String password) {
        typeUsername(username);
        typePassword(password);
        return submitLogin();
    }
}
