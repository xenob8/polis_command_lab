package com.example.polis_command_lab.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ChatDialog {

    public final static By DIALOG_BY = By.xpath(".//msg-chats-list-item");
    public final WebElement item;
    public final String lastMsg;
    private static final By WHO = By.xpath(".//div[@data-tsid='conversation_name']//msg-parsed-text");
    private static final By LAST_MSG = By.xpath(".//div[@data-tsid='last_message']//msg-parsed-text");
    public final String name;


    public ChatDialog(WebElement el) {
        item = el;
        name = item.findElement(WHO).getText();
        lastMsg = item.findElement(LAST_MSG).getText();
    }

    public void click() {
        item.click();
    }
}
