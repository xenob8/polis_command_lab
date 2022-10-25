package com.example.polis_command_lab;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

import static com.example.polis_command_lab.Constants.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class DialogueTest {
    public WebDriver driver;

    @BeforeEach
    public void setup() {
        System.setProperty("webdriver.chrome.driver", DRIVER_PATH);
        ChromeOptions options = new ChromeOptions();
        options.setBinary(CHROME_PATH);
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(URL);
    }

    @Test
    @Order(1)
    public void messageSendCheck() {
        //LOGIN_SENDER="technoPol2";
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginAs(LOGIN_SENDER, PASSWORD_SENDER).clickMessageButton().sendMessage(USERNAME_RECEIVER, MESSAGE);
    }

    @Test
    @Order(2)
    public void messageReceiveCheck() {
        //LOGIN_RECEIVER="technoPol30";
        LoginPage loginPage = new LoginPage(driver);
        MessagePage messagePage = (loginPage.loginAs(LOGIN_RECEIVER, PASSWORD_RECEIVER)).clickMessageButton();
        assertEquals(messagePage.getLastMessageFrom(USERNAME_SENDER), MESSAGE);
    }

    @AfterEach
    public void quit() {
        driver.quit();
    }
}
