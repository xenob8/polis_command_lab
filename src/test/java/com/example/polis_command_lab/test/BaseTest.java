package com.example.polis_command_lab.test;

import com.example.polis_command_lab.MyDriver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.time.Duration;

public class BaseTest {

    protected static final String URL = "https://ok.ru/";
    private static final ChromeOptions options = new ChromeOptions().addArguments("--lang=ru");
    public MyDriver driver;

    @BeforeEach
    public void enter() {
        driver = getNewDriver();
        driver.get(URL);
    }

    public MyDriver getNewDriver() {
        driver = new MyDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        return driver;
    }

    @AfterEach()
    public void quit() {
        driver.quit();
    }
}
