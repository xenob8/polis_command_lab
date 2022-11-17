package com.example.polis_command_lab.pageobjects;

import com.example.polis_command_lab.MyDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.LinkedList;

public class LeftSideMessageMenu {

    public final static By LEFT_SIDE_MENU_BY = By.xpath("//msg-chats-list[@class='custom-scrollbar']");
    private final WebElement item;
    public final LinkedList<ChatDialog> dialogs = new LinkedList<>();

    public LeftSideMessageMenu(MyDriver driver, By root) {
        item = driver.findElement(root);
        item.findElements(ChatDialog.DIALOG_BY).forEach(el -> dialogs.add(new ChatDialog(el)));
    }
}
