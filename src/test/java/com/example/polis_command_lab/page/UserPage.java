package com.example.polis_command_lab.page;

import com.example.polis_command_lab.MyDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.LoadableComponent;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class UserPage extends LoadableComponent<UserPage> {
    private final MyDriver driver;
    private final static By MESSAGE_ICON = By.xpath("//*[@class='toolbar_nav_i_ic']");
    private final static By USER_PROFILE_BTN = By.xpath("//div[@class='tico ellip']");

    public UserPage(MyDriver driver) {
        this.driver = driver;
        get();
    }

    public MessagePage clickMessageButton() {
        driver.findElement(MESSAGE_ICON).click();
        return new MessagePage(driver);
    }

    public String getUserName(){
        return driver.findElement(USER_PROFILE_BTN).getText();
    }

    @Override
    protected void load() {

    }

    @Override
    protected void isLoaded() throws Error {
        assertDoesNotThrow(() -> driver.waitVisible(USER_PROFILE_BTN, Duration.ofSeconds(5)),
                "user component didnt load");
    }
}
