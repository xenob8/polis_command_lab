package com.example.polis_command_lab;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.text.MessageFormat;

public class MessagePage {
    public final WebDriver driver;
    public final String TITLE = "Одноклассники";

    public final String msgDivTemplateXpath = "//msg-chats-list//a/msg-avatar[@caption={0}]";
    public final String lastMsgTemplateXpath = "//msg-chats-list//a/msg-avatar[@caption={0}]/../div[@data-tsid=\"last_message\"]//msg-parsed-text";

    public By friendLocator;
    public final By activeTypingLocator = By.xpath("//msg-input[@placeholder='Напишите сообщение...']");
    public final By typingField = By.xpath("//msg-input[@placeholder='Напишите сообщение...']/div");
    public final By sendMessageButton = By.xpath("//div[@class='buttons __right']/msg-button[@data-l='t,sendButton']");
    public By lastMessageFromSenderLocator;

    public MessagePage(WebDriver driver) {
        this.driver = driver;
        if (!TITLE.equals(driver.getTitle())) {
            throw new IllegalStateException("Not a Message page");
        }
    }

    //todoWithParam
    public MessagePage clickFriend(String friendName) {
        friendLocator = By.xpath(MessageFormat.format(msgDivTemplateXpath, "'" + friendName + "'"));
        driver.findElement(friendLocator).click();
        return this;
    }

    public MessagePage activeTypeField() {
        driver.findElement(activeTypingLocator).click();
        return this;
    }

    public MessagePage typeMessage(String message) {
        driver.findElement(typingField).sendKeys(message);
        return this;
    }

    public MessagePage sumbitMessage() {
        driver.findElement(sendMessageButton).click();
        return this;
    }

    public MessagePage sendMessage(String receiver, String message) {
        clickFriend(receiver);
        activeTypeField();
        typeMessage(message);
        sumbitMessage();
        return this;
    }

    public String getLastMessageFrom(String username) {
        String lastMsgStr = MessageFormat.format(lastMsgTemplateXpath, "'" + username + "'");
        lastMessageFromSenderLocator = By.xpath(lastMsgStr);
        return driver.findElement(lastMessageFromSenderLocator).getText();
    }

}
