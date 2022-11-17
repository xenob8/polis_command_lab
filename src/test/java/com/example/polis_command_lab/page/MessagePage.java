package com.example.polis_command_lab.page;

import com.example.polis_command_lab.MyDriver;
import com.example.polis_command_lab.pageobjects.ChatDialog;
import com.example.polis_command_lab.pageobjects.LeftSideMessageMenu;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.LoadableComponent;

import java.time.Duration;

public class MessagePage extends LoadableComponent<MessagePage> {

    public final MyDriver driver;

    private final static By MESSAGE_TAB = By.xpath("//div[@class='content']");

    public final LeftSideMessageMenu leftSideMessageMenu;

    public static final By TYPING_ACTIVATOR = By.xpath("//msg-input[@placeholder='Напишите сообщение...']");
    public static final By TYPING_FIELD = By.xpath("//msg-input[@placeholder='Напишите сообщение...']/div");
    public static final By SEND_MESSAGE_BTN = By.xpath("//div[@class='buttons __right']/msg-button[@data-l='t,sendButton']");

    public MessagePage(MyDriver driver) {
        this.driver = driver;
        get();
        leftSideMessageMenu = new LeftSideMessageMenu(driver, LeftSideMessageMenu.LEFT_SIDE_MENU_BY);
    }


    public MessagePage activeTypeField() {
        driver.findElement(TYPING_ACTIVATOR).click();
        return this;
    }

    public MessagePage typeMessage(String message) {
        driver.findElement(TYPING_FIELD).sendKeys(message);
        return this;
    }

    public MessagePage sumbitMessage() {
        driver.findElement(SEND_MESSAGE_BTN).click();
        return this;
    }

    public ChatDialog getDialogByName(String name) {
        return leftSideMessageMenu.dialogs.stream().filter(el -> el.name.equals(name)).findAny().orElse(null);
    }

    @Override
    protected void load() {
    }

    @Override
    protected void isLoaded() throws Error {
        Assertions.assertDoesNotThrow(() -> driver.waitVisible(MESSAGE_TAB, Duration.ofSeconds(5)));
    }
}
