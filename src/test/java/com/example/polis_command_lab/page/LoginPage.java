package com.example.polis_command_lab.page;

import com.example.polis_command_lab.MyDriver;
import com.example.polis_command_lab.valueobject.TestBot;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.LoadableComponent;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;


public class LoginPage extends LoadableComponent<LoginPage> {
    private static final By USERNAME = By.xpath("//*[@id=\"field_email\"]");
    private static final By PASSWORD = By.xpath("//*[@id=\"field_password\"]");
    private static final By LOGIN_BTN = By.xpath("//*[@value='Войти в Одноклассники']");
    private static final By ROOT_BLOCK = By.id("hook_Block_AnonymMain");

    private final MyDriver driver;

    public LoginPage(MyDriver driver) {
        this.driver = driver;
        get();
    }

    public void typeUsername(String username) {
        driver.findElement(USERNAME).sendKeys(username);
    }

    public void typePassword(String password) {
        driver.findElement(PASSWORD).sendKeys(password);
    }

    public void submitLogin() {
        driver.findElement(LOGIN_BTN).submit();
    }

    public UserPage loginAs(TestBot bot) {
        typeUsername(bot.getLogin());
        typePassword(bot.getPassword());
        submitLogin();
        return new UserPage(driver);
    }

    public UserPage loginAs(String username, String password) {
        typeUsername(username);
        typePassword(password);
        submitLogin();
        return new UserPage(driver);
    }

    @Override
    protected void load() {

    }

    @Override
    protected void isLoaded() throws Error {
        assertDoesNotThrow(() -> driver.waitVisible(ROOT_BLOCK, Duration.ofSeconds(10)), "не загрузилось");
    }
}
