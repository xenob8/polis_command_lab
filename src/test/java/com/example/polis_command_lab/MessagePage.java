package com.example.polis_command_lab;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MessagePage {
    public final WebDriver driver;
    public final String TITLE = " Одноклассники";


    public final By receiverFriendLocator = By.xpath("//msg-chats-list//a/msg-avatar[@caption='Bot Receiver']");
    public final By senderFriendLocator = By.xpath("//msg-chats-list//a/msg-avatar[@caption='Bot Sender']");
    public final By activeTypingLocator = By.xpath("//msg-input[@placeholder='Напишите сообщение...']");
    public final By typingField = By.xpath("//msg-input[@placeholder='Напишите сообщение...']/div");
    public final By sendMessageButton = By.xpath("//div[@class='buttons __right']/msg-button[@data-l='t,sendButton']");



    public MessagePage(WebDriver driver){
        this.driver = driver;
        if (!TITLE.equals(driver.getTitle()))
        {
            throw new IllegalStateException("Not a login page");
        }
    }

    //todoWithParam
//    public void clickFriend(String friendName){
//        "//msg-chats-list//a/msg-avatar[@caption={]"
//        friendLocator = By.xpath("//msg-chats-list//a/msg-avatar[@caption=frien]");
//    }

    public MessagePage clickSenderFriend(){
        driver.findElement(senderFriendLocator).click();
        return this;
    }

    public MessagePage clickReceiverFriend(){
        driver.findElement(receiverFriendLocator).click();
        return this;
    }

    public MessagePage activeTypeField(){
        driver.findElement(activeTypingLocator).click();
        return this;
    }

    public MessagePage typeMessage(String message){
        driver.findElement(typingField).sendKeys(message);
        return this;
    }

    public MessagePage sendMessage(){
        driver.findElement(sendMessageButton).click();
        return this;
    }

    public MessagePage sendMessageToReceiver(String message){
        clickReceiverFriend();
        activeTypeField();
        typeMessage(message);
        sendMessage();
        return this;
    }



}
